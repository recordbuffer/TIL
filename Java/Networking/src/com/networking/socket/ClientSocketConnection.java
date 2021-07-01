package com.networking.socket;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketConnection {

	public static void main(String[] args) {
		
		//���� ȣ��
		Socket socket = null;
		
		try {
			//���� ���� + ��Ʈ��ȣ
			socket = new Socket("localhost",9000);	//127.0.0.1 : localhost
			System.out.println("���� ����");
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
