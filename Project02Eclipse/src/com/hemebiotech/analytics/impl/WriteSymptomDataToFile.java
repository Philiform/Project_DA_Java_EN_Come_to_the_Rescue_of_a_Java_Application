package com.hemebiotech.analytics.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

import com.hemebiotech.analytics.interfaces.ISymptomWriter;

public class WriteSymptomDataToFile implements ISymptomWriter{
	private String filepath;

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public void setSymptoms(SortedMap<String, Integer> symptomsSortedCounter) {
		if (!filepath.isEmpty() && !symptomsSortedCounter.isEmpty()) {
			BufferedWriter writer = null;
			try {
		        writer = new BufferedWriter (new FileWriter(filepath));

				for(Map.Entry<String, Integer> element : symptomsSortedCounter.entrySet()) {
					writer.write(element.getKey() + "=" + element.getValue().toString() + "\n");
					System.out.println("\t" + element.getValue() + " " + element.getKey());
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}

}
