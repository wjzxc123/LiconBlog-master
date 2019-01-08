package com.Licon.blog.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.Licon.blog.website.dao.AttachVoMapper;
import com.Licon.blog.website.dto.MetaDto;
import com.Licon.blog.website.modal.Bo.ArchiveBo;
import com.Licon.blog.website.modal.Vo.*;
import com.Licon.blog.website.service.ISiteService;
import com.Licon.blog.website.utils.DateKit;
import com.Licon.blog.website.constant.WebConst;
import com.Licon.blog.website.dao.CommentVoMapper;
import com.Licon.blog.website.dao.ContentVoMapper;
import com.Licon.blog.website.dao.MetaVoMapper;
import com.Licon.blog.website.dto.Types;
import com.Licon.blog.website.modal.Bo.StatisticsBo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 *  站点业务
    * @ClassName: SiteServiceImpl  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月26日  
    *
 */
@Service
public class SiteServiceImpl implements ISiteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Resource
    private CommentVoMapper commentDao;

    @Resource
    private ContentVoMapper contentDao;

    @Resource
    private AttachVoMapper attachDao;

    @Resource
    private MetaVoMapper metaDao;

    @Override
    public List<CommentVo> recentComments(int limit) {
        LOGGER.debug("Enter recentComments method:limit={}", limit);
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        CommentVoExample example = new CommentVoExample();
        example.setOrderByClause("created desc");
        PageHelper.startPage(1, limit);
        List<CommentVo> byPage = commentDao.selectByExampleWithBLOBs(example);
        LOGGER.debug("Exit recentComments method");
        return byPage;
    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        LOGGER.debug("Enter recentContents method");
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        ContentVoExample example = new ContentVoExample();
        example.createCriteria().andStatusEqualTo(Types.PUBLISH.getType()).andTypeEqualTo(Types.ARTICLE.getType());
        example.setOrderByClause("created desc");
        PageHelper.startPage(1, limit);
        List<ContentVo> list = contentDao.selectByExample(example);
        LOGGER.debug("Exit recentContents method");
        return list;
    }


    @Override
    public CommentVo getComment(Integer coid) {
        if (null != coid) {
            return commentDao.selectByPrimaryKey(coid);
        }
        return null;
    }

    @Override
    public StatisticsBo getStatistics() {
        LOGGER.debug("Enter getStatistics method");
        StatisticsBo statistics = new StatisticsBo();

        ContentVoExample contentVoExample = new ContentVoExample();
        contentVoExample.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH.getType());
        Long articles =   contentDao.countByExample(contentVoExample);

        Long comments = commentDao.countByExample(new CommentVoExample());

        Long attachs = attachDao.countByExample(new AttachVoExample());

        MetaVoExample metaVoExample = new MetaVoExample();
        metaVoExample.createCriteria().andTypeEqualTo(Types.LINK.getType());
        Long links = metaDao.countByExample(metaVoExample);

        statistics.setArticles(articles);
        statistics.setComments(comments);
        statistics.setAttachs(attachs);
        statistics.setLinks(links);
        LOGGER.debug("Exit getStatistics method");
        return statistics;
    }

    @Override
    public List<ArchiveBo> getArchives() {
        LOGGER.debug("Enter getArchives method");
        List<ArchiveBo> archives = contentDao.findReturnArchiveBo();
        if (null != archives) {
            archives.forEach(archive -> {
                ContentVoExample example = new ContentVoExample();
                ContentVoExample.Criteria criteria = example.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH.getType());
                example.setOrderByClause("created desc");
                String date = archive.getDate();
                Date sd = DateKit.dateFormat(date, "yyyy年MM月");
                int start = DateKit.getUnixTimeByDate(sd);
                int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1)) - 1;
                criteria.andCreatedGreaterThan(start);
                criteria.andCreatedLessThan(end);
                List<ContentVo> contentss = contentDao.selectByExample(example);
                archive.setArticles(contentss);
            });
        }
        LOGGER.debug("Exit getArchives method");
        return archives;
    }

    @Override
    public List<MetaDto> metas(String type, String orderBy, int limit){
        LOGGER.debug("Enter metas method:type={},order={},limit={}", type, orderBy, limit);
        List<MetaDto> retList=null;
        if (StringUtils.isNotBlank(type)) {
            if(StringUtils.isBlank(orderBy)){
                orderBy = "count desc, a.mid desc";
            }
            if(limit < 1 || limit > WebConst.MAX_POSTS){
                limit = 10;
            }
            Map<String, Object> paraMap = new HashMap<>();
            paraMap.put("type", type);
            paraMap.put("order", orderBy);
            paraMap.put("limit", limit);
            retList= metaDao.selectFromSql(paraMap);
        }
        LOGGER.debug("Exit metas method");
        return retList;
    }


    private void write(String data, File file, Charset charset) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(data.getBytes(charset));
        } catch (IOException var8) {
            throw new IllegalStateException(var8);
        } finally {
            if(null != os) {
                try {
                    os.close();
                } catch (IOException var2) {
                    var2.printStackTrace();
                }
            }
        }

    }

}
