package com.hemebiotech.analytics.impl;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.hemebiotech.analytics.interfaces.ISymptomCounter;

/**
 * Simple implémentation
 *
 */
public class CounterSymptoms implements ISymptomCounter {

	public CounterSymptoms() {
	}
	
	@Override
	public SortedMap<String, Integer> countSymptoms(List<String> symptomsList) {
		SortedMap<String, Integer> symptomsSortedCounter = new TreeMap<>();

		if(!symptomsList.isEmpty()) {
			for(int i = 0; i < symptomsList.size(); i++) {
				symptomsSortedCounter.putIfAbsent(symptomsList.get(i), 0);
				symptomsSortedCounter.put(symptomsList.get(i),
						symptomsSortedCounter.get(symptomsList.get(i)) + 1);
			}
		}
		return symptomsSortedCounter;
	}

}
