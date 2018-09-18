package cn.edu.ruc.mapper;

import java.util.List;

import cn.edu.ruc.entity.TsdbCfg;

public interface TsdbCfgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsdbCfg record);

    int insertSelective(TsdbCfg record);

    TsdbCfg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsdbCfg record);

    int updateByPrimaryKey(TsdbCfg record);

	List<Object> selectList();
}