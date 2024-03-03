package algorithms;

public class ExcelColumnNumber {
	
	public static void main(String[] args) {
		
		String columnTitle = "ABC";
		int excelColumnNumber = excel_column_number(columnTitle);
		
		System.out.println(excelColumnNumber);
	}

	/*
	 * T = O(n)
	 * S = O(1)
	 */
	private static int excel_column_number(String columnTitle) {
		
		int n = columnTitle.length();
		int res = 0;
		for(int i = 0; i <= n-1; i++) {
			//res = res*26 + (columnTitle.charAt(i) - 64);
			res = res*26 + (columnTitle.charAt(i) - 'A' + 1);
		}
		return res;
	}
}
