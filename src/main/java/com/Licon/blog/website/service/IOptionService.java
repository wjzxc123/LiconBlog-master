package com.Licon.blog.website.service;


import com.Licon.blog.website.modal.Vo.OptionVo;

import java.util.List;
import java.util.Map;

  /**  配置选项模块
    * @ClassName: IOptionService  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月21日  
    *    
    */      
public interface IOptionService {

    void insertOption(OptionVo optionVo);

    void insertOption(String name, String value);

    List<OptionVo> getOptions();


    /**
     * 保存一组配置
     *
     * @param options
     */
    void saveOptions(Map<String, String> options);
}
