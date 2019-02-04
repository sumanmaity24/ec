package com.Connect;

public class pc {
	static int a = 10;
	static int b = 0;
	static int c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.exit(0);
			System.out.println("try");

			try {
				System.out.println("try");
				
				c = a / b;
	
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace();
			} finally {
				System.out.println("tfg");
			}

		} catch (Exception e) {
			System.out.println("finally");
			// return;
		}
		finally {
			System.out.println("otfg");
		}
		System.out.println("out");
	}

}
