package practice.dsa.sheet.part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Video link : https://www.youtube.com/watch?v=WFd478BG4o8
 */
public class Fraction_To_Recurring_Decimal {
	
	public static void main(String[] args) {
		
		int numerator = 1;
		int denominator = -1;
		
		String output = fractionToDecimal(numerator, denominator);
		
		System.out.println(output);
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
        
		if(denominator == 0) {
			return "undefined";
		} else if(numerator == 0) {
			return "0";
		} 
		
		int sign = 1;
		if(numerator < 0 && denominator > 0) {
			sign = -1;
		} else if(numerator > 0 && denominator < 0) {
			sign = -1;
		}
		
		long n = Math.abs((long)numerator);
		long d = Math.abs((long)denominator);
		
		if(n % d == 0) {
			return sign == 1 ?  "" + (n/d) : "-" + (n/d);
		}
		
		String output = "";
		output = output + (n/d);
		output = output + ".";
		
		Map<String, Integer> hMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		int count = 0;
		while(true) {
			long rem = n % d;
			
			if(rem == 0) {
				for(int i = 0; i < count; i++) {
					output = output + list.get(i).substring(list.get(i).length() - 1);
				}
				break;
			}
			
			n = rem * 10;
			long q = n / d;
			
			Integer index = hMap.get(""+(n+q));
			if(index == null) {
				hMap.put(""+(n+q), count);
				list.add(""+(n+q));
				count++;
			} else {
				
				for(int i = 0; i < index; i++) {
					output = output + list.get(i).substring(list.get(i).length() - 1);
				}
				
				output = output + "(";
				for(int i = index; i < count; i++) {
					output = output + list.get(i).substring(list.get(i).length() - 1);
				}
				output = output + ")";
				break;
			}
		}
		
		return sign == 1 ? output : "-" + output;
    }
}
