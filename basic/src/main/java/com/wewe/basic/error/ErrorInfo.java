package com.wewe.basic.error;

import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @Author: fei2
 * @Date:2018/6/7 19:29
 * @Description:
 * @Refer To:
 */
@Data
public class ErrorInfo<T> {
    
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    
    private Integer code;
    private String message;
    private String url;
    private T data;
}
