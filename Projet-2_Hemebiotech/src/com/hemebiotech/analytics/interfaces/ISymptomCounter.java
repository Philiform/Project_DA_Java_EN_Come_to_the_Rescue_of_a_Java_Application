package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.SortedMap;

/**
 * Tout de qu'il faut pour lire un ensemble de données à partir d'une liste
 * Il est important de renvoyer un dictionnaire trié qui contient des clés uniques
 * 
 */
public interface ISymptomCounter {
	/**
	 * 
	 * S'il n'y a pas de données alors renvoyer un dictionnaire vide
	 * 
	 * @param symptomsList une liste de tous les symptômes obtenus
	 * à partir d'une source de données, les doublons sont possibles/probables
	 * 
	 * @return SortedMap un dictionnaire trié avec les symptômes en clé et
	 * le nombre de symptômes en valeur  
	 */
	SortedMap<String, Integer> countSymptoms(List<String> symptomsList);
}
