package model;

import java.util.Scanner;


public class Input {
	
	public Input() {
		
	}
	public int readInt() {
	return new Scanner(System.in).nextInt();
	}
	
	public String readString() {
		return new Scanner(System.in).nextLine();
	}
}
