package com.hu.dao;

import java.util.List;

public interface Dao {
	//查询
	public List getList(String hql);
	//新增
	public void add(Object object);
	//修改
	public void update(Object object);
	//新增单一数据查询
	public Object updateOne(Class cls,String s_id);
	//删除
	public void delete(Object object);
	//分页
	public List getfenyeList(String hql,int x,int y);
}
