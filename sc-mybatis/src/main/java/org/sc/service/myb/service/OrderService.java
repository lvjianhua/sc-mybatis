/**
 * @filename:OrderService 2018年10月25日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.service;

import java.util.List;



import org.sc.service.myb.util.AppPage;
import org.sc.service.myb.entity.Order;

import com.github.pagehelper.PageInfo;
/**   
 *  
 * @Description:  订单——SERVICE
 * @Author:       lv   
 * @CreateDate:   2018年10月25日
 * @Version:      V1.0
 *    
 */
public interface OrderService {
	
	/**
	 * @explain 查询订单对象
	 * @param   对象参数：id
	 * @return  Order
	 * @author  lv
	 */
	public Order selectByPrimaryKey(Long id);
	
	/**
	 * @explain 删除订单对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  lv
	 */
	public int deleteByPrimaryKey(Long id);
	
	/**
	 * @explain 添加订单对象
	 * @param   对象参数：Order
	 * @return  int
	 * @author  lv
	 */
	public int insertSelective(Order order);
	
	/**
	 * @explain 修改订单对象
	 * @param   对象参数：Order
	 * @return  int
	 * @author  lv
	 */
	public int updateByPrimaryKeySelective(Order order);
	
	/**
	 * @explain 查询订单集合
	 * @param   对象参数：Order
	 * @return  List<Order>
	 * @author  lv
	 */
	public List<Order> queryOrderList(Order order);
	
	/**
	 * @explain 分页查询订单
	 * @param   对象参数：Order
	 * @return  PageInfo<Order>
	 * @author  lv
	 */
	public PageInfo<Order> getOrderBySearch(AppPage<Order> page);
}