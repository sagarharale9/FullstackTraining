package PracticwByA;

import java.util.Random;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

//=============Task 6a - make a .txt file with random 100 character input=====================

public class filehandlingAssignment{
	public static void main(String[] args) throws IOException 
	{
		String s = "ASDFGHJKLQWERTYUIOPZXCVBNMasdfghjklqwertyuiopzxcvbnm1234567890";
		StringBuilder sb = new StringBuilder();

		try (
				FileWriter fw = new FileWriter("D:\\Birlasoft\\Assignmen6.txt")) {
			System.out.println("FILE HAS CREATED SUCCESSFULLY");
			Random r = new Random();
			int n=100; 
			//n= number of inputs

			for(int i = 0; i <= n; i++) {
				int index = r.nextInt(s.length());
				char randomChar = s.charAt(index);
				fw.write(randomChar);
				sb.append(randomChar);
			}
			System.out.println(n+": RANDOM INPUTS ARE ENTERED ");
		}

		// overriding to- toString()
		sb.toString();

	}
}





