package practice.dsa.sheet.part3;

public class Reverse_Only_Letters {
	
	public static void main(String[] args) {
		
		String str = "7_28]";
		String output = reverseOnlyLetters(str);
		
		System.out.println(output);
	}
	
	public static String reverseOnlyLetters(String str) {

        StringBuilder sb = new StringBuilder(str);

        int n = str.length();
        int i = 0; 
        int j = n-1;
        while(i < j) {
            if(!isAlphabet(sb.charAt(i))) {
                i++;
                if(i >= j) {
                    break;
                }
            }

            if(!isAlphabet(sb.charAt(j))) {
                j--;
                if(i >= j) {
                    break;
                }
            } 
            
            if(isAlphabet(sb.charAt(i)) && isAlphabet(sb.charAt(j))) {
            	char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);

                i++;
                j--;
            }
        }

        return sb.toString();
    }

    public static boolean isAlphabet(char ch) {

        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            return true;
        }

        return false;
    }
}
