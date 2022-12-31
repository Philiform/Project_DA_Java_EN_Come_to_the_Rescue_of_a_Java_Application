package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.SortedMap;

public interface ISymptomCounter {
	SortedMap<String, Integer> countSymptoms(List<String> symptomsList);
}
