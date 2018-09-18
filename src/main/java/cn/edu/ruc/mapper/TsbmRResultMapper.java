package cn.edu.ruc.mapper;

import cn.edu.ruc.entity.TsbmRResult;

public interface TsbmRResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TsbmRResult record);

    int insertSelective(TsbmRResult record);

    TsbmRResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TsbmRResult record);

    int updateByPrimaryKey(TsbmRResult record);
}