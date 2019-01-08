package com.Licon.blog.website.service;


import com.Licon.blog.website.modal.Vo.UserVo;


  /**  用户模块
    * @ClassName: IUserService  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月21日  
    *    
    */      
public interface IUserService {

    /**
     * 保存用户数据
     *
     * @param userVo 用户数据
     * @return 主键
     */

    Integer insertUser(UserVo userVo);

    /**
     * 通过uid查找对象
     * @param uid
     * @return
     */
    UserVo queryUserById(Integer uid);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
    UserVo login(String username, String password);

    /**
     * 根据主键更新user对象
     * @param userVo
     * @return
     */
    void updateByUid(UserVo userVo);
}