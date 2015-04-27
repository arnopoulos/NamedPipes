import java.io.*;
import java.util.UUID;

public class PipeClient {

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Usage: PipeClient <numberOfMessages>");
			return;
		}
		double numberOfMessages = Double.parseDouble(args[0]);

		double sumTime = 0;

		for (int i = 0; i < numberOfMessages; i++) {
			UUID id = UUID.randomUUID();
			String returnFilePath = "/tmp/output";
			if (!new File(returnFilePath).exists()) {
				PrintWriter writer = new PrintWriter(returnFilePath, "UTF-8");
				writer.close();
			}

			BufferedReader reader = new BufferedReader(new FileReader(returnFilePath));
			reader.skip(Long.MAX_VALUE);

			double startTime = (double)System.currentTimeMillis();
			PrintWriter serverWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream("/tmp/input",true)));
			serverWriter.println(id+":Hello Andrew");
			serverWriter.flush();
			serverWriter.close();
			double endTime = (double)System.currentTimeMillis();

			sumTime += endTime - startTime;
			
			
			while (true) {

				String line = reader.readLine();
				if (line != null && line.contains(id.toString())) {
					break;
				}

			}
			reader.close();
		}
		double averageTime = sumTime / numberOfMessages;
		System.out.println(averageTime / 1000.0);
		
	}

}