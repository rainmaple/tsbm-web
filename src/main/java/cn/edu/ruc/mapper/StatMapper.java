package cn.edu.ruc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.ruc.view.LineMap;
import cn.edu.ruc.view.StatBar;

public interface StatMapper {
	List<StatBar> importBar(@Param("cfgIds")Integer[] cfgIds);
	List<LineMap> importLine(@Param("cfgIds")Integer[] cfgIds);
	List<StatBar> appendBar(@Param("cfgIds")Integer[] cfgIds,@Param("tmpId") Integer tmpId);
	List<LineMap> appendLine(@Param("cfgIds")Integer[] cfgIds,@Param("tmpId") Integer tmpId);
	List<StatBar> readBar(@Param("cfgIds")Integer[] cfgIds,@Param("tmpId") Integer tmpId);
	List<LineMap> readLine(@Param("cfgIds")Integer[] cfgIds,@Param("tmpId") Integer tmpId);
}
