/**
 * @filename:Student 2018年10月28日
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
 * @Description:  学生
 * @Author:       lv   
 * @CreateDate:   2018年10月28日
 * @Version:      V1.0
 *    
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 1540738749490L;
	
	@ApiModelProperty(name = "id" , value = "id")
	private Integer id;
	@ApiModelProperty(name = "stuName" , value = "学生姓名")
	private String stuName;
	@ApiModelProperty(name = "age" , value = "学生年龄")
	private Integer age;
	@ApiModelProperty(name = "password" , value = "密码")
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private Date createTime;
	@ApiModelProperty(name = "isDelete" , value = "是否删除")
	private Integer isDelete;
}
