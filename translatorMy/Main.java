package translatorMy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("Hello", "Привiт");
		dictionary.put("what", "як");
		dictionary.put("is", "");
		dictionary.put("your", "твоэ");
		dictionary.put("name", "им'я");
		dictionary.put("day", "день");
		dictionary.put("a", "");
		dictionary.put("i", "менi");
		dictionary.put("day", "день");
		dictionary.put("car", "авто");
		dictionary.put("flower", "квiтка");
		dictionary.put("Like", "подобаэться");

		// String string = "Hello what is your name I like your car";
		Dictionary dict1 = new Dictionary(dictionary);

		TranslatorMy trs1 = new TranslatorMy(dictionary);
		File file = new File("C:\\Users\\new\\eclipse-workspace\\TranslatorMy\\src\\translatorMy\\EnglishIn1.txt");
		File file2 = new File("C:\\Users\\new\\eclipse-workspace\\TranslatorMy\\src\\translatorMy\\EnglishIn2.txt");
		File file3 = new File("C:\\Users\\new\\eclipse-workspace\\TranslatorMy\\src\\translatorMy\\UkrainianOut.txt");
		File file4 = new File("C:\\Users\\new\\eclipse-workspace\\TranslatorMy\\src\\translatorMy\\map.txt");

		Map<String, String> dictionary1 = dict1.getDictionaryFromFile(file4);

		trs1.translateTo(trs1.getStringFromFile(file), dictionary);
		// System.out.println(trs1.translatedString(trs1.getStringFromFile(file),
		// dictionary));
		trs1.saveIntoFile(file3, file);
		trs1.addWordsInDictionary();
		// or we could use Dictionary to add words manually or automatically
		dict1.addWordsInDictionaryManually();

		dict1.addWordsAutomatically(dictionary1);

		String s = "This cat is black";

		trs1.translateTo(s, dict1);

		File file8 = new File("C:\\Users\\new\\eclipse-workspace\\TranslatorMy\\src\\translatorMy\\out8.txt");
		String string2 = trs1.getStringFromFile(file2);

		trs1.translateTo(string2, dictionary);

		trs1.saveIntoFile(file8, file2);

	}

}
