package com.java;

public class Main1 {
/*
	public static void main(String[] args) {
		for (int i = 10; i > 0; i--) {
			int j = 0;
			innerWhile:
				while (j < i) {
				j++;
				if(j % 8 ==0) {
					break innerWhile;
			
			}else if( j % 2 ==0) {
				 continue;			
				 }

		}
			System.out.println();
	}
}

*/
	
	 public static void main(String[] args) {
	        int n = 4; // Number of rows
	        for (int i = 1; i <= n; i++) {
	            int currentNumber = 2 * i - 1;
	            
	            for (int j = 1; j <= n - i + 1; j++) {
	                System.out.print(currentNumber + " ");
	                currentNumber += 2;
	            }
	            
	            System.out.println();
	        }
	    }
}
