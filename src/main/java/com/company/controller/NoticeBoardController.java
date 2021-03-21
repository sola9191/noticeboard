package com.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.NoticeBoardService;
import com.company.vo.NoticeBoardVO;
import com.company.vo.Pagination;

@Controller
@RequestMapping("/noticeboard/*")
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	@Autowired
	NoticeBoardService service;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String boardWriteForm() {
		logger.info("::::::::::BOARD 글쓰기폼");
		return "/noticeboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String boardWriteAction(NoticeBoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info(":::::::::: BOARD 글쓰기");
		String result = "fail";
		if(service.insertNboard(vo) > 0 ) {
			result = "success";
		}
		rttr.addFlashAttribute("insert", result);
		return "redirect:/noticeboard/list";		
	}
	
	//글목록보기 ( + 페이징기능추가)
	@RequestMapping(value="/list", method = { RequestMethod.GET, RequestMethod.POST} )
	public String boardList(Model model, HttpServletRequest request,
			@RequestParam(defaultValue="0") int pstartno, NoticeBoardVO vo) throws Exception {
		logger.info(":::::::::: BOARD 리스트");		
		int pageTotal = service.countListNboard();
		
		Pagination pagination = new Pagination(pageTotal, pstartno);	
		vo.setStartIndex(pstartno); //시작페이지
		vo.setPageSize(pagination.getBottomlist()); //보여줄 게시글 수

		model.addAttribute("pageTotal", pageTotal);
		model.addAttribute("list", service.listNboard(vo));
		model.addAttribute("items", pagination);	
		
		return "/noticeboard/list";		
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String readBoard(@RequestParam("bno") int bno, Model model) throws Exception {
		NoticeBoardVO vo = new NoticeBoardVO();
		vo.setBno(bno);
		service.updateHit(vo);
		model.addAttribute("boardVO", service.readNboard(vo));
		return "/noticeboard/detail";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String boardEditForm(@RequestParam("bno") int bno, Model model) throws Exception {
		logger.info("::::::::::::::: BOARD 수정하기폼");
		NoticeBoardVO vo = new NoticeBoardVO();
		vo.setBno(bno);
		model.addAttribute("boardVO", service.readNboard(vo));
		return "/noticeboard/edit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String boardEditAction(NoticeBoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info(":::::::::::: BOARD 수정하기");
		String result = "fail";
		if(service.updateNboard(vo) > 0 ) {
			result = "success";			
		}
		rttr.addFlashAttribute("edit", result);
		return "redirect:/noticeboard/list";		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String boardDeleteForm(@RequestParam("bno") int bno, Model model) throws Exception {
		logger.info("::::::::::::::: BOARD 삭제폼");
		NoticeBoardVO vo = new NoticeBoardVO();
		vo.setBno(bno);
		model.addAttribute("boardVO", service.readNboard(vo));
		return "/noticeboard/delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String boardDelete(NoticeBoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("::::::::::::::: BOARD 삭제");
		String result = "fail";
		if(service.deleteNboard(vo) > 0 ) {
			result = "success";			
		}
		rttr.addFlashAttribute("delete", result);
		return "redirect:/noticeboard/list";				
	}
}	
