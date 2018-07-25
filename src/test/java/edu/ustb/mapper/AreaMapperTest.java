package edu.ustb.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ustb.BaseTest;
import edu.ustb.domain.Area;

public class AreaMapperTest extends BaseTest{
	@Autowired
	@Qualifier("AreaMapper")
	private AreaMapper areaMapper;
	@Test
	public void queryAreaTest(){
		List<Area> areaList = this.areaMapper.queryArea();
		for (Area area : areaList) {
			System.out.println(area.getAreaName());
		}
	}
}
