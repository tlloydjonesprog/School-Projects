import java.util.*;

/**
 *
 * @author Tom L-j
 *
 */
public class UGBOA {
	public static int countnum = 0;
	public static String str = "";
	public static Scanner sc = new Scanner(System.in);
	public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static ArrayList<String> outputArray = new ArrayList<String>();

	public static void main(String[] args) {
		//  Get the input
		System.out.println("Input:");
		str = sc.next();
		//Pass each Char through a array of char with alphabet
		System.out.println("The text contains: " + str);
		
		for(int i = 0; i <26; i++) {	
			int check = countNumChar(str, alphabet[i]);		
			if (check >0)
				// Call method with original word and new letter and add to arrayList
				outputArray.add(check  +"" + alphabet[i]);
		}
		// Sort into order/reverse to display descending - print
		Collections.sort(outputArray);
		Collections.reverse(outputArray);
		System.out.println(outputArray);
		sc.close();
	}





	public static int countNumChar(String text, char ch) {
		// Loop word
		countnum = 0;
		for(int i = 0; i< text.length(); i++) {
			//make all text lower case and check if i is equal to current alphabet letter
			if (text.toLowerCase().charAt(i) == ch) {   
				countnum +=1;
			}	
		}
		//return total count of letter [ch]
		return countnum;
	}
}
