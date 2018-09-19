package cn.edu.ruc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.ruc.entity.TsbmBatch;

public interface TsbmBatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TsbmBatch record);

    int insertSelective(TsbmBatch record);

    TsbmBatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TsbmBatch record);

    int updateByPrimaryKey(TsbmBatch record);

	List<TsbmBatch> selectList();
	void updateTeststatucByCfgIdAndTmpId(@Param("testStatus")int status,@Param("cfgId")int cfgId,@Param("tmpId")String tmpId);
}