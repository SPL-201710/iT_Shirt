package co.com.itshirt.processor.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadFile {
	
	private static final String FILENAME = "C:/Users/jpicon/Downloads/annotations-exploration-master (1)/annotations-exploration-master/processors/src/main/java/com/olivierlafleur/guicetest/PatateProcessor.java";

	public ReadFile() {
		// TODO Auto-generated constructor stub
	}
	
	public void readFile() {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			String sCurrentLine;

			URL url = this.getClass().getResource("prueba.txt");
			System.err.println(url);
//			br = new BufferedReader(new FileReader(FILENAME));
//			InputStreamReader reader =  new InputStreamReader(this.getClass().getResourceAsStream("/PatateProcessor.java"));
			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
	public static void main(String[] args) {
		ReadFile readFile = new ReadFile();
		readFile.readFile();
	}
	
}
