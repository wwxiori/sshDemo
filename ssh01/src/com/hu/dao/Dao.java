package com.hu.dao;

import java.util.List;

public interface Dao {
	//��ѯ
	public List getList(String hql);
	//����
	public void add(Object object);
	//�޸�
	public void update(Object object);
	//������һ���ݲ�ѯ
	public Object updateOne(Class cls,String s_id);
	//ɾ��
	public void delete(Object object);
	//��ҳ
	public List getfenyeList(String hql,int x,int y);
}
