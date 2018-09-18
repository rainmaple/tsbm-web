package cn.edu.ruc.mapper;

import cn.edu.ruc.entity.TsbmWResult;

public interface TsbmWResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TsbmWResult record);

    int insertSelective(TsbmWResult record);

    TsbmWResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TsbmWResult record);

    int updateByPrimaryKey(TsbmWResult record);
}