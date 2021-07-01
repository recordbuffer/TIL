package com.networking.duplex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketConnection {

	public static void main(String[] args) {
		
		//소켓 호출
		Socket socket = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
				
		try {
			//소켓 생성 + 포트번호
			socket = new Socket("localhost",9000);	//127.0.0.1 : localhost
			System.out.println("서버 연결");

			//소켓으로부터 outputStream 받아와 dataOutputStream으로 확장
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			//소켓으로부터 inputStream 받아와 dataInputStream으로 확장
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("메시지 입력하세요");
				String outMessage = sc.nextLine();
				
				//서버로 메시지 전달 write
				dataOutputStream.writeUTF(outMessage);
				dataOutputStream.flush();
				
				//서버에서 보낸 메시지 클라이언트에서 받아줌 read
				String inMessage = dataInputStream.readUTF();
				System.out.println("inMessage : "+inMessage);
				
				if(outMessage.equals("STOP")) break;
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
