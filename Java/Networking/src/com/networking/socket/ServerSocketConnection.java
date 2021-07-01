package com.networking.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketConnection {

	public static void main(String[] args) {
		
		//서버 소켓 호출
		ServerSocket serverSocket = null;
		//소켓 호출
		Socket socket = null;
	
		try {
			//서버 소켓 생성
			serverSocket = new ServerSocket(9000);
			System.out.println("클라이언트 맞을 준비 완료");
			
			//외부 서버에서 클라이언트 접속
			//소켓 받아주고, 반환
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결");
			System.out.println("socket : "+socket);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket!=null) socket.close();
				if(serverSocket!=null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

}
