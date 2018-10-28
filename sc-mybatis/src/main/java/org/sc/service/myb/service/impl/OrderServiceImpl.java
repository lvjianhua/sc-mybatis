/**
 * @filename:OrderServiceImpl 2018年10月25日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sc.service.myb.util.AppPage;
import org.sc.service.myb.entity.Order;
import org.sc.service.myb.dao.OrderDao;
import org.sc.service.myb.service.OrderService;

/**   
 *  
 * @Description:  订单——SERVICEIMPL
 * @Author:       lv   
 * @CreateDate:   2018年10月25日
 * @Version:      V1.0
 *    
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	public OrderDao orderDao;
	
	//查询对象
	@Override
	public Order selectByPrimaryKey(Long id) {
		return orderDao.selectByPrimaryKey(id);
	}
	
	//删除对象
	@Override
	public int deleteByPrimaryKey(Long id) {
		return orderDao.deleteByPrimaryKey(id);
	}
	
	//添加对象
	@Override
	public int insertSelective(Order order) {
		return orderDao.insertSelective(order);
	}
	
	//修改对象
	@Override
	public int updateByPrimaryKeySelective(Order order) {
		return orderDao.updateByPrimaryKeySelective(order);
	}
	
	//查询集合
	@Override
	public List<Order> queryOrderList(Order order) {
		return orderDao.queryOrderList(order);
	}
	
	//分页查询
	@Override
	public PageInfo<Order> getOrderBySearch(AppPage<Order> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<Order> list=orderDao.queryOrderList(page.getParam());
		PageInfo<Order> pageInfo = new PageInfo<Order>(list);
		return pageInfo;
	}
}