package cn.edu.ruc.mapper;

import java.util.List;

import cn.edu.ruc.entity.TsbmTemplate;

public interface TsbmTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsbmTemplate record);

    int insertSelective(TsbmTemplate record);

    TsbmTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsbmTemplate record);

    int updateByPrimaryKey(TsbmTemplate record);

	List<Object> selectList();
}