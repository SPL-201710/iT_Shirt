package co.com.itshirt.processor.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.com.itshirt.processor.enums.OptionalFeatures;

public class FeatureList {
	
	private static final String FILENAME = "C:/Users/ja.picon/Documents/iT_Shirt-FINAL/iT_Shirt/iT_Shirt-processor/configs/default.config";

	private static FeatureList instance = null;

	private FeatureList() {
		super();
	}

	public static FeatureList getInstance() {
		if (instance == null) {
			instance = new FeatureList();
		}
		return instance;
	}
	   
	public List<String> optionalFeatures() {
		List<String> features = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				if (OptionalFeatures.contains(sCurrentLine)) {
					features.add(sCurrentLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return features;
	}
	
	public static void main(String[] args) {
		System.out.println("# Features: " +FeatureList.getInstance().optionalFeatures().size());
	}
	
}
