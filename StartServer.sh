if [ $# -ne 1 ];
	then echo "Usage: $0 <numberThreads>"
	exit
fi
rm "/tmp/input"
javac PipeServer.java
java PipeServer $1