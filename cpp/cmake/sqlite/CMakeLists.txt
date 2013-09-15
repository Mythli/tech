project(sqlite)

find_path(SQLITE3_INCLUDE_DIR sqlite3.h)
find_library(SQLITE3_LIBRARY sqlite3)
if(NOT SQLITE3_INCLUDE_DIR)
  message(SEND_ERROR "Failed to find sqlite3.h")
endif()
if(NOT SQLITE3_LIBRARY)
  message(SEND_ERROR "Failed to find the sqlite3 library")
endif()

add_executable(sqlite main.cpp)

target_link_libraries(sqlite
	${SQLITE3_LIBRARY}
)

install(TARGETS sqlite RUNTIME DESTINATION bin)
