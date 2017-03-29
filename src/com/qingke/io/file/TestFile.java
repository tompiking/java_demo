package com.qingke.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		createDir("D:/tom/dir");
//		createFile("D:/tom/dir/file1.txt");
//		deleteFile("D:/tom/dir");
//		writeFile("D:/tom/dir/file1.txt");
		readFile("D:/tom/dir/file1.txt");
		System.out.println("=============byte=============");
		byteReadFile("D:/tom/dir/file1.txt");
	}
	
	public static void createDir(String dir){
		File file = new File(dir);
		System.out.println("CreateDir");
		System.out.println(file.mkdirs());
	}
	public static void createFile(String filePath){
		File file = new File(filePath);
		try {
			System.out.println("CreateFile");
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteFile(String filePath){
		File file = new File(filePath);
		System.out.println("Delete");
		System.out.println(file.delete());
	}
	
	public static void writeFile(String filePath){
		File file = new File(filePath);
		BufferedWriter bWriter = null;
		try {
			FileWriter writer = new FileWriter(file,true);
			bWriter = new BufferedWriter(writer);
			bWriter.write("111");
			bWriter.write(222);
			char[] a = {'a','a','a'};
			bWriter.write(a);
			char[] b = {'b','b','b','b'};
			bWriter.write(b, 0, 4);
			bWriter.newLine();
			bWriter.write(b, 0, 4);
			bWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bWriter!=null){
				try {
					bWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void readFile(String filePath){
		File file = new File(filePath);
		BufferedReader bReader = null;
		try {
			FileReader reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			String line = bReader.readLine();
			while(line!=null){
				System.out.println(line);
				line = bReader.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bReader!=null){
				try {
					bReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void byteReadFile(String filePath){
		File file = new File(filePath);
		
		try {
			FileInputStream input = new FileInputStream(file);
//			System.out.println(input.read());
//			int length = input.read();
//			input.reset();
			byte[] b = new byte[input.available()];
			input.read(b);
			System.out.println(new String(b));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
