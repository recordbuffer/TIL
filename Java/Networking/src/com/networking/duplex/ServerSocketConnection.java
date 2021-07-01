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
		
		//���� ���� ȣ��
		ServerSocket serverSocket = null;
		//���� ȣ��
		Socket socket = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
	
		try {
			//���� ���� ����
			serverSocket = new ServerSocket(9000);
			System.out.println("Ŭ���̾�Ʈ ���� �غ� �Ϸ�");
			
			//�ܺ� �������� Ŭ���̾�Ʈ ����
			//���� outMessage �޾��ְ�, ��ȯ
			socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ ����");
			System.out.println("socket : "+socket);
		
			//�������κ��� inputStream �޾ƿ� dataInputStream���� Ȯ��
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			//�������κ��� outputStream �޾ƿ� dataOutputStream���� Ȯ��
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			while(true) {
				
				//Ŭ���̾�Ʈ���� ���� �޽��� �������� �޾��� read
				String ClientMessage = dataInputStream.readUTF();
				System.out.println("clientMessage : "+ClientMessage);
				
				//Ŭ���̾�Ʈ�� �޽��� �� �޾Ҵٴ� �޽��� ���� write
				dataOutputStream.writeUTF("�޽��� ���� �Ϸ�");
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
