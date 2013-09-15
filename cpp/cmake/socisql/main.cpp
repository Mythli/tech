#include <iostream>

#include "soci.h"
#include "soci-sqlite3.h"

int main(int argc, char **argv) {
	soci::session sql(soci::sqlite3, "data/test.sqlite");
	
	soci::rowset<soci::row> testData = (sql.prepare << "select id, name from test");
	
	for (soci::rowset<soci::row>::const_iterator it = testData.begin(); it != testData.end(); ++it) {
		soci::row const& row = *it;
		
		std::cout << "Id: " << row.get<int>(0) << std::endl;
		std::cout << "Name: " << row.get<std::string>(1) << std::endl;
		std::cout << std::endl;
	}
	
    return 0;
}
