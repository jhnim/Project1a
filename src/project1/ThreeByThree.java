package project1;

import java.util.Random;
import java.util.Scanner;

import oracle.net.aso.n;


public class ThreeByThree {
	
	public static Scanner sc = new Scanner(System.in);
	public static Random ran = new Random();

	public static void array() {
		
		String[][] arr = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "x"}
			};

		String[][] win = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "x"}
		};

	
		
		//char endGame = winner(win);
		
	
		
		// 세로, 가로
		int r = arr.length, c=arr[0].length;
		
		for(int i=0 ; i<r ; i++) {
			for(int j=0 ; j<c ; j++) {
				System.out.print(arr[i][j]);
				
			}
			System.out.println();
		}
		
		System.out.println();
		suffle(arr);
		
		for(int i=0 ; i<r ; i++) {
			for(int j=0 ; j<c ; j++) {
				System.out.print(arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
	
	public static void suffle(String[][] arr) {
		
		String[] arr1 = {"a", "d", "w", "s"};
		
		for(int i=0 ; i<4 ; i++) {
			
			int n = ran.nextInt(4);
			
			shift(arr, arr1[n]);
			
		}
		
		
		
	}
	
	
	public static void shift(String[][] arr, String n) {
		
		
		
		
		int r=0;
		int c= 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[i].length ; j++) {
				if(arr[i][j]=="x") {
					r=i;
					c=j;
				}
			}
		}
		
		String temp;
		
		switch(n) {
		
		case "a":
			
			if(c>0) {
				
				temp = arr[r][c];
				arr[r][c]=arr[r][c-1];
				arr[r][c-1] = temp;
				
				c--;
			}
			
			
			break;
			
		case "d":
			
			if(c<2) {
				
				temp = arr[r][c];
				arr[r][c]=arr[r][c+1];
				arr[r][c+1] = temp;
				
				c++;
			}
			
			
			break;
			
		case "w":
			
			
			if(r>0) {
				
				temp = arr[r][c];
				arr[r][c]=arr[r-1][c];
				arr[r-1][c] = temp;
				
				r--;
			}
	
			break;
			
		case "s":
		
			if(r<2) {
				
				temp = arr[r][c];
				arr[r][c]=arr[r+1][c];
				arr[r+1][c] = temp;
				
				r++;
			}
			
			break;
		}
	}
	
	
	
//	public static char winner(String[][] arr) {
//		
//		for(int i=0 ; i<arr.length ; i++) {
//			for(int j=0 ; j<arr[i].length ; j++) {
//				if(arr[0][j]) 
//			}
//		}
//		
//		
//	}
	

	public static void move(String s) {
		
		int r=0;
		int c= 0;
		

		
//		
//		for(int i=0 ; i<arr.length ; i++) {
//			for(int j=0 ; j<arr[i].length ; j++) {
//				if(arr[i][j]=="x") {
//					r=i;
//					c=j;
//				}
//			}
//		}

		
		if("s"=="a") {
		}
		
		
	}
	
	public static void main(String[] args) {
		
		String[][] tBoard = new String[3][3];
		String reGame = "y"; 
		
		
		
		array();
		
		
		while(true) {
			
			System.out.println("[이동] a:Left d:Right w:Up s:Down");
			System.out.println("x:Exit");
			System.out.print("키를 입력해주세요:");
			String shift = sc.nextLine();
			
			
			if(shift!=null) {
				
				move(shift);
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
	}
}


