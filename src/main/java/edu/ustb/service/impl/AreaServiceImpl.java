package edu.ustb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ustb.domain.Area;
import edu.ustb.mapper.AreaMapper;
import edu.ustb.service.AreaService;

@Service("AreaServiceImpl")
public class AreaServiceImpl implements AreaService {
	@Autowired@Qualifier("AreaMapper")
	private AreaMapper areaMapper;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Area> queryArea() {
		return areaMapper.queryArea();
	}
}
