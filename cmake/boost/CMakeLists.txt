project(boost)

set(Boost_USE_STATIC_LIBS   ON)
find_package(Boost REQUIRED)

add_executable(boost main.cpp)

target_link_libraries(boost ${Boost_LIBRARIES})

install(TARGETS boost RUNTIME DESTINATION bin)