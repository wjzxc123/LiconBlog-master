package com.Licon.blog.website.controller;


import com.Licon.blog.website.exception.TipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * exception设置
    * @ClassName: GlobalExceptionHandler  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月25日  
    *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = TipException.class)
    public String tipException(Exception e) {
        LOGGER.error("find exception:e={}",e.getMessage());
        e.printStackTrace();
        return "comm/error_500";
    }


    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e){
        LOGGER.error("find exception:e={}",e.getMessage());
        e.printStackTrace();
        return "comm/error_404";
    }
}
