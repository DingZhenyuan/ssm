package edu.ustb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ustb.domain.Area;
import edu.ustb.domain.LocalAuth;
import edu.ustb.exception.LoginException;
import edu.ustb.mapper.AreaMapper;
import edu.ustb.mapper.LocalAuthMapper;
import edu.ustb.service.AreaService;
import edu.ustb.service.LocalAuthService;
import edu.ustb.util.MD5Util;

@Service("LocalAuthServiceImpl")
public class LocalAuthServiceImpl implements LocalAuthService {
	@Autowired
	@Qualifier("LocalAuthMapper")
	private LocalAuthMapper localAuthMapper;
	
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public LocalAuth isLogin(String username, String password)
			throws LoginException {
		LocalAuth auth = this.localAuthMapper.findByUserName(username);
		if(auth==null){
			throw new LoginException("用户名不存在！");
		}
		if(MD5Util.getMd5(password).equals(auth.getPassword())){
			return auth;
		}else{
			throw new LoginException("密码错误！");
		}
	}
}
