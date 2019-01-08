package com.Licon.blog.website.service;


import com.Licon.blog.website.dto.MetaDto;
import com.Licon.blog.website.modal.Bo.ArchiveBo;
import com.Licon.blog.website.modal.Bo.StatisticsBo;
import com.Licon.blog.website.modal.Vo.CommentVo;
import com.Licon.blog.website.modal.Vo.ContentVo;

import java.util.List;

  /**  站点业务
    * @ClassName: ISiteService  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月21日  
    *    
    */      
public interface ISiteService {


    /**
     * 最新收到的评论
     *
     * @param limit
     * @return
     */
    List<CommentVo> recentComments(int limit);

    /**
     * 最新发表的文章
     *
     * @param limit
     * @return
     */
    List<ContentVo> recentContents(int limit);

    /**
     * 查询一条评论
     * @param coid
     * @return
     */
    CommentVo getComment(Integer coid);




    /**
     * 获取后台统计数据
     *
     * @return
     */
    StatisticsBo getStatistics();

    /**
     * 查询文章归档
     *
     * @return
     */
    List<ArchiveBo> getArchives();

    /**
     * 获取分类/标签列表
     * @return
     */
    List<MetaDto> metas(String type, String orderBy, int limit);

}
