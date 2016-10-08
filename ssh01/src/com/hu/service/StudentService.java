package com.hu.service;

import java.util.List;

import com.hu.entity.StudentEntity;

public interface StudentService {
	//查询列表
	public List getStudentList();
	//新增
	public void getaddStudent(StudentEntity studentEntity);
	//修改
	public void updateStudent(StudentEntity studentEntity);
	//删除
	public void deleteStudent(StudentEntity studentEntity);
	//修改单一数据查询
	public StudentEntity getupdateList(StudentEntity studentEntity);
	//分页
	public List getfenteList(int x, int y);
	//模糊查询
	public List getmohuList(StudentEntity studentEntity);
	//模糊分页
	public List getMOFenList(StudentEntity studentEntity, int x,int y);
}
