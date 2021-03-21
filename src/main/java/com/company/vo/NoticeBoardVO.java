package com.company.vo;

public class NoticeBoardVO {
	
	private int bno; 			//글번호
	private String bname;		//작성자이름
	private String btitle;		//제목	
	private String bcontent;	//내용	
	private String bfile;		//첨부파일
	private int bhit;			//조회수
	private String bdate;		//글작성일
	private String bfinaldate;	//글최종수정일
	private String bip;			//ip
	private String bpass;		//글비밀번호
	private	int	pageSize;		//한 페이지당 보여줄 게시글 수
	private	int	startIndex;		//시작 index
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBfinaldate() {
		return bfinaldate;
	}
	public void setBfinaldate(String bfinaldate) {
		this.bfinaldate = bfinaldate;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public String getBpass() {
		return bpass;
	}
	public void setBpass(String bpass) {
		this.bpass = bpass;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
