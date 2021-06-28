package com.practice.inherit;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		
		Computer cpt = new Computer("Apple","01","macBookPro",2450000,new Date(),"M1",512,16,"macOs");
		
		System.out.println(cpt.toString());
				

	}

}
