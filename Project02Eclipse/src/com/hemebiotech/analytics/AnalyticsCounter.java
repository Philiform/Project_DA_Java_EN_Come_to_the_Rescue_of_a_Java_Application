package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.hemebiotech.analytics.impl.CounterSymptoms;
import com.hemebiotech.analytics.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.impl.WriteSymptomDataToFile;
import com.hemebiotech.analytics.interfaces.ISymptomCounter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

public class AnalyticsCounter {
	private ISymptomReader symptomsReader;
	private ISymptomCounter symptomsCounter;
	private ISymptomWriter symptomsWriter;
	
	private List<String> symptomsList = new ArrayList<>();
	private SortedMap<String, Integer> symptomsSortedCounter = new TreeMap<>();

	AnalyticsCounter() {
		symptomsReader = new ReadSymptomDataFromFile();
		symptomsCounter = new CounterSymptoms();
		symptomsWriter = new WriteSymptomDataToFile();
	}
	
	public void run() {
		symptomsList = symptomsReader.getSymptoms();
		symptomsSortedCounter = symptomsCounter.countSymptoms(symptomsList);
		symptomsWriter.setSymptoms(symptomsSortedCounter);
	}

	public void setSymptomsReader(ISymptomReader symptomsReader) {
		this.symptomsReader = symptomsReader;
	}

	public void setSymptomsCounter(ISymptomCounter symptomsCounter) {
		this.symptomsCounter = symptomsCounter;
	}

	public void setSymptomsWriter(ISymptomWriter symptomsWriter) {
		this.symptomsWriter = symptomsWriter;
	}
}
