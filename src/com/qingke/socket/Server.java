package com.qingke.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.logging.log4j.*;

public class Server implements MainStop {
	private int port;
	private ServerSocket server;
	public boolean shouldRun;
	public InputHander input;
	public Scanner sc;
	public HashMap<BufferedWriter,String> writers;
	public Logger logger;
	
	public Server(int port){
		this.port = port;
		shouldRun = true;
		sc = new Scanner(System.in);
		writers = new HashMap<BufferedWriter,String>();
		logger = LogManager.getLogger();
		
		logger.error("========================");
	}
	
	public static void main(String[] args){
		Server server = new Server(3000);
		server.createSocket();
		while(true){
			Socket socket = server.accept();
			BufferedWriter writer = server.createOutput(socket);
			server.writers.put(writer, "dd");
			server.input = new InputHander(server.createInput(socket),server);
			server.input.writer = writer;
			server.input.start();
		}
//		server.close(socket);
	}
	
	public void createSocket(){
		try {
			logger.error("启动中。。。");
			server = new ServerSocket(port);
			logger.info("启动成功，等待连接。。。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Socket accept(){
		Socket socket = null;
		try {
			socket = server.accept();
			logger.info("监听到连接，开始通信");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socket;
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
				if("bye".equals(text)){
					this.shouldRun = false;
					this.input.shouldRun = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendToAll(String msg,BufferedWriter from){
		for(BufferedWriter writer : writers.keySet()){
			if(writer.equals(from)) continue;
			try {
				logger.info(msg);
				writer.write(msg);
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				writers.remove(writer);
			}
		}
	}
	
	public void close(Socket socket){
		try {
			socket.close();
			this.server.close();
			logger.info("服务器关闭");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

	@Override
	public void setShouldRun(boolean canRun) {
		this.shouldRun = canRun;
	}

}
