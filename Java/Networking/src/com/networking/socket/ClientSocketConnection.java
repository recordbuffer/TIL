package com.networking.socket;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketConnection {

	public static void main(String[] args) {
		
		//소켓 호출
		Socket socket = null;
		
		try {
			//소켓 생성 + 포트번호
			socket = new Socket("localhost",9000);	//127.0.0.1 : localhost
			System.out.println("서버 연결");
			System.out.println("socket : "+socket);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket!=null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
