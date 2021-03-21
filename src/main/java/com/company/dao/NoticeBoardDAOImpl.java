package com.company.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.vo.NoticeBoardVO;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {

	@Autowired
	private SqlSession session;
	private static final String namespace="com.company.mappers.NoticeMapper";
	
	
	@Override
	public int insertNboard(NoticeBoardVO vo) throws Exception {
		return session.insert(namespace + ".insertNboard", vo);
	}

	@Override
	public List<NoticeBoardVO> listNboard(NoticeBoardVO vo) throws Exception {
		return session.selectList(namespace + ".listNboard", vo);
	}

	@Override
	public NoticeBoardVO readNboard(NoticeBoardVO vo) throws Exception {
		return session.selectOne(namespace + ".readNboard", vo);
	}

	@Override
	public int updateNboard(NoticeBoardVO vo) throws Exception {
		return session.update(namespace + ".updateNboard", vo);
	}

	@Override
	public int updateHit(NoticeBoardVO vo) throws Exception {
		return session.update(namespace + ".updateHit", vo);
	}

	@Override
	public int deleteNboard(NoticeBoardVO vo) throws Exception {
		return session.delete(namespace + ".deleteNboard", vo);
	}
	@Override
	public int countListNboard() throws Exception {
		return session.selectOne(namespace + ".countListNboard");
	}

}
