package com.Licon.blog.website.dao;


import com.Licon.blog.website.dto.MetaDto;
import com.Licon.blog.website.modal.Vo.MetaVo;
import com.Licon.blog.website.modal.Vo.MetaVoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MetaVoMapper {
    long countByExample(MetaVoExample example);

    int deleteByExample(MetaVoExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(MetaVo record);

    int insertSelective(MetaVo record);

    List<MetaVo> selectByExample(MetaVoExample example);

    MetaVo selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") MetaVo record, @Param("example") MetaVoExample example);

    int updateByExample(@Param("record") MetaVo record, @Param("example") MetaVoExample example);

    int updateByPrimaryKeySelective(MetaVo record);

    int updateByPrimaryKey(MetaVo record);

    List<MetaDto> selectFromSql(Map<String,Object> paraMap);

    MetaDto selectDtoByNameAndType(@Param("name") String name,@Param("type") String type);

    Integer countWithSql(Integer mid);
}