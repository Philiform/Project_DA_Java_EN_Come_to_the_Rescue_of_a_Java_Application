package com.hemebiotech.analytics.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.interfaces.ISymptomReader;

/**
 * Implémentation de l'interface avec l'ajout d'une méthode pour choisir
 * le fichier source à lire
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 * one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	public ReadSymptomDataFromFile () {
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: file '" + this.filepath + "' not find");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 * one per line
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}