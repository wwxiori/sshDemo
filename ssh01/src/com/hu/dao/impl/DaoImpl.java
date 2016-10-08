package com.hu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import com.hu.dao.Dao;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	//查询列表
		public List getList(String hql) {
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}
		//新增
		public void add(Object object) {
			this.getHibernateTemplate().save(object);
		}
		//修改
		public void update(Object object) {
			this.getHibernateTemplate().update(object);	
		}
		//删除
		public void delete(Object object) {
			this.getHibernateTemplate().delete(object);		
		}
		//修改单一数据查询
		public Object updateOne(Class cls, String s_id) {
			Object object=this.getHibernateTemplate().get(cls, s_id);
			return object;
		}
		//分页
		public List getfenyeList(String hql, int x, int y) {
			SessionFactory sessionFactory=this.getSessionFactory();
			Session session=sessionFactory.openSession();
			List list=session.createQuery(hql).setFirstResult(x).setMaxResults(y).list();
			return list;
		}
		

	}