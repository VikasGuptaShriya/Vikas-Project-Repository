package com.vikas.demo.FileUpdateProject;
import java.util.*;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileModificationProgram1 {
	
	static boolean modifyFile(String filePath) {
		File fileToBeModified = new File(filePath);

		File modifiedFile = new File("E:\\Vikas123\\Files\\OutputFiles\\UpdatedTextFile.txt");
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
			}

			String newContent = "";
			FileReader reader1 = new FileReader("E:\\Vikas123\\Files\\InputFiles\\replacement.property");
			Properties p = new Properties();
			p.load(reader1);
			newContent = oldContent.replaceAll("hand", p.getProperty("hand")).replaceAll("business",
					p.getProperty("business"));
			reader1.close();

			writer = new FileWriter(modifiedFile);
			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;

	}

	
	static boolean countWords(String filePath) throws FileNotFoundException {
		Map<String, Integer> words = new TreeMap<>();
		File fileToBeModified = new File(filePath);
		String word = "";
		BufferedReader reader1 = null;
		try {
			reader1 = new BufferedReader(new FileReader(fileToBeModified));

			String line = reader1.readLine();
			while (line != null) {
				word = word + line;
				line = reader1.readLine();
			}

			String result = word.replace(",", " ,").replace(";", " ;").replace(".", " .");

			String arr[] = result.split(" ");
			

			for (int i = 0; i < arr.length; i++) {

				if (words.containsKey(arr[i])) {
					words.put(arr[i], words.get(arr[i]) + 1);
				} else {
					words.put(arr[i], 1);
				}
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		Integer countHand = words.get("hand");

		Integer countBusiness = words.get("business");

		System.out.println("Hand is replaced " + countHand + " times");
		System.out.println("business is replaced " + countBusiness + " times");
		
		return true;

	}

	public static void main(String[] args) {

		modifyFile("E:\\Vikas123\\Files\\InputFiles\\textfile.txt");

		System.out.println("Replacement Result : ");

		try {
			countWords("E:\\Vikas123\\Files\\InputFiles\\textfile.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
