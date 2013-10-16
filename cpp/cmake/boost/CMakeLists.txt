project(boost)

find_package(Boost REQUIRED)
include_directories(${Boost_INCLUDE_DIR})

add_executable(boost main.cpp)

target_link_libraries(boost
	${Boost_LIBRARIES}
)

install(TARGETS boost RUNTIME DESTINATION bin)