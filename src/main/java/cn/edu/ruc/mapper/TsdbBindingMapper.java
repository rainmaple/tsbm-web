package cn.edu.ruc.mapper;

import java.util.List;

import cn.edu.ruc.entity.TsdbBinding;

public interface TsdbBindingMapper {
	void insertTsbinding(TsdbBinding tsdbBinding);

	List<Object> selectList();

	void deleteById(Long id);
	TsdbBinding selectById(Integer id);
	void updateById(TsdbBinding tsdbBinding);
}
