package algorithms.part2;

public class Book_Allocation_Problem {
	
	public static void main(String[] args) {
		int[] arr = {12, 34, 67, 90};
		int minOfMaxPageThatCanBeAllocatedToStudent = minOfMaxPagesAllocated_test(arr, 2);
		
		System.out.println(minOfMaxPageThatCanBeAllocatedToStudent);
	}
	
	public static int minOfMaxPagesAllocated_BF(int[] books, int totalStudents) {
		
		int n = books.length;
		if(totalStudents > n) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i <= n-1; i++) {
			if(books[i] > max) {
				max = books[i];
			}
			sum = sum + books[i];
		}
		
		for(int i = max; i <= sum; i++) {
			if(possibleToAllocate(books, totalStudents, i)) {
				return i;
			}
		}
		
		return -1;
	}

	private static boolean possibleToAllocate(int[] books, int totalStudents, int maxPages) {
		
		int n = books.length;
		int pages = books[0];
		int studentCount = 1;
		
		for(int i = 1; i <= n-1; i++) {
			if(pages + books[i] <= maxPages) {
				pages = pages + books[i];
			} else {
				pages = books[i];
				studentCount++;
			}
		}
		
		if(studentCount <= totalStudents) {
			return true;
		}
		
		return false;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
	/*
	 * Optimal solution using binary search
	 * 
	 * T = O(n) + O(log(sum-max)*n)
	 */
	private static int minOfMaxPagesAllocated_test(int[] books, int totalStudents) {
		
		int n = books.length;
		
		if(totalStudents > n) {
			return -1;
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i <= n-1; i++) {
			if(books[i] > max) {
				max = books[i];
			}
			sum = sum + books[i];
		}
		
		int l = max;
		int r = sum;
		int ans = Integer.MAX_VALUE;
		while(l <= r) {
			int mid = (l+r)/2;
			int noOfStudents = noOfStudentsToWhichAllBooksAllocated(books, totalStudents, mid);
			if(noOfStudents <= totalStudents) {
				if(mid <= ans) {
					ans = mid;
				}
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return ans;
	}
	
	private static int noOfStudentsToWhichAllBooksAllocated(int[] books, int totalStudents, int maxPages) {
		
		int n = books.length;
		int allocatedPage = 0;
		int noOfStudents = 0;
		
		for(int i = 0; i <= n-1; i++) {
			allocatedPage += books[i];
			if(allocatedPage > maxPages) {
				i--;
				allocatedPage = 0;
				noOfStudents++;
			} else {
				if(i == n-1) {
					noOfStudents++;
				}
			}
		}
		
		return noOfStudents;
	}
}
