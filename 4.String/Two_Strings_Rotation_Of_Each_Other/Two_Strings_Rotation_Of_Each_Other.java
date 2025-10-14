package algorithms.part3;

public class Two_Strings_Rotation_Of_Each_Other {
	
	public static void main(String[] args) {
		
		String str = "HelloWorld";
		String goal = "loWorldHel";
		
		boolean check = rotatationString(str, goal);
		
		System.out.println(check);
	}
	
	/*
	 * T = O(time_to_find_length) + O(search_substring)
	 * => T = O(m) + O(n) + O(m + n)
	 * Note: For searching substring we will use KMP algorithm
	 * 
	 */
	public static boolean rotatationString(String str, String goal) {

        if(str.length() != goal.length()) {
            return false;
        }

        str = str + str;
        if(str.contains(goal)) {
            return true;
        }
        return false;
    }
}
