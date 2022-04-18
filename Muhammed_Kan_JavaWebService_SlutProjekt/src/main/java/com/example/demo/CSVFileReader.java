package com.example.demo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

public class CSVFileReader {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String root() {
		return "Welcome to my web service!";
	}

	@RequestMapping(value = "/showCsvFile", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public void showCsvFile(HttpServletResponse response) throws IOException {
		var csvFile = new ClassPathResource("sample.csv");
		
		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
	}
	
	@RequestMapping(value = "/showCsvFileScanner", method = RequestMethod.GET)
	public String showCsvFileScanner() throws IOException {
		CSVFileReader myReader = new CSVFileReader();
		
		String text = myReader.readFile("sample.csv");
		return text;
	}

	public String readFile(String fileName ) throws FileNotFoundException, IOException 
	{
		var csvFile = new ClassPathResource(fileName);
		String result = "";	
		
		try (Scanner myScanner = new Scanner(csvFile.getFile())) {
			while(myScanner.hasNextLine())
			{
				result += processLine(myScanner.nextLine()) + "\r\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public String processLine(String textLine) {
		String result = "";
		
		Scanner rowScanner = new Scanner(textLine);
		rowScanner.useDelimiter(",");

		while(rowScanner.hasNext())
		{
			result += rowScanner.next() + " :: ";
		}

		return result;
	}
	
}