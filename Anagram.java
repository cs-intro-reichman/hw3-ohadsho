/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
	    System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldmeort")); // true
		
		// Tests the preProcess function.
		System.out.println(preProcess("Hello World!"));
		
		
		 //Tests the randomAnagram function.
		//System.out.println("silent and " + randomAnagram("123456") + " are anagrams.");
		
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		
	 

	//String str = "hello" ;
//	String strTemp = str;
	//str = strTemp.substring(0,1) + strTemp.substring(1 +1, strTemp.length());
//	System.out.println(str);
} 

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
        str1 = preProcess(str1);
		str1= str1.replaceAll("\\s", "");
        str2 = preProcess(str2);
		str2= str2.replaceAll("\\s", "");
		String strTemp ="";


		if(str1.length() != str2.length())
		return false;

		for(int i=0 ; i< str1.length() ; i++){
			for(int j=0 ; j< str2.length() ; j++){
			if(str1.charAt(i) == str2.charAt(j) ){

		    strTemp = str2;
			str2 = strTemp.substring(0,j) + strTemp.substring(j +1, strTemp.length());
			break;
				}
		}
	}

	    if(str2.equals(""))
		return true;

		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String strTemp =str;

		for(int i=0 ; i< str.length() ; i++){
			if(str.charAt(i)!='a' && str.charAt(i)!='c' &&str.charAt(i)!='v' && str.charAt(i)!='b'&& str.charAt(i)!='s'  &&str.charAt(i)!='d' &&str.charAt(i)!='f'&&str.charAt(i)!='g'&& str.charAt(i)!='h' &&str.charAt(i)!='j'&& str.charAt(i)!='k' &&str.charAt(i)!='l'&&str.charAt(i)!='q' &&str.charAt(i)!='w' &&str.charAt(i)!='e' &&str.charAt(i)!='r' &&str.charAt(i)!='t' &&str.charAt(i)!='y' &&str.charAt(i)!='u' &&str.charAt(i)!='i' &&str.charAt(i)!='o' &&str.charAt(i)!='p' && str.charAt(i)!='n' && str.charAt(i)!='m'&& str.charAt(i)!='i'&& str.charAt(i)!='z'&& str.charAt(i)!='x' && str.charAt(i)!=' '){
				strTemp = str;
				str = strTemp.substring(0,i) + strTemp.substring(i +1, strTemp.length());
				i = i-1;
			}
		}
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String randomStr ="";
		int length = str.length();
		int random= 0;
		String strTemp ="";

		if(str.length() ==0)
		return "";

		for(int i=0 ; i<length ; i++){
			random =(int) (Math.random() * (str.length()));

			if(str != ""){
			strTemp = str;
			randomStr = randomStr + str.charAt(random);
			str = strTemp.substring(0,random) + strTemp.substring(random +1, strTemp.length());
			}
		
		}
		return randomStr;
	}
}
