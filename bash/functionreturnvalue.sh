function fooExitCode {
	return 42
}

function fooReturnValue {
	echo "NOOB"
}

fooExitCode
echo "Function exit code was $?"
echo "Function return value was $(fooReturnValue)"