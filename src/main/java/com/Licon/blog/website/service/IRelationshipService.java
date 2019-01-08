package com.Licon.blog.website.service;


import com.Licon.blog.website.modal.Vo.RelationshipVoKey;

import java.util.List;


  /**  内容与分类的关系
    * @ClassName: IRelationshipService  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月2日  
    *    
    */      
public interface IRelationshipService {
    /**
     * 按住键删除
     * @param cid
     * @param mid
     */
    void deleteById(Integer cid, Integer mid);

    /**
     * 按主键统计条数
     * @param cid
     * @param mid
     * @return 条数
     */
    Long countById(Integer cid, Integer mid);


    /**
     * 保存對象
     * @param relationshipVoKey
     */
    void insertVo(RelationshipVoKey relationshipVoKey);

    /**
     * 根据id搜索
     * @param cid
     * @param mid
     * @return
     */
    List<RelationshipVoKey> getRelationshipById(Integer cid, Integer mid);
}
