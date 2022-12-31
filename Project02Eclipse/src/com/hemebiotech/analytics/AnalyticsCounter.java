package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.hemebiotech.analytics.impl.CounterSymptoms;
import com.hemebiotech.analytics.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.impl.WriteSymptomDataToFile;
import com.hemebiotech.analytics.interfaces.ISymptomCounter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

public class AnalyticsCounter {
	private static ISymptomReader symptomsReader;
	private static ISymptomCounter symptomsCounter;
	private static ISymptomWriter symptomsWriter;
	
	private static List<String> symptomsList = new ArrayList<>();
	private static SortedMap<String, Integer> symptomsSortedCounter = new TreeMap<>();
	
	public static void main(String args[]) {
		symptomsReader = new ReadSymptomDataFromFile("symptoms.txt");
		symptomsCounter = new CounterSymptoms();
		symptomsWriter = new WriteSymptomDataToFile("results.out");
		
		symptomsList = symptomsReader.GetSymptoms();
		symptomsSortedCounter = symptomsCounter.countSymptoms(symptomsList);
		
		System.out.println("CLASS: AnalyticsCounter -> FONCTION: Main");
		for(Map.Entry<String, Integer> element : symptomsSortedCounter.entrySet()) {
			System.out.println("\t\t" + element.getValue() + " " + element.getKey());
			}
		System.out.println("\n");

		symptomsWriter.setSymptoms(symptomsSortedCounter);
	}
}
