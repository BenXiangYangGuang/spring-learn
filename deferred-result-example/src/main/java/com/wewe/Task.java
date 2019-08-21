package com.wewe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author zhangpanwei@motie.com
 * @create 2019-08-21 13:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task<T> {
    /**
     * 延时返回对象
     */
    private DeferredResult<String> result;
    /**
     *  task message
     */

    private T message;
    /**
     * 是否超时
     */
    private Boolean timeOut;

}
