package com.java.practice;

public class Hello_World {

	public static void main(String[] args) {
		//Hello World ���
				System.out.println("[Hello World ���]");
				System.out.println("Hello World!");
				
				System.out.println();
				
				//���� ����Ű�� [Ctrl]+[F11]
				
				//�� �ٲ� ���
				System.out.println("[�� �ٲ� ���]");
				System.out.println("�̰��� \n\'�ڹ�\'\n��");
				
				/* ������ 
				 * �ּ�
				 * �ޱ�
				 */
				
				System.out.println();
				
			
				//���ܰ��
				System.out.println("[���� ���]");
				System.out.println(166/2);
			
				System.out.println();
				
				
				//Operator
				System.out.println("[���� ������]");
				int a = 10;
				int b = ++a;
				System.out.println(a+","+b);
				
				System.out.println();

				System.out.println("[�� ������]");
				boolean bool1 = true;
				boolean bool2 = !bool1;
				System.out.println(bool2);
				
				System.out.println("a&&b�� a�� b �Ѵ� true�� ��� true ��ȯ : AND");
				System.out.println("a||b�� a�� b �� �� �ϳ��� true���� true ��ȯ : OR");
				
				System.out.println();

				System.out.println("[��� ������]");
				int x = 20, y=10;
				System.out.println(x*y);
				System.out.println(x/y);
				System.out.println(x%y);
				
				System.out.println();

				System.out.println("[�� ������]");
				System.out.println("a==b�� a�� b�� ���� : true");
				System.out.println("a!=b�� a�� b�� ���� �ʴ� : false");
				
				System.out.println();

				System.out.println("[���� ������]");
				int q = 10, p = 20;
				int result1 = q>p ? q++ :p--;
				System.out.println(result1);
				
				int result2 = q<p ? q++ : p--;
				System.out.println(result2);
	}

}
