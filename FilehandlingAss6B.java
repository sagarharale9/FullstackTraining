package PracticwByA;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//make 1000 text file files in your folder 1st with sequence and display time for creating all the files, 
//then create it with threading and display the time needed.

public class FilehandlingAss6B {
	// MAIN METHOD
	public static void main(String[] args) 
	{
		Long start = System.currentTimeMillis();
		files1000();
		Long end = System.currentTimeMillis();
		Long total = end - start;
		System.out.println("Taken time to Execute  with method is: " + total + " ms");

		Long start1 = System.currentTimeMillis();
		CreatfileUsingThread thread = new CreatfileUsingThread();
		thread.start();
		Long end1 = System.currentTimeMillis();
		Long total1 = end1 - start1;
		System.out.println("taken  time to execute with thread is: " + total1 + " ms");

	}

	public static void files1000(){
		try {
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			int n=1000;

			for (int i = 0; i <=n; i++) { 
				File f = new File("D:\\Birlasoft\\creat 1000 files\\" + String.valueOf(i + 1) +".txt");
				if (f.createNewFile()) {
					System.out.println("File create successfully " + f.getName());
				} 
				else {
					System.out.println("File already exist with the name of:"+f.getName());
				}
				FileWriter myWriter = new FileWriter("D:\\Birlasoft\\creat 1000 files\\" +String.valueOf(i + 1) + ".txt");
				LocalDateTime now = LocalDateTime.now();
				myWriter.write("HII HELLO THIS IS A SAMPLE TXT FILE" +String.valueOf(dt.format(now)));
				myWriter.close();
			}
		}
		catch (Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}

class CreatfileUsingThread extends Thread{
	public void run(){
		try {
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			int n=1000;
			for (int i = 0; i <=n; i++){
				File f = new File("D:\\Birlasoft\\creat 1000 Thread files\\" + i + ".txt");

				if (f.createNewFile()) {
					System.out.println("File created: " + f.getName());
				} 
				else  {
					System.out.println("file creating failed.");
					System.out.println("File already exists.");
				}
				FileWriter fw = new FileWriter("D:\\Birlasoft\\creat 1000 Thread files\\" + i + ".txt");
				LocalDateTime now = LocalDateTime.now();
				fw.write("HII HELLO THIS IS A SAMPLE TXT FILE USING THREAD " +String.valueOf(dt.format(now)));
				fw.close();

				System.out.println("File " + String.valueOf(i + 1) + ".txt created at " + String.valueOf(dt.format(now)));
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception occured ");
			System.out.println("File Not Created ");
			e.printStackTrace();
		}
	}
}
