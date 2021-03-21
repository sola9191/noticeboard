package com.company.vo;

public class Pagination {

	private int pageTotal;		// 게시판 전체글갯수
	private int onepageLimit;	// 한페이지당 보여줄 글갯수
	private int pageAll;		// 하단 index 갯수
	private int pstartno;		// db에서 가져올 번호(ex: 1번버튼시 0, 2번버튼 클릭시 pstartno+onepageLimit)
	private int bottomlist;		// 하단에 보여질 페이징 갯수 <이전,1,2,3,4,5,다음>
	private int bottom_current;	// 현재페이지번호
	private int bottom_start;	// 시작페이지번호
	private int bottom_end;		// 마지막페이지번호 
		
	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Pagination(int pageTotal, int pstartno) {
		// 한페이지당 보여줄 글갯수 [5]
		this.onepageLimit = 5;		
		// 하단 index의 갯수 ex) 글갯수 37개면 37/5.0 => 7.4 ==> 8
		this.pageAll = (int) Math.ceil(pageTotal/(float)onepageLimit);
		// 하단에 보여질 페이징 갯수 [5]
		this.bottomlist = 5;	
		// 현재페이지 ex) page1일때 pstartno은 0 => 1/10.0 = 0.1		
		this.bottom_current = (int) Math.ceil((pstartno +1)/(float)onepageLimit);
		// (보여지는)시작페이지 ex) page1일때 (0/5.0)*0+1 = 1 page6일때 (5/5.0)*5+1 = 6		
		this.bottom_start = ((int) Math.floor((bottom_current-1)/(float)bottomlist))*bottomlist +1;
		// (보여지는)마지막페이지 ex) page1일때 1+5-1 = 5 page6일때 6+5-1 = 10	
		this.bottom_end = bottom_start+bottomlist -1;
		// 마지막 페이지가 하단 index 갯수보다 크면 두개 같음
		if(pageAll < bottom_end) {  bottom_end = pageAll; }
	
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getOnepageLimit() {
		return onepageLimit;
	}

	public void setOnepageLimit(int onepageLimit) {
		this.onepageLimit = onepageLimit;
	}

	public int getPageAll() {
		return pageAll;
	}

	public void setPageAll(int pageAll) {
		this.pageAll = pageAll;
	}

	public int getPstartno() {
		return pstartno;
	}

	public void setPstartno(int pstartno) {
		this.pstartno = pstartno;
	}

	public int getBottomlist() {
		return bottomlist;
	}

	public void setBottomlist(int bottomlist) {
		this.bottomlist = bottomlist;
	}

	public int getBottom_current() {
		return bottom_current;
	}

	public void setBottom_current(int bottom_current) {
		this.bottom_current = bottom_current;
	}

	public int getBottom_start() {
		return bottom_start;
	}

	public void setBottom_start(int bottom_start) {
		this.bottom_start = bottom_start;
	}

	public int getBottom_end() {
		return bottom_end;
	}

	public void setBottom_end(int bottom_end) {
		this.bottom_end = bottom_end;
	}
		
}
	
	