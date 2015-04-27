if [ $# -ne 1 ];
	then echo "Usage: $0 <numberThreads>"
	exit
fi

for messages in 8 64 128;
do
	echo "Testing with $messages messages"
	./ClientBomb.sh $1 $messages | awk 'BEGIN {count=0} {count=count+1;s+=$1} END {print s "ms"}'
done