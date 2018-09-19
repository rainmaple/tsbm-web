package cn.edu.ruc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.edu.ruc.entity.ImportLog;

public interface ImportLogMapper {
    int insert(ImportLog record);

    int insertSelective(ImportLog record);
    double selectProgressByBatchId(@Param("batchId") int batchId);
}