package com.hu.service;

import java.util.List;

import com.hu.entity.StudentEntity;

public interface StudentService {
	//��ѯ�б�
	public List getStudentList();
	//����
	public void getaddStudent(StudentEntity studentEntity);
	//�޸�
	public void updateStudent(StudentEntity studentEntity);
	//ɾ��
	public void deleteStudent(StudentEntity studentEntity);
	//�޸ĵ�һ���ݲ�ѯ
	public StudentEntity getupdateList(StudentEntity studentEntity);
	//��ҳ
	public List getfenteList(int x, int y);
	//ģ����ѯ
	public List getmohuList(StudentEntity studentEntity);
	//ģ����ҳ
	public List getMOFenList(StudentEntity studentEntity, int x,int y);
}
