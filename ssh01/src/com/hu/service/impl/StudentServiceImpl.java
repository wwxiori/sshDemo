package com.hu.service.impl;

import java.util.List;



import com.hu.dao.Dao;
import com.hu.entity.StudentEntity;
import com.hu.service.StudentService;

public class StudentServiceImpl  implements StudentService {
	private Dao dao;//ֻ���� ��ʵ����
	
	public List getStudentList() {
		String hql="from StudentEntity";
		List list=dao.getList(hql);
		return list;
	}
	//----------get/set---------------------------
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	//����
	public void getaddStudent(StudentEntity studentEntity ) {
		dao.add(studentEntity);
	}
	//�޸�
	public void updateStudent(StudentEntity studentEntity) {
		dao.update(studentEntity);		
	}
	//ɾ��
	public void deleteStudent(StudentEntity studentEntity) {
		dao.delete(studentEntity);		
	}
	//�޸ĵ�һ���ݲ�ѯ
	public StudentEntity getupdateList(StudentEntity studentEntity) {
		StudentEntity studentEntity2=(StudentEntity) dao.updateOne(StudentEntity.class, studentEntity.getS_id());
		return studentEntity2;
	}
	//��ҳ
	public List getfenteList(int x, int y) {
		String hql="from StudentEntity";
		List list=dao.getfenyeList(hql, x, y);
		return list;
	}
	//ģ����ѯ
	public List getmohuList(StudentEntity studentEntity) {
		String hql="from StudentEntity where s_name like'%"+studentEntity.getS_name()+"%'";
		List list=dao.getList(hql);
		return list;
	}
	//ģ����ҳ
	public List getMOFenList(StudentEntity studentEntity, int x,int y) {
		String hql="from StudentEntity where s_name like'%"+studentEntity.getS_name()+"%'";
		List list=dao.getfenyeList(hql, x, y);
		return list;
	}
	

	
	
	
}
