package translatorMy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	private Map<String, String> dictionary;

	public Dictionary(Map<String, String> map) {
		super();
		this.dictionary = map;
	}

	public Dictionary() {
		super();
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> map) {
		this.dictionary = map;
	}

	public void addWordsInDictionaryManually() {

		Map<String, String> mp = this.getDictionary();
		Scanner sc = new Scanner(System.in);
		for (;;) {

			System.out.println("Enter word ");
			String str1 = sc.nextLine();
			System.out.println("Enter  translate of this word ");
			String str2 = sc.nextLine();
			mp.put(str1, str2);
			System.out.println("If you want to quit - enter '1'. If you want to proceed - proceed)");
			String temp = sc.nextLine();
			if (temp.equals("1")) {
				break;
			}
		}
		this.setDictionary(mp);
	}

	public void addWordsAutomatically(Map<String, String> map) {

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			dictionary.put(key, val);
		}

	}

	public Map<String, String> getDictionaryFromFile(File file) {
		File file1 = file;
		Map<String, String> map = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));

			for (;;) {
				try {
					String tmp = reader.readLine();

					if (tmp == null) {
						break;
					} else {
						String[] separated = tmp.split("=");
						map.put(separated[0], separated[1]);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("This file doesn't exist!");

		}

		return map;

	}

	public void saveDictionaryIntoFile(File file, Dictionary dict) {
		File file1 = file;
		String field = "";
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file1));
			for (Map.Entry<String, String> entry : dict.getDictionary().entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				field = key + "=" + val;

			}

			pw.println(field);
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
