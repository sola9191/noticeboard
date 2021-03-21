package com.company.notice;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"} )
public class Test003_MyBatis {
	@Autowired
	private SqlSessionFactory sqlFactory;
	@Test
	public void mybatisTest() {
		
		SqlSession session = sqlFactory.openSession();
		System.out.println(session);
		
		
	}
	

}
