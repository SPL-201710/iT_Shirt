package co.com.itshirt.processor.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadFile {
	
//	private static final String FILENAME = "C:/Users/ja.picon/Documents/iT_Shirt-22/iT_Shirt/iT_Shirt-processor/configs/default.config";

	public ReadFile() throws IOException {
//		final URL r = getClass().getResource("/configs/default.config");
//		System.err.println(r);
//		String filePath = new File("").getAbsolutePath();
//		System.out.println (filePath);
//
//		//http://stackoverflow.com/questions/2788080/reading-a-text-file-in-java    
//		//http://stackoverflow.com/questions/19874066/how-to-read-text-file-relative-path
//		BufferedReader reader = new BufferedReader(new FileReader(filePath + "/configs/default.config"));
//		System.err.println(reader.readLine());
	}
	
	public void readFile() {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			String sCurrentLine;
			URL url = this.getClass().getResource("prueba.txt");
			String filePath = new File("").getAbsolutePath();
//			br = new BufferedReader(new FileReader(FILENAME))
			br = new BufferedReader(new FileReader(filePath + "/configs/default.config"));
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
	
	public static void main(String[] args) throws IOException {
		File file = new File("/configs/default.config");  
		System.err.println(file.getAbsolutePath());
		ReadFile readFile = new ReadFile();
//		readFile.readFile();
	}
	
}
