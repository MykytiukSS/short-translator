package translatorMy;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map<String, String>dictionary = new HashMap<>();
		dictionary.put("Hello", "������");
		dictionary.put("what", "���");
		dictionary.put("is", "");
		dictionary.put("your", "����");
		dictionary.put("name", "���");
		dictionary.put("day", "����");
		dictionary.put("a", "");
		dictionary.put("i", "���");
		dictionary.put("day", "����");
		dictionary.put("car", "������");
		dictionary.put("flower", "������");
		dictionary.put("Like", "��������");
		
		String string = "Hello what is your name I like your car";
		
		TranslatorMy trs1= new TranslatorMy(dictionary);
		trs1.translateTo(string, dictionary);
		
		trs1.addWordsInDictionary();
	    String string2= "It is very beautiful and big";
	    trs1.translateTo(string2, dictionary);
	    
		
		
		
		
		
		
		

	}

}
