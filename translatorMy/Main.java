package translatorMy;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map<String, String>dictionary = new HashMap<>();
		dictionary.put("Hello", "Привет");
		dictionary.put("what", "Как");
		dictionary.put("is", "");
		dictionary.put("your", "твое");
		dictionary.put("name", "имя");
		dictionary.put("day", "день");
		dictionary.put("a", "");
		dictionary.put("i", "мне");
		dictionary.put("day", "день");
		dictionary.put("car", "машина");
		dictionary.put("flower", "цветок");
		dictionary.put("Like", "нравится");
		
		String string = "Hello what is your name I like your car";
		
		TranslatorMy trs1= new TranslatorMy(dictionary);
		trs1.translateTo(string, dictionary);
		
		trs1.addWordsInDictionary();
	    String string2= "It is very beautiful and big";
	    trs1.translateTo(string2, dictionary);
	    
		
		
		
		
		
		
		

	}

}
