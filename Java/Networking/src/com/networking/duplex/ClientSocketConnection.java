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
		
		//���� ȣ��
		Socket socket = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
				
		try {
			//���� ���� + ��Ʈ��ȣ
			socket = new Socket("localhost",9000);	//127.0.0.1 : localhost
			System.out.println("���� ����");

			//�������κ��� outputStream �޾ƿ� dataOutputStream���� Ȯ��
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			//�������κ��� inputStream �޾ƿ� dataInputStream���� Ȯ��
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("�޽��� �Է��ϼ���");
				String outMessage = sc.nextLine();
				
				//������ �޽��� ���� write
				dataOutputStream.writeUTF(outMessage);
				dataOutputStream.flush();
				
				//�������� ���� �޽��� Ŭ���̾�Ʈ���� �޾��� read
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
