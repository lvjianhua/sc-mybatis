/**
 * @filename:OrderDao 2018年10月25日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.sc.service.myb.entity.Order;

/**   
 *  
 * @Description:  订单——DAO
 * @Author:       lv   
 * @CreateDate:   2018年10月25日
 * @Version:      V1.0
 *    
 */
@Mapper
public interface OrderDao {
	
	public Order selectByPrimaryKey(Long id);
	
	public int deleteByPrimaryKey(Long id);
	
	public int insertSelective(Order order);
	
	public int updateByPrimaryKeySelective(Order order);
	
	public List<Order> queryOrderList(Order order);
}
