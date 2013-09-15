#include <iostream>
#include <boost/program_options.hpp>

int main(int argc, char **argv) {
	// initialization
	float optionBinded = 0.0;
	float optionDefaultValue = 0.0;
	std::vector<std::string> optionMultipleStrings;
	
	boost::program_options::options_description description("Allowed options");
	description.add_options()
		("help", "displays help message")
		("integer", boost::program_options::value<int>(), "set an integer value (--integer 10)")
		("string", boost::program_options::value<std::string>(), "set an string value (--string aa)")
		("bind", boost::program_options::value<float>(&optionBinded), "automatic bind to variable (--bind 10.5)")
		("default", boost::program_options::value<float>(&optionDefaultValue)->default_value(10.5), "default value (default: 10.5)")
		("short,s", boost::program_options::value<std::string>(), "short argument notation (--short -s aa)")
		("multiple,m", boost::program_options::value<std::vector<std::string> >(&optionMultipleStrings)->multitoken(), "multiple strings (--multiple aa bb)")
	;
	
	boost::program_options::variables_map options;
	boost::program_options::store(boost::program_options::parse_command_line(argc, argv, description), options);
	boost::program_options::notify(options);
	
	// check option
	if(options.count("help")) {
		std::cout << description << std::endl;
	}
	
	// simple integer option
	if(options.count("integer")) {
		std::cout << "Integer value: " << options["integer"].as<int>() << std::endl;
	}
	
	// simple string option
	if(options.count("string")) {
		std::cout << "String value: " << options["string"].as<std::string>() << std::endl;
	}
	
	// option binding
	if(options.count("bind")) {
		std::cout << "Bind value: " << optionBinded << std::endl;
	}
	
	// option with default value
	std::cout << "Default value: " << optionDefaultValue << std::endl;
	
	// option with short notation
	if(options.count("short")) {
		std::cout << "Short value: " << options["short"].as<std::string>() << std::endl;
	}
	
	// option with multiple strings
	if(options.count("multiple")) {
		std::cout << "Multiple Strings: " << optionMultipleStrings.size() << std::endl;
		for(std::vector<std::string>::iterator it = optionMultipleStrings.begin(); it != optionMultipleStrings.end(); ++it) {
			std::cout << (*it) << std::endl;
		}
		std::cout << std::endl;
	}
	
	return 0;
}