package com.hemebiotech.analytics.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

import com.hemebiotech.analytics.interfaces.ISymptomWriter;

/**
 * Implémentation de l'interface avec l'ajout d'une méthode pour choisir
 * le fichier dans lequel on écrira les données
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
	private String filepath;

	/**
	 * 
	 * @param filepath le nom d'un fichier avec ou non le chemin,
	 * on écrira dans ce fichier la liste des symptômes avec leur nombre,
	 * un symptôme par ligne
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	
	public WriteSymptomDataToFile() {
	}
	
	@Override
	public void setSymptoms(SortedMap<String, Integer> symptomsSortedCounter) {
		if (!filepath.isEmpty() && !symptomsSortedCounter.isEmpty()) {
			try (BufferedWriter writer = new BufferedWriter (new FileWriter(filepath))) {
				for(Map.Entry<String, Integer> element : symptomsSortedCounter.entrySet()) {
					writer.write(element.getKey() + "=" + element.getValue().toString() + "\n");
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param filepath le nom d'un fichier avec ou non le chemin,
	 * on écrira dans ce fichier la liste des symptômes avec leur nombre,
	 * un symptôme par ligne
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}
