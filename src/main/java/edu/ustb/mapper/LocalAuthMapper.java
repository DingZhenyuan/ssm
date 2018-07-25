package edu.ustb.mapper;

import org.springframework.stereotype.Repository;

import edu.ustb.domain.LocalAuth;

@Repository("LocalAuthMapper")
public interface LocalAuthMapper {
	/**
	 * 按用户名查询登录账号对象
	 * @param userName 用户名
	 * @return 本地登录账号对象
	 */
	public LocalAuth findByUserName(String userName);
}
