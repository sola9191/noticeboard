package com.company.notice;

import java.net.InetAddress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.NoticeBoardDAO;
import com.company.vo.NoticeBoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class Test004_DaoTest {

	@Autowired
	private NoticeBoardDAO dao;

//	@Test
	//글삽입 test
//	public void insert_test() throws Exception { 
//		NoticeBoardVO vo = new NoticeBoardVO(); 
//		vo.setBname("지솔아"); 
//		vo.setBtitle("제목");
//		vo.setBcontent("내용"); 
//		vo.setBpass("비밀번호");
//		vo.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println(dao.insertNboard(vo));	 
//	 }
	 
	//글전체조회 test
//	public void list_test() throws Exception {
//		System.out.println(dao.listNboard());
//
//	}
	
	//글상세보기 test
//	public void read_test() throws Exception {
//		NoticeBoardVO vo = new NoticeBoardVO();
//		vo.setBno(1);
//		System.out.println(dao.readNboard(vo));
//		
//	}
	//글수정 test
//	public void update_test() throws Exception{
//		NoticeBoardVO vo = new NoticeBoardVO();
//		vo.setBname("지솔아1");
//		vo.setBtitle("제목1");
//		vo.setBcontent("내용");
//		vo.setBno(1);
//		vo.setBpass("비밀번호");
//		if(dao.updateNboard(vo) > 0) {
//			System.out.println(dao.readNboard(vo));
//		}else {
//			System.out.println("수정실패");
//		}
//		
//	}
	//조회수업데이트 test	
//	public void updateHit_test() throws Exception{
//		NoticeBoardVO vo = new NoticeBoardVO();
//		vo.setBno(1);
//		if(dao.updateHit(vo) > 0) {
//			System.out.println(dao.readNboard(vo));
//		}else {
//			System.out.println("업데이트실패");
//		}
//		
//	}
	//글삭제 test
//	public void delete_test() throws Exception{
//		NoticeBoardVO vo = new NoticeBoardVO();
//		vo.setBno(1);
//		vo.setBpass("비밀번호");
//		if(dao.deleteNboard(vo) > 0 ) {
//			System.out.println("삭제 성공");
//		}else {
//			System.out.println("삭제 실패");
//		}
//	}
	
	//트랜잭션 테스트
	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Test
	@Rollback(false)
	public void tx_test() throws Exception {
		NoticeBoardVO vo = new NoticeBoardVO();
		vo.setBno(2);
		dao.updateHit(vo);
		dao.readNboard(vo);
		
	}
}
