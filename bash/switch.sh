function switchFoo {
	case $1 in
		1)
			echo "This is a good number!" 
		;;
		"foo")
			echo "Fooooooo!!!" 
		;;
		*)
			echo "The universe is endless..."
		;;
	esac
}

switchFoo 1
switchFoo 42
switchFoo "foo"
switchFoo "fooyou"