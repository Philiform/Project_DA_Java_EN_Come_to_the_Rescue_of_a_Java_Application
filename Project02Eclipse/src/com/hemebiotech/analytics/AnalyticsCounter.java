package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static ISymptomReader symptomsReader;
	
	private static List<String> symptomsList = new ArrayList<>();
	private static SortedMap<String, Integer> symptomsSortedCounter = new TreeMap<>();
	
	public static void main(String args[]) {
		readSymptoms("symptoms.txt");

		symptomsSortedCounter = countSymptoms(symptomsList);
		
		System.out.println("CLASS: AnalyticsCounter -> FONCTION: Main");
		for(Map.Entry<String, Integer> element : symptomsSortedCounter.entrySet()) {
			System.out.println("\t\t" + element.getValue() + " " + element.getKey());			}
		System.out.println("\n");

		writeSymptoms("results.out", symptomsSortedCounter);
	}
	
	public static void readSymptoms(String filepath) {
		symptomsReader = new ReadSymptomDataFromFile(filepath);
		symptomsList = symptomsReader.GetSymptoms();
	}
	
	public static SortedMap<String, Integer> countSymptoms(List<String> symptomsList) {
		SortedMap<String, Integer> symptomsSortedCounter = new TreeMap<>();

		if(!symptomsList.isEmpty()) {
			for(int i = 0; i < symptomsList.size(); i++) {
				symptomsSortedCounter.putIfAbsent(symptomsList.get(i), 0);
				symptomsSortedCounter.put(symptomsList.get(i), symptomsSortedCounter.get(symptomsList.get(i)) + 1);
			}
		}
		return symptomsSortedCounter;
	}
	
	public static void writeSymptoms(String filepath, SortedMap<String, Integer> symptomsSortedCounter) {
		if (!filepath.isEmpty() && !symptomsSortedCounter.isEmpty()) {
			try {
		        BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));

				for(Map.Entry<String, Integer> element : symptomsSortedCounter.entrySet()) {
					writer.write(element.getKey() + "=" + element.getValue().toString() + "\n");
					System.out.println("\t" + element.getValue() + " " + element.getKey());
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
