package com.company.dao;


import java.util.List;

import com.company.vo.NoticeBoardVO;

public interface NoticeBoardDAO {
	
	public int insertNboard (NoticeBoardVO vo) throws Exception;
	public List<NoticeBoardVO>listNboard (NoticeBoardVO vo) throws Exception;
	public NoticeBoardVO readNboard (NoticeBoardVO vo) throws Exception;
	public int updateNboard (NoticeBoardVO vo) throws Exception;
	public int updateHit (NoticeBoardVO vo) throws Exception;
	public int deleteNboard (NoticeBoardVO vo) throws Exception;
	public int countListNboard () throws Exception;
}
