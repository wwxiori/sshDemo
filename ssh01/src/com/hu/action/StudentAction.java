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
	private StudentService studentService;//ֻ������ʵ����
	private List studentlist;
	private StudentEntity studentEntity;
	private int page;//��ʾ��ǰҳ
	
	//��ѯ�б�
	public String getStudentList(){
		studentlist=studentService.getStudentList();
		return "studentList";
	}
	//����
	public String addStudentList(){
		studentService.getaddStudent(studentEntity);
		return "add";
	}
	//�޸�
	public String updateStudengList(){
		studentService.updateStudent(studentEntity);
		return "update";
	}
	//ɾ��
	public String deleteStudentList(){
		studentService.deleteStudent(studentEntity);
		return "delete";
	}
	//�޸ĵĵ�һ���ݲ�ѯ
	public String updateOneList(){
		studentEntity=studentService.getupdateList(studentEntity);
		return "updateOne";
	}
	//ģ����ѯ
	public String  mohu() throws UnsupportedEncodingException{
		String s_name=studentEntity.getS_name();
		s_name=new String(s_name.getBytes("iso8859-1"),"utf-8");
		studentEntity.setS_name(s_name);
		studentlist=studentService.getmohuList(studentEntity);
		return "mohu";
	}
	//��ҳ��ѯ
	public String fenye(){
		int sum=studentService.getStudentList().size();//�õ�����
		int zong=0;//��ҳ
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
	//ģ����ҳ
		public String MoFen() throws UnsupportedEncodingException{
			String s_name=studentEntity.getS_name();
			s_name=new String(s_name.getBytes("iso8859-1"),"utf-8");
			studentEntity.setS_name(s_name);
			//studentlist=studentService.getmohuList(studentEntity);
			int sum=studentService.getmohuList(studentEntity).size();//�õ�����
			int zong=0;//��ҳ
			if(sum%5==0){
				zong=sum/5;
			}else{
				zong=sum/5+1;
			}
			Map session=ActionContext.getContext().getSession();
			session.put("zong", zong);
			//ע�⣺��ȡ�ӿ�  ģ����ҳ�Ľӿ�  ʵ���� �ڽ��У���ҳ-1��*��ҳ����ҳ
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
