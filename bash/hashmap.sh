function foo {
	eval "declare -A fooHash="${1#*=}
	
	for key in "${!fooHash[@]}"; do
		echo "$key - ${fooHash["$key"]}"
	done
}

declare -A fooHash=( 
	["moo"]="cow"
	["aa"]="test"
)

foo "$(declare -p fooHash)"