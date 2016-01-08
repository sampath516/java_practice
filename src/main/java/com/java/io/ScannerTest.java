package com.java.io;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int arraySize = scanner.nextInt();
		int[] array = new int[100];
		String remainingContentInLine = scanner.nextLine();
		System.out.println(remainingContentInLine);
		int i = 0;
		while(scanner.hasNextInt()){
			array[i++] = scanner.nextInt();
		}
		for(int j =0; j<arraySize;j++){
			System.out.print(array[j]+", ");
		}
	
	}

}
