package com.qingke.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class InputHander extends Thread {
	MainStop mainStop;
	BufferedReader reader;
	boolean shouldRun;
	BufferedWriter writer;
	boolean nameIsSet;
	
	public InputHander(BufferedReader reader,MainStop ms){
		mainStop = ms;
		this.reader = reader;
		shouldRun = true;
		nameIsSet = false;
	}
	
	public void sendName(String name,BufferedWriter writer){
		try {
			writer.write(name+"\r");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(shouldRun){
			try {
				String content = reader.readLine();
				if(mainStop instanceof Server){
					Server server = (Server)mainStop;
					serverRoad(server,content);
					if(server.writers.isEmpty()) continue;
				}else if(mainStop instanceof Client){
					System.out.println(content);
				}
			} catch (IOException e) {
				if(mainStop instanceof Server){
					System.out.println("结束");
					shouldRun = false;
				}else if(mainStop instanceof Client){
					System.out.println("结束");
					Client client = (Client)mainStop;
					shouldRun = false;
					client.setShouldRun(false);
				}
			}
		}
	}
	
	private void serverRoad(Server server,String content){
		if(nameIsSet){
			server.sendToAll(server.writers.get(writer)+"说："+content+"\r", writer);
			if("bye".equals(content)){
				shouldRun = false;
				mainStop.setShouldRun(false);
				server.writers.remove(writer);
			}
		}else{
			server.sendToAll(content+"加入聊天室\r", writer);
			nameIsSet = true;
			server.writers.put(writer, content);
		}
	}
}
