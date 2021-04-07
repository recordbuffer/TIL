package com.db.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	//session 생성을 위한 SqlSessionFactory 만들어줌
	private SqlSessionFactory sqlSessionFactory;
	
	//getter 메서드만 만들어줌
	public SqlSessionFactory getSqlSessionFactory() {
		
		//Config.xml 경로
		String resource = "db/config.xml";
		
		//config.xml 파일 정보 읽어옴
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			
			//읽어온 정보로 SqlSessionFactory 객체 생성함
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return sqlSessionFactory;
	}
}
