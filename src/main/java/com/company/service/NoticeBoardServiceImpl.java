package com.company.service;

import java.io.File;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.company.dao.NoticeBoardDAO;
import com.company.vo.NoticeBoardVO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

	@Autowired
	NoticeBoardDAO dao;
	@Override
	public int insertNboard(NoticeBoardVO vo) throws Exception {
		vo.setBip(InetAddress.getLocalHost().getHostAddress());
		return dao.insertNboard(vo);
	}

	@Override
	public List<NoticeBoardVO> listNboard(NoticeBoardVO vo) throws Exception {
		return dao.listNboard(vo);
	}

	@Override
	public NoticeBoardVO readNboard(NoticeBoardVO vo) throws Exception {
		return dao.readNboard(vo);
	}

	@Override
	public int updateNboard(NoticeBoardVO vo) throws Exception {
		return dao.updateNboard(vo);
	}

	@Override
	public int updateHit(NoticeBoardVO vo) throws Exception {
		return dao.updateHit(vo);
	}

	@Override
	public int deleteNboard(NoticeBoardVO vo) throws Exception {
		return dao.deleteNboard(vo);
	}

	@Override
	public int countListNboard() throws Exception {
		return dao.countListNboard();
	}

}
