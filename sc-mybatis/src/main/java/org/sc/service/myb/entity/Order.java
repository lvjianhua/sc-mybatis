/**
 * @filename:Order 2018年10月25日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**   
 *  
 * @Description:  订单
 * @Author:       lv   
 * @CreateDate:   2018年10月25日
 * @Version:      V1.0
 *    
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1540737502921L;
	
	@ApiModelProperty(name = "id" , value = "id")
	private Long id;
	@ApiModelProperty(name = "orderNo" , value = "订单编号")
	private String orderNo;
	@ApiModelProperty(name = "uid" , value = "用户ID")
	private Long uid;
	@ApiModelProperty(name = "source" , value = "来源")
	private String source;
	@ApiModelProperty(name = "productId" , value = "产品ID")
	private Long productId;
	@ApiModelProperty(name = "productName" , value = "产品名字")
	private String productName;
	@ApiModelProperty(name = "unitPrice" , value = "单价")
	private Integer unitPrice;
	@ApiModelProperty(name = "number" , value = "数量")
	private Integer number;
	@ApiModelProperty(name = "sellingPrice" , value = "卖价")
	private Integer sellingPrice;
}
