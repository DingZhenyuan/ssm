package edu.ustb.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ustb.BaseTest;
import edu.ustb.domain.Area;
import edu.ustb.domain.LocalAuth;

public class LocalAuthMapperTest extends BaseTest {
	@Autowired
	@Qualifier("LocalAuthMapper")
	private LocalAuthMapper localAuthMapper;

	@Test
	public void queryAreaTest() {
		LocalAuth auth = this.localAuthMapper.findByUserName("test");
		System.out.println(auth);
	}
}
