package org.sc.service.myb.util.activemq.messageModel;

import lombok.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * 消息模型
 * 消息可以是任意数据类型
 */
@Getter
@Setter
@Builder
public class MessageModel implements Serializable {
    private String titile;// 主题
    private String centend;// 消息
    
    @Override
    public String toString() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "MessageModel{" +
                "titile='" + titile + '\'' +
                ", centend='" + centend + '\'' +
                ", date=" + format.format(new Date()) +
                '}';
    }
}