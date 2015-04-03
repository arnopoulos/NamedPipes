public class MessageFetcher extends Thread {

	public MessageFetcher() {
		this.start();
	}
	
	public void run() {
		while (true) {
			MessageContainer<String> container = MessageQueue.queue.poll();
			if (container != null) {
				MessageProcessor<String> mp = new MessageProcessor<String>(new Mapper<String>(new SpanishTranslationMapping()),container);
				mp.process();
			} else {
				try {
					Thread.sleep((long)(Math.random() % 1000));
				} catch (Exception e) {
					System.out.println("Thread cannot go to sleep. Can you read it a bed time story?");
				}
				
			}
		}
	}
}