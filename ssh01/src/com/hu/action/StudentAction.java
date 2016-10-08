package com.hu.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.hu.entity.StudentEntity;
import com.hu.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentService studentService;//只声明不实例化
	private List studentlist;
	private StudentEntity studentEntity;
	private int page;//表示当前页
	
	//查询列表
	public String getStudentList(){
		studentlist=studentService.getStudentList();
		return "studentList";
	}
	//新增
	public String addStudentList(){
		studentService.getaddStudent(studentEntity);
		return "add";
	}
	//修改
	public String updateStudengList(){
		studentService.updateStudent(studentEntity);
		return "update";
	}
	//删除
	public String deleteStudentList(){
		studentService.deleteStudent(studentEntity);
		return "delete";
	}
	//修改的单一数据查询
	public String updateOneList(){
		studentEntity=studentService.getupdateList(studentEntity);
		return "updateOne";
	}
	//模糊查询
	public String  mohu() throws UnsupportedEncodingException{
		String s_name=studentEntity.getS_name();
		s_name=new String(s_name.getBytes("iso8859-1"),"utf-8");
		studentEntity.setS_name(s_name);
		studentlist=studentService.getmohuList(studentEntity);
		return "mohu";
	}
	//分页查询
	public String fenye(){
		int sum=studentService.getStudentList().size();//得到总数
		int zong=0;//总页
		if(sum%5==0){
			zong=sum/5;
		}else{
			zong=sum/5+1;
		}
		Map session=ActionContext.getContext().getSession();
		session.put("zong", zong);
		studentlist=studentService.getfenteList((page-1)*5, 5);
		
		return "mohu";
	}
	//模糊分页
		public String MoFen() throws UnsupportedEncodingException{
			String s_name=studentEntity.getS_name();
			s_name=new String(s_name.getBytes("iso8859-1"),"utf-8");
			studentEntity.setS_name(s_name);
			//studentlist=studentService.getmohuList(studentEntity);
			int sum=studentService.getmohuList(studentEntity).size();//得到总数
			int zong=0;//总页
			if(sum%5==0){
				zong=sum/5;
			}else{
				zong=sum/5+1;
			}
			Map session=ActionContext.getContext().getSession();
			session.put("zong", zong);
			//注意：调取接口  模糊分页的接口  实体类 在进行（总页-1）*分页，分页
			studentlist=studentService.getMOFenList(studentEntity,(page-1)*5, 5);
					
			
			return "mohu";
			
		}
	
	
	//----------------get/set------------------------------
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}



	public List getStudentlist() {
		return studentlist;
	}



	public void setStudentlist(List studentlist) {
		this.studentlist = studentlist;
	}
	public StudentEntity getStudentEntity() {
		return studentEntity;
	}
	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	

	
	
	
}
