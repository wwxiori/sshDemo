<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function cha(){
  				var s_name=document.getElementById("s_name").value;
  				window.location.href="<%=path%>/student!MoFen?studentEntity.s_name="+s_name+"&page=1";
  			}
  function fen(page){
  				var s_name=document.getElementById("s_name").value;
  				var zong=document.getElementById("zong").value;
  				var zong=parseInt(zong);
  				if(page<=0){
  					page=1;
  				}else if(page>=zong){
  					page=zong;
  				}
  				window.location.href="<%=path%>/student!MoFen?page="+page+"&studentEntity.s_name="+s_name+"";
  			}		
  </script>
  
  <body>
  	<a href="<%=path %>/jsp/studentadd.jsp" >新增</a><hr>
 	<input type="text" id="s_name" value="<s:property value="studentEntity.s_name"/>"/>
 	<input type="button" value="查询" onclick="cha()"/>
  	</form>
  <hr>
  <!--value="studentlist"表示查询声明的 list studentlist;   -->
    <s:iterator value="studentlist">
    	
    	<s:property value="s_name"/>
    	
    	<a href="<%=path%>/student!deleteStudentList?studentEntity.s_id=<s:property value="s_id"/>">删除</a>
    	<a href="<%=path%>/student!updateOneList?studentEntity.s_id=<s:property value="s_id"/>">修改</a> 
    	<br>  	
    </s:iterator>
    <br>
    	<input type="hidden" id="zong" value="<s:property value="#session.zong"/>">
    	<a href="javascript:fen(1)">首页</a>
     	<a href="javascript:fen(<s:property value="page-1"/>)">上一页</a>
      	<a href="javascript:fen(<s:property value="page+1"/>)">下一页</a>
      	<a href="javascript:fen(<s:property value="#session.zong"/>)">尾页</a>
</html>
