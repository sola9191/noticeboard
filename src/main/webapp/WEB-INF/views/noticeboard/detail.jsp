<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<%@page import="java.sql.*"%>
<script>
	$(function(){
		if('${update}' == 'ok') { alert('글쓰기 수정에 성공했습니다'); }	
	});

</script>

<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>NOTICE BOARD</h3> 					
	<div class="form-group">
			  <label>작성자</label>
			  <input type="text"   name="bname"   id="bname"   class="form-control"   value="${boardVO.bname}" readonly> 
			</div>
			<div class="form-group">
			  <label>작성일</label>
			  <input type="text"   name="btitle"   id="btitle"   class="form-control"  value="${boardVO.bdate}" readonly> 
			</div>	
			<div class="form-group">
			  <label>최종수정일</label>
			  <input type="text"   name="btitle"   id="btitle"   class="form-control"  value="${boardVO.bfinaldate}" readonly> 
			</div>		
			<div class="form-group">
			  <label>제목</label>
			  <input type="text"   name="btitle"   id="btitle"   class="form-control"  value="${boardVO.btitle}" readonly> 
			</div>	
			<div class="form-group">
			  <label>내용</label>
			  <textarea name="bcontent"  id="bcontent"  cols="60"  rows="10"   class="form-control" readonly>${boardVO.bcontent}</textarea>
			</div>		
	<div class="text-right"    >
		 <a href="${pageContext.request.contextPath}/noticeboard/edit?bno=${boardVO.bno}"  class="btn btn-danger" >수정</a> 
		 <a href="${pageContext.request.contextPath}/noticeboard/delete?bno=${boardVO.bno}"  class="btn btn-danger" >삭제</a>    
		 <a href="${pageContext.request.contextPath}/noticeboard/list"  class="btn btn-info" >목록보기</a> 
	</div>						 
</div>	
<%@ include file="../inc/footer.jsp" %>
