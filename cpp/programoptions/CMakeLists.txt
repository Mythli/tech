project(programoptions)

find_package(Boost COMPONENTS program_options REQUIRED)
include_directories(${Boost_INCLUDE_DIR})

add_executable(programoptions main.cpp)

target_link_libraries(programoptions
	${Boost_LIBRARIES}
)

install(TARGETS programoptions RUNTIME DESTINATION bin)