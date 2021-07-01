package com.networking.duplex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketConnection {

	public static void main(String[] args) {
		
		//서버 소켓 호출
		ServerSocket serverSocket = null;
		//소켓 호출
		Socket socket = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
	
		try {
			//서버 소켓 생성
			serverSocket = new ServerSocket(9000);
			System.out.println("클라이언트 맞을 준비 완료");
			
			//외부 서버에서 클라이언트 접속
			//소켓 outMessage 받아주고, 반환
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결");
			System.out.println("socket : "+socket);
		
			//소켓으로부터 inputStream 받아와 dataInputStream으로 확장
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			//소켓으로부터 outputStream 받아와 dataOutputStream으로 확장
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			while(true) {
				
				//클라이언트에서 보낸 메시지 서버에서 받아줌 read
				String ClientMessage = dataInputStream.readUTF();
				System.out.println("clientMessage : "+ClientMessage);
				
				//클라이언트에 메시지 잘 받았다는 메시지 전달 write
				dataOutputStream.writeUTF("메시지 전송 완료");
				dataOutputStream.flush();
				
				if(ClientMessage.equals("STOP")) break;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataOutputStream!=null) dataOutputStream.close();
				if(outputStream!=null) outputStream.close();
				if(dataInputStream!=null) dataInputStream.close();
				if(inputStream!=null) inputStream.close();
				
				if(socket!=null) socket.close();
				if(serverSocket!=null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

}
