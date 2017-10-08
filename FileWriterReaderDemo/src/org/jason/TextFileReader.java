package org.jason;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

	private static final String FILE_NAME = System.getProperty("user.dir") + "\\Files\\TextFile.txt";
	
	public static void main(String[] args) {
		
		Double totalTime = 0.0;
		int counter = 0;
		
		for (int i = 0; i < 100; ++i) {
			totalTime += getFileReadingTime();
			counter++;
		}
		
		Double avgFileReadingTime = totalTime / counter;		
		System.out.println("Average File Reading Time: " + avgFileReadingTime);
	
	}

	private static Double getFileReadingTime() {
		
		Double startTime = Double.valueOf(System.currentTimeMillis());
		readTextFile();		
		Double endTime = Double.valueOf(System.currentTimeMillis());
		
		Double timeElapse = (endTime - startTime) / 1000;
		System.out.println(startTime + "\n" + endTime + "\n" + timeElapse);
		
		return timeElapse;
	}

	private static void readTextFile() {
		
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(new File(FILE_NAME));
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
