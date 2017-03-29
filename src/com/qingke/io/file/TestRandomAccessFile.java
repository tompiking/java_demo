package com.qingke.io.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		randomFile("D:/tom/dir/file1.txt");
		readFile("D:/tom/dir/file1.txt");
	}
	
	public static void randomFile(String filePath){
		RandomAccessFile acc = null;
		try {
			acc = new RandomAccessFile(filePath,"rw");
			acc.writeChars("dddd");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(acc!=null){
				try {
					acc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readFile(String filePath){
		RandomAccessFile acc = null;
		try {
			acc = new RandomAccessFile(filePath,"r");
			System.out.println(acc.readLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(acc!=null){
				try {
					acc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
