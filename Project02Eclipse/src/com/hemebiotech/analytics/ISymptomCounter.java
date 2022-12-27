package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;

public interface ISymptomCounter {
	SortedMap<String, Integer> countSymptoms(List<String> symptomsList);
}
