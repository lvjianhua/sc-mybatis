package org.sc.service.myb.entity;


import java.util.Date;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类
 * 
 * @author lv
 *
 */
@TableName("tb_student")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Student {

    @TableId(value="id",type=IdType.AUTO)
    private Integer id;

    @TableField("stu_name")
    private String stuName;

    @TableField("stu_number")
    private String stuNumber;

    private Integer gender;
    private Integer age;

    private String password;

    @TableField("stu_mobile")
    private String stuMobile;

/**
     * 家长姓名*/


    @TableField("par_name")
    private String parName;

    @TableField("par_mobile")
    private String parMobile;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableField("is_delete")
    private Integer isDelete;

    @TableField("role_id")
    private Integer roleId;



    // setter和getter方法省略


}
