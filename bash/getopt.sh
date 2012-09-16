#!/bin/bash

# Execute getopt
GetOptEscapeHelper=`getopt -o "hva:" -l "help,version,argument:" \
      -n "getopt.sh" -- "$@"`
      
eval set -- "$GetOptEscapeHelper"

function PrintHelp
{
	echo "Usage: getopt [OPTION]..."
	echo ""
	echo "	-h --help 		display this help and exit"
	echo "	-v --version 		output version information and exit"
	echo "	-a --argument 		output argument value"
	echo ""
	echo "Report getopt bugs to getopt@projects.mythli.net"
}

function PrintVersion
{
	echo "getopt version 42"
}

MODE_HELP=0
MODE_VERSION=1
MODE_ARGUMENT=2
Mode=MODE_HELP

while true;
do
	argName=$1
	argValue=$2
	
	case "$argName" in
		-h|--help)
			Mode=MODE_HELP
			shift
		;;
		-v|--version)
			Mode=MODE_VERSION
			shift
		;;
		-a|--argument)
			Mode=MODE_ARGUMENT
			Argument=$argValue
			shift 2
		;;
		--)
		shift
		break;;
	esac
done

case $Mode in
	MODE_HELP)
		PrintHelp
		exit 0
	;;
	MODE_VERSION)
		PrintVersion
		exit 0
	;;
	MODE_ARGUMENT)
		echo "The Argument: ~~ $Argument"
		exit 0
	;;
esac