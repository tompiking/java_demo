package com.qingke.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements MainStop {
	private int port;
	private Socket socket;
	public boolean shouldRun = true;
	public InputHander input;
	public Scanner sc = new Scanner(System.in);
	public String name;
	
	public Client(int port){
		this.port = port;
	}
	
	public static void main(String[] args){
		Client client = new Client(3000);
		System.out.println("请输入名字：");
		client.name = client.sc.nextLine();
		
		client.createSocket();
		BufferedWriter writer = client.createOutput(client.socket);
		client.input = new InputHander(client.createInput(client.socket),client);
		client.input.sendName(client.name,writer);
		client.input.start();
		
		client.write(writer);
		client.close();
	}
	
	public void createSocket(){
		try {
			System.out.println("启动中。。。");
			socket = new Socket("localhost",this.port);
			System.out.println("启动成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedReader createInput(Socket socket){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}
	
	public BufferedWriter createOutput(Socket socket){
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer;
	}
	
	public void write(BufferedWriter writer){
		try {
			while(shouldRun){
				System.out.println("请输入：");
				String text = sc.nextLine();
				writer.write(text+"\r");
				writer.flush();
				System.out.println("你说："+text);
				if("bye".equals(text)){
					shouldRun = false;
					this.input.shouldRun = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			this.socket.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setShouldRun(boolean canRun) {
		// TODO Auto-generated method stub
		this.shouldRun = canRun;
	}

}
