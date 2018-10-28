/**
 * @filename:OrderController 2018年10月25日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import org.sc.service.myb.util.AppPage;
import org.sc.service.myb.util.JsonResult;
import org.sc.service.myb.entity.Order;
import org.sc.service.myb.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
 * 
 * @Description:  订单接口层
 * @Author:       lv   
 * @CreateDate:   2018年10月25日
 * @Version:      V1.0
 *    
 */
@Api(description = "订单",value="订单" )
@RestController
@RequestMapping("/order")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public OrderService orderServiceImpl;
	
	/**
	 * @explain 查询订单对象  <swagger GET请求>
	 * @param   对象参数：id
	 * @return  order
	 * @author  lv
	 * @time    2018年10月25日
	 */
	@GetMapping("/getOrderById/{id}")
	@ApiOperation(value = "获取订单信息", notes = "获取订单信息[order]，作者：lv")
	@ApiImplicitParam(paramType="path", name = "id", value = "订单id", required = true, dataType = "Long")
	public JsonResult<Order> getOrderById(@PathVariable("id")Long id){
		JsonResult<Order> result=new JsonResult<Order>();
		try {
			Order order=orderServiceImpl.selectByPrimaryKey(id);
			if (order!=null) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(order);
			} else {
				logger.error("获取订单失败ID："+id);
				result.setCode(-1);
				result.setMessage("你获取的订单不存在");
			}
		} catch (Exception e) {
			logger.error("获取订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 添加订单对象
	 * @param   对象参数：order
	 * @return  int
	 * @author  lv
	 * @time    2018年10月25日
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加订单", notes = "添加订单[order],作者：lv")
	public JsonResult<Order> insertSelective(Order order){
		JsonResult<Order> result=new JsonResult<Order>();
		try {
			int rg=orderServiceImpl.insertSelective(order);
			if (rg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(order);
			} else {
				logger.error("添加订单执行失败："+order.toString());
				result.setCode(-1);
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 删除订单对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  lv
	 * @time    2018年10月25日
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除订单", notes = "删除订单,作者：lv")
	@ApiImplicitParam(paramType="query", name = "id", value = "订单id", required = true, dataType = "Long")
	public JsonResult<Object> deleteByPrimaryKey(Long id){
		JsonResult<Object> result=new JsonResult<Object>();
		try {
			int reg=orderServiceImpl.deleteByPrimaryKey(id);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除订单失败ID："+id);
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 修改订单对象
	 * @param   对象参数：order
	 * @return  order
	 * @author  lv
	 * @time    2018年10月25日
	 */
	@ApiOperation(value = "修改订单", notes = "修改订单[order],作者：lv")
	@PostMapping("/updateByPrimaryKeySelective")
	public JsonResult<Order> updateByPrimaryKeySelective(Order order){
		JsonResult<Order> result=new JsonResult<Order>();
		try {
			int reg = orderServiceImpl.updateByPrimaryKeySelective(order);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(order);
			} else {
				logger.error("修改订单失败ID："+order.toString());
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("修改订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 获取匹配订单
	 * @param   对象参数：order
	 * @return  List<Order>
	 * @author  lv
	 * @time    2018年10月25日
	 */
	@ApiOperation(value = "条件查询订单", notes = "条件查询[order],作者：lv")
	@PostMapping("/queryOrderList")
	public JsonResult<List<Order>> queryOrderList(Order order){
		JsonResult<List<Order>> result=new JsonResult<List<Order>>();
		try {
			List<Order> list = orderServiceImpl.queryOrderList(order);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(list);
		} catch (Exception e) {
			logger.error("获取订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询订单   
	 * @param   对象参数：AppPage<Order>
	 * @return  PageInfo<Order>
	 * @author  lv
	 * @time    2018年10月25日
	 */
	@GetMapping("/getPageOrder")
	@ApiOperation(value = "分页查询", notes = "分页查询返回对象[PageInfo<Order>],作者：边鹏")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
	public JsonResult<PageInfo<Order>> getOrderBySearch(Integer pageNum,Integer pageSize){
		JsonResult<PageInfo<Order>> result=new JsonResult<PageInfo<Order>>();
		AppPage<Order> page =new AppPage<Order>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		//其他参数
		Order order=new Order();
		page.setParam(order);
		//分页数据
		try {
			PageInfo<Order> pageInfo = orderServiceImpl.getOrderBySearch(page);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询订单执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
}