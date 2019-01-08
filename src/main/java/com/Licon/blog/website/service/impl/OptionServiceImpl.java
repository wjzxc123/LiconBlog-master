package com.Licon.blog.website.service.impl;


import com.Licon.blog.website.dao.OptionVoMapper;
import com.Licon.blog.website.modal.Vo.OptionVo;
import com.Licon.blog.website.modal.Vo.OptionVoExample;
import com.Licon.blog.website.service.IOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class OptionServiceImpl implements IOptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionServiceImpl.class);

    @Autowired
    private OptionVoMapper optionDao;

    @Override
    public void insertOption(OptionVo optionVo) {
        LOGGER.debug("Enter insertOption method:optionVo={}" ,optionVo);
        optionDao.insertSelective(optionVo);
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    public void insertOption(String name, String value) {
        LOGGER.debug("Enter insertOption method:name={},value={}",name,value );
        OptionVo optionVo = new OptionVo();
        optionVo.setName(name);
        optionVo.setValue(value);
        if(optionDao.selectByExample(new OptionVoExample()).size()==0){
            optionDao.insertSelective(optionVo);
        }else{
            optionDao.updateByPrimaryKeySelective(optionVo);
        }
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach(this::insertOption);
        }
    }

    @Override
    public List<OptionVo> getOptions(){
        return optionDao.selectByExample(new OptionVoExample());
    }
}
