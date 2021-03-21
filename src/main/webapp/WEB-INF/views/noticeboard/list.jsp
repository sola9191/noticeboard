<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header.jsp" %>
<!--  END HEADER -->
<!--  END HEADER -->
<script>
if('${insert}' == 'success') { alert('글쓰기에 성공했습니다.'); } 
if('${insert}' == 'fail') { alert('글쓰기에 실패했습니다.'); }
if('${edit}' == 'success') { alert('글수정에 성공했습니다.'); }
if('${edit}' == 'fail') { alert('글수정에 실패했습니다.'); }
if('${delete}' == 'success') { alert('글삭제에 성공했습니다.'); }
if('${delete}' == 'fail') { alert('글삭제에 실패했습니다.'); }
</script>

<div class="container" style="margin-top:5%; min-height:500px">
	<h3>NOTICE BOARD</h3>
	<table  class="table table-striped">
		<thead>
			<tr>
				<th scope="col" width="10%">NO</th>
				<th scope="col" width="30%">TITLE</th>
			    <th scope="col" width="10%">WRITER</th>
			    <th scope="col" width="20%">DATE</th>
			    <th scope="col" width="5%">HIT</th>
			</tr>
		</thead>
		<tbody>
			<c:set var ="num" value="${pageTotal - ((items.bottom_current -1) * 5) }"/>
			<c:forEach items="${list}" var="dto" varStatus="status" >			
			 <tr>
			 	<td>${num}</td>
			 	<td><a href="${pageContext.request.contextPath}/noticeboard/detail?bno=${dto.bno}">${dto.btitle}</a></td>
				<td>${dto.bname}</td>
				<td>${dto.bdate}</td>
				<td><span class="badge bg-red">${dto.bhit}</span></td>
			</tr>
			<c:set var="num" value="${num-1 }"></c:set>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
			<td colspan="5" class="text-center">
				<ul class="pagination">
					<c:if test="${items.bottom_start>items.bottomlist}">
						<li><a href="${pageContext.request.contextPath}/noticeboard/list?pstartno=${(items.bottom_start-2)*items.onepageLimit}"><</a></li>				
					</c:if>
					<c:forEach var="i" begin="${items.bottom_start}" end="${items.bottom_end}" >
						<li <c:if test="${items.bottom_current==i}">class="active"</c:if>>
						<a href="${pageContext.request.contextPath}/noticeboard/list?pstartno=${(i-1)*items.onepageLimit}">${i}</a>
						</li> 
					</c:forEach>
					<c:if test="${items.pageAll>items.bottom_end}">
						<li><a href="${pageContext.request.contextPath}/noticeboard/list?pstartno=${items.bottom_end*items.onepageLimit}">></a></li>				
					</c:if>
				</ul>
				</td>
			</tr>
		</tfoot>		
	</table>
	<p  class="text-right"><a href="${pageContext.request.contextPath}/noticeboard/write"   class="btn btn-danger">글쓰기</a></p>
</div>

<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="../inc/footer.jsp" %>