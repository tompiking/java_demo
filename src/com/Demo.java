package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

		public static void main(String[] args) {
			FileInputStream fis=null;
			FileOutputStream fos=null;
			try {
				fis = new FileInputStream("a.txt");
				fos=new FileOutputStream("b.txt");

				byte[] bytes=new byte[4];
				int len=0;
				while((len=fis.read(bytes))!=-1){
					fos.write(bytes,0,len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(fos!=null&&fis!=null){
					try {
						fos.close();
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
			
			
//			BufferedReader br=new BufferedReader(new FileReader("a.txt")); 
//			BufferedWriter bw=new BufferedWriter(new FileWriter("b.txt"));
//			String line=null;
//			while((line=br.readLine())!=null){
//				bw.write(line);
//				bw.newLine();
//				bw.flush();
//			}
//			bw.close();
//			br.close();
		}

}
