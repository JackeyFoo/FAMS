package bll.controll;

import java.io.File;
import java.util.StringTokenizer;

public class StrToFile {
	private static File[] filesshow  = null;

	public static File[] filesAnalytical(String string, String divisionChar) {
     if(string != null){
		int i = 0;

		StringTokenizer tokenizer = new StringTokenizer(string, divisionChar);
		String[] str = new String[tokenizer.countTokens()];
		filesshow = new File[tokenizer.countTokens()];
		while (tokenizer.hasMoreTokens()) {
			str[i] = new String();
			str[i] = tokenizer.nextToken();
			filesshow[i] = new File(str[i]);
			i++;
		}
     }
		return filesshow;
     
	}

}
