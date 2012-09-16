add_custom_target(js
	DEPENDS jsmin
	
	COMMAND touch /home/tobias/test.txt
)

add_custom_command(TARGET js
	PRE_BUILD
	
	COMMAND touch /home/tobias/test.txt
	COMMENT "aaa"
)