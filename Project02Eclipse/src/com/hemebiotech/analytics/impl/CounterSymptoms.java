package com.hemebiotech.analytics.impl;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.hemebiotech.analytics.interfaces.ISymptomCounter;

public class CounterSymptoms implements ISymptomCounter {
	
	@Override
	public SortedMap<String, Integer> countSymptoms(List<String> symptomsList) {
		SortedMap<String, Integer> symptomsSortedCounter = new TreeMap<>();

		if(!symptomsList.isEmpty()) {
			for(int i = 0; i < symptomsList.size(); i++) {
				symptomsSortedCounter.putIfAbsent(symptomsList.get(i), 0);
				symptomsSortedCounter.put(symptomsList.get(i), symptomsSortedCounter.get(symptomsList.get(i)) + 1);
			}

//			System.out.println("\tCLASS: AnalyticsCounter -> FONCTION: sortedMap");
//			for(Map.Entry<String, Integer> element : symptomsSortedCounter.entrySet()) {
//				System.out.println("\t\t" + element.getValue() + " " + element.getKey());			}
//			System.out.println("\n");
		}
		return symptomsSortedCounter;
	}

}
