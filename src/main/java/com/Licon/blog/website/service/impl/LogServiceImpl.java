package com.Licon.blog.website.service.impl;


import com.github.pagehelper.PageHelper;
import com.Licon.blog.website.dao.LogVoMapper;
import com.Licon.blog.website.service.ILogService;
import com.Licon.blog.website.utils.DateKit;
import com.Licon.blog.website.constant.WebConst;
import com.Licon.blog.website.modal.Vo.LogVo;
import com.Licon.blog.website.modal.Vo.LogVoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogVoMapper logDao;

    @Override
    public void insertLog(LogVo logVo) {
        logDao.insert(logVo);
    }

    @Override
    public void insertLog(String action, String data, String ip, Integer authorId) {
        LogVo logs = new LogVo();
        logs.setAction(action);
        logs.setData(data);
        logs.setIp(ip);
        logs.setAuthorId(authorId);
        logs.setCreated(DateKit.getCurrentUnixTime());
        logDao.insert(logs);
    }

    @Override
    public List<LogVo> getLogs(int page, int limit) {
        LOGGER.debug("Enter getLogs method:page={},linit={}",page,limit);
        if (page <= 0) {
            page = 1;
        }
        if (limit < 1 || limit > WebConst.MAX_POSTS) {
            limit = 10;
        }
        LogVoExample logVoExample = new LogVoExample();
        logVoExample.setOrderByClause("id desc");
        PageHelper.startPage((page - 1) * limit, limit);
        List<LogVo> logVos = logDao.selectByExample(logVoExample);
        LOGGER.debug("Exit getLogs method");
        return logVos;
    }
}
