package com.Licon.blog.website.utils;


import com.google.gson.Gson;

/**
 * json转换工具
    * @ClassName: GsonUtils  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月11日  
    *
 */
public class GsonUtils {

    private static final Gson gson = new Gson();

    public static String toJsonString(Object object){
      return object==null?null:gson.toJson(object);
    }
}
