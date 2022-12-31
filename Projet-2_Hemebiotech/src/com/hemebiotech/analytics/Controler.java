package com.hemebiotech.analytics;

import com.hemebiotech.analytics.impl.CounterSymptoms;
import com.hemebiotech.analytics.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.impl.WriteSymptomDataToFile;
import com.hemebiotech.analytics.interfaces.ISymptomCounter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

/**
 * Point d'entrée du programme.
 * 
 */
public class Controler {

	public static void main(String[] args) {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		
		ISymptomReader symptomsReader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomCounter symptomsCounter = new CounterSymptoms();
		ISymptomWriter symptomsWriter = new WriteSymptomDataToFile("results.out");

		analyticsCounter.setSymptomsReader(symptomsReader);
		analyticsCounter.setSymptomsCounter(symptomsCounter);
		analyticsCounter.setSymptomsWriter(symptomsWriter);
		
		analyticsCounter.run();
	}

}
