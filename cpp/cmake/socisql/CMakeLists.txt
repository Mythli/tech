project(socisql)

set(Boost_USE_STATIC_LIBS   ON)
find_package(Boost REQUIRED)

find_path(SQLITE3_INCLUDE_DIR sqlite3.h)
find_library(SQLITE3_LIBRARY sqlite3)
if(NOT SQLITE3_INCLUDE_DIR)
  message(SEND_ERROR "Failed to find sqlite3.h")
endif()
if(NOT SQLITE3_LIBRARY)
  message(SEND_ERROR "Failed to find the sqlite3 library")
endif()

set(SOCI_STATIC 1)
set(SOCI_TESTS 0) 
set(WITH_BOOST 1)
set(WITH_SQLITE3 1)

add_subdirectory(lib/soci/src)	
include_directories(
	"lib/soci/src/core"
	"lib/soci/src/backends/sqlite3"
)
add_executable(socisql main.cpp)

target_link_libraries(socisql
	${CMAKE_DL_LIBS}
	${Boost_LIBRARIES}
	${SQLITE3_LIBRARY}
	soci_core_static
	soci_sqlite3_static
)

install(TARGETS socisql RUNTIME DESTINATION bin)
