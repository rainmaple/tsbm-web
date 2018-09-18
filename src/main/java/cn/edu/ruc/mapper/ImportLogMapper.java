package cn.edu.ruc.mapper;

import cn.edu.ruc.entity.ImportLog;

public interface ImportLogMapper {
    int insert(ImportLog record);

    int insertSelective(ImportLog record);
}