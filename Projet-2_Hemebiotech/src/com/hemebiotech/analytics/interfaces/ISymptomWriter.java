package com.hemebiotech.analytics.interfaces;

import java.util.SortedMap;

/**
 * Tout ce qu'il faut pour écrire un ensemble de données concernant les symptômes
 * vers une source.
 * 
 */
public interface ISymptomWriter {
	/**
	 * 
	 * @param symptomsSortedCounter un dictionnaire trié avec les symptômes en clé
	 * et le nombre de symptômes en valeur
	 */
	void setSymptoms(SortedMap<String, Integer> symptomsSortedCounter);
}
