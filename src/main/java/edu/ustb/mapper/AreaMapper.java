package edu.ustb.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ustb.domain.Area;
@Repository("AreaMapper")
public interface AreaMapper {
	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	List<Area> queryArea();
}
