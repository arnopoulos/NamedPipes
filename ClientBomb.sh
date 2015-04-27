if [ $# -ne 2 ];
	then echo "Usage: $0 <numberOfClients> <numberOfMessages>"
	exit
fi

javac PipeClient.java

for i in $(seq 1 $1)
do 
	java PipeClient $2 &
done
wait