package org.sc.service.myb.util;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> implements Serializable{
	
	private static final long serialVersionUID = 123126L;
	
	private Integer code;
	
	private String message;
	
	private Object data;
}
