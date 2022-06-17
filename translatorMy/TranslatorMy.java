package translatorMy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TranslatorMy {
	private Map<String, String> dictionary = new HashMap<>();

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	public TranslatorMy(Map<String, String> dictionary) {
		super();
		this.dictionary = dictionary;
	}

	public TranslatorMy() {
		super();
	}

	public void translateTo(String string, Map<String, String> dictionary) {

		String[] words = string.split(" ");
		// System.out.println(Arrays.toString(words));
		List<String> translatedList = new ArrayList<>();
		String translated = "";
		System.out.println(string);

		for (String str : words) {
			for (Map.Entry<String, String> entry : dictionary.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				if (str.equalsIgnoreCase(key)) {
					translatedList.add(val);
				}

			}

		}
		for (String str : translatedList) {
			translated = translated + " " + str;
		}
		System.out.println(translated);

	}

	public void translateTo(String string, Dictionary dictionary) {

		String[] words = string.split(" ");
		// System.out.println(Arrays.toString(words));
		List<String> translatedList = new ArrayList<>();
		String translated = "";

		System.out.println(string);

		Dictionary dict = dictionary;

		for (String str : words) {
			for (Map.Entry<String, String> entry : dict.getDictionary().entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				if (str.equalsIgnoreCase(key)) {
					translatedList.add(val);
				}

			}

		}
		for (String str : translatedList) {
			translated = translated + " " + str;
		}
		System.out.println(translated);

	}

	public String translatedString(String string, Map<String, String> str) {
		String[] words = string.split(" ");
		// System.out.println(Arrays.toString(words));
		List<String> translatedList = new ArrayList<>();
		String translated = "";

		for (String str1 : words) {
			for (Map.Entry<String, String> entry : str.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				if (str1.equalsIgnoreCase(key)) {
					translatedList.add(val);
				}

			}

		}

		for (String str1 : translatedList) {
			translated = translated + " " + str1;
		}
		return translated;

	}

	public void addWordsInDictionary() {
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

	public String getStringFromFile(File file) {
		File file1 = file;
		String str = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));

			for (;;) {
				try {
					String tmp = reader.readLine();
					if (tmp == null) {
						break;
					} else {
						str = str + tmp;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("This file doesn't exist!");

		}

		return str;

	}

	public void saveIntoFile(File file, File file2) throws IOException {
		String temp1 = this.getStringFromFile(file2);
		// System.out.println(temp1);

		try {
			PrintWriter pw = new PrintWriter(file);
			String temp = this.translatedString(temp1, dictionary);
			pw.println(temp);
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
