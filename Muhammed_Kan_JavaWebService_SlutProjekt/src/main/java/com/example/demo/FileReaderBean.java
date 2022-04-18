package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class FileReaderBean {

	private ArrayList<CSVReadBean> rows = new ArrayList<CSVReadBean>();
	public void readFile(String fileName) throws FileNotFoundException, IOException {
		var csvFile = new ClassPathResource(fileName);
		
		try (BufferedReader br = new BufferedReader(new FileReader (csvFile.getFile()))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				System.out.println(values[0] + " " + values[1] + " " + values[2] + " " + values[3] + " " + values[4] + " " + values[5] + " " + values[6] + " " + values[7]);
				addRow(new CSVReadBean(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addRow(CSVReadBean row) {
		rows.add(row);
	}

	public String ObjectJson(CSVReadBean rowReader) {
		return 
		"{"+ 
				"\"OrderDate\": \"" + rowReader.getOrderDate() + "\"" +
				"," +
				"\"Region\": \"" + rowReader.getRegion() + "\"" +
				"," +
				"\"Rep1\": \"" + rowReader.getRep1() + "\"" +
				"," +
				"\"Rep2\": \"" + rowReader.getRep2() + "\"" +
				"," +
				"\"Item\": \"" + rowReader.getItem() + "\"" +
				"," +
				"\"Units\": \"" + rowReader.getUnits() + "\"" +
				"," +
				"\"UnitCost\": \"" + rowReader.getUnitCost() + "\"" +
				"," +
				"\"Total\": \"" + rowReader.getTotal() + "\""+
		"}";
				
	}
	
	public String JasonObject(ArrayList<CSVReadBean> rows) {
		String result = "";
		for(var item: rows) {
			result += ObjectJson(item) + ",";
		}
		
		if (result.length() > 8) {
			result = result.substring(0, result.length() - 1);			
		}
		
		result = "{ \"Order\": [" + result + "]}";
		System.out.println(result);
		return result;
	}
	
	public String ShowJson() {
		return JasonObject(rows);
	}
	
}