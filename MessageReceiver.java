import java.io.*;

public class MessageReceiver extends Thread implements MessageSender<String> {

	private String outputPipeName;
	private String id;
	private String message;

	public MessageReceiver(String line) {
		String[] components = line.split(":",2);
		setup(components[0],components[1]);
	}

	public MessageReceiver(String id, String message) {
		setup(id,message);
	}

	private void setup(String id, String message) {
		this.id = id;
		this.message = message;
		this.outputPipeName = "/tmp/output";
		this.start();
	}

	public void run() {
		MessageQueue.queue.add(new MessageContainer<String>(this,message));
	}

	public void sendMessage(String str) {
		try {
			PrintWriter printWriter=new PrintWriter(new BufferedOutputStream(new FileOutputStream(outputPipeName)));
			// System.out.println(id+":"+str);
			printWriter.println(id+":"+str);
			// printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Cannot write to " + outputPipeName +".");
		}
	}

}