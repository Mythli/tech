if [ $1 ]; then
	echo '$1 is defined';
else
	echo '$1 is not defined';
fi

if [ -z "$1" ]; then
	echo '$1 has zero length';
else
	echo '$1 has not zero length';
fi

if [ -n "$1" ]; then
	echo '$1 has a length greater than zero';
else
	echo '$1 has not a length greater than zero';
fi