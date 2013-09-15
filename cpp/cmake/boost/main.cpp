#include <iostream>
#include <boost/shared_ptr.hpp>

int main(int argc, char **argv) {
	boost::shared_ptr<std::string> sharedStr(new std::string("yolo bitches"));
	
	
    std::cout << sharedStr->c_str() << std::endl;
    return 0;
}
