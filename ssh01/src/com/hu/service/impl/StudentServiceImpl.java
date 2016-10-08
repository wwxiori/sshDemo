package com.hu.service.impl;

import java.util.List;



import com.hu.dao.Dao;
import com.hu.entity.StudentEntity;
import com.hu.service.StudentService;

public class StudentServiceImpl  implements StudentService {
	private Dao dao;//只声明 不实例化
	
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
	//新增
	public void getaddStudent(StudentEntity studentEntity ) {
		dao.add(studentEntity);
	}
	//修改
	public void updateStudent(StudentEntity studentEntity) {
		dao.update(studentEntity);		
	}
	//删除
	public void deleteStudent(StudentEntity studentEntity) {
		dao.delete(studentEntity);		
	}
	//修改单一数据查询
	public StudentEntity getupdateList(StudentEntity studentEntity) {
		StudentEntity studentEntity2=(StudentEntity) dao.updateOne(StudentEntity.class, studentEntity.getS_id());
		return studentEntity2;
	}
	//分页
	public List getfenteList(int x, int y) {
		String hql="from StudentEntity";
		List list=dao.getfenyeList(hql, x, y);
		return list;
	}
	//模糊查询
	public List getmohuList(StudentEntity studentEntity) {
		String hql="from StudentEntity where s_name like'%"+studentEntity.getS_name()+"%'";
		List list=dao.getList(hql);
		return list;
	}
	//模糊分页
	public List getMOFenList(StudentEntity studentEntity, int x,int y) {
		String hql="from StudentEntity where s_name like'%"+studentEntity.getS_name()+"%'";
		List list=dao.getfenyeList(hql, x, y);
		return list;
	}
	

	
	
	
}
