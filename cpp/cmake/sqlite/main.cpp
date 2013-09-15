#include <iostream>
#include <sqlite3.h>

int main(int argc, char **argv) {
	std::string databaseFile = "data/test.sqlite";
	
	sqlite3* database = 0;
	int connectStatusCode = 0;
	
	std::cout << "Opening database..." << std::endl;
	std::cout << "Database file: " << databaseFile << std::endl;
	connectStatusCode = sqlite3_open(databaseFile.c_str(), &database);
		
	if(connectStatusCode) {
		std::cout << "Failed to open database: " << sqlite3_errmsg(database) << std::endl;
		sqlite3_close(database);
		return(1);
	}
	
	int result = 0;
	sqlite3_stmt* statement;
	
	std::string query = "select * from test where name = ? or name = 'yolo';";
	std::cout << "Preparing query..." << std::endl;
	std::cout << "Query: " << query << std::endl; 
	result = sqlite3_prepare_v2(database, query.c_str(), query.length()+1, &statement, 0);
		
	std::string searchName = "test";
	std::cout << "Binding parameter..." << std::endl;
	std::cout << "Parameter: " << searchName << std::endl; 
	sqlite3_bind_text(statement, 1, searchName.c_str(), -1, SQLITE_TRANSIENT);
	
	if(result != SQLITE_OK) {
		std::cout << "Failed to prepare query: " << sqlite3_errstr(result) << std::endl;
		sqlite3_close(database);
		return(1);
	}
	
	while (sqlite3_step(statement) == SQLITE_ROW) {
		int id = sqlite3_column_int(statement, 0);
		char* name = (char*)sqlite3_column_text(statement, 1);
		
		std::cout << "Id: " << id << std::endl;
		std::cout << "Name: " << std::string(name) << std::endl;
		
	}
	sqlite3_finalize(statement);
	return 0;
}
