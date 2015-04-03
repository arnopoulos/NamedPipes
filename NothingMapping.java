public class NothingMapping implements Mapping<String> {
	public String apply(String str) {
		return str;
	}
}


// import java.util.HashMap;
// import java.io.BufferedReader;
// import java.io.FileReader;

// public class NothingMapping implements Mapping<String> {
// 	public String apply(String str) {
// 		System.out.println(NothingMapping.englishToSpanish().get(str.toLowerCase()));
// 		return NothingMapping.englishToSpanish().get(str.toLowerCase());
// 	}

// 	private static HashMap<String,String> englishToSpanishMap = null;

// 	private static synchronized HashMap<String,String> englishToSpanish() {
		
// 		if (NothingMapping.englishToSpanishMap == null) {
// 			NothingMapping.englishToSpanishMap = new HashMap<String,String>();
// 			try {
// 				BufferedReader reader = new BufferedReader(new FileReader("EnglishToSpanish.trans"));
// 				String line = reader.readLine();
// 				while (line != null) {

// 					String[] wordMapping = line.split(":");
// 					NothingMapping.englishToSpanishMap.put(wordMapping[0].toLowerCase(),wordMapping[1].toLowerCase());

// 					line = reader.readLine();
// 				}
// 			} catch (Exception e) {
// 				System.out.println("Cannot create dictionary.");
// 			}
			

// 		}
// 		return NothingMapping.englishToSpanishMap;
// 	}

// 	public NothingMapping() {
// 		super();
// 		System.out.println("this should be called");
// 	}
// }