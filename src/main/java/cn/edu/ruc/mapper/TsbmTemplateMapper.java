package cn.edu.ruc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.ruc.entity.TsbmTemplate;

public interface TsbmTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsbmTemplate record);

    int insertSelective(TsbmTemplate record);

    TsbmTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsbmTemplate record);

    int updateByPrimaryKey(TsbmTemplate record);

	List<Object> selectList();
	List<TsbmTemplate> selectListByIds(@Param("tmpIds")Integer[] tmpIds);
}