package translatorMy;

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

	public void translateTo(String string, Map<String, String> dictionary) {

		String[] words = string.split(" ");
		System.out.println(Arrays.toString(words));
		List<String> translatedList = new ArrayList<>();
		String translated = "";

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

}
