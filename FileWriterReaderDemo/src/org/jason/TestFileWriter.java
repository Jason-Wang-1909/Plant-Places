package org.jason;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestFileWriter {

	private static final String FILE_NAME = System.getProperty("user.dir") + "\\Files\\TextFile.txt";
	
	public static void main(String[] args) {
		
		Double totalTime = 0.0;
		int counter = 0;
		
		for (int i = 0; i < 100; ++i) {
			totalTime += getFileWritingTime();
			counter++;
		}
		
		Double avgFileReadingTime = totalTime / counter;		
		System.out.println("Average File Writing Time: " + avgFileReadingTime);
	
	}

	private static Double getFileWritingTime() {
		
		Double startTime = Double.valueOf(System.currentTimeMillis());
		writeTextFile();		
		Double endTime = Double.valueOf(System.currentTimeMillis());

		Double timeElapse = (endTime - startTime) / 1000;
		System.out.println(startTime + "\n" + endTime + "\n" + timeElapse);
		
		return timeElapse;
	}

	private static void writeTextFile() {
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(FILE_NAME);
			
			for (int i = 0; i < 100_000; ++i) {
				pw.println((i + 1) + " this is a test file for writing into a file");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
		
	}

}
