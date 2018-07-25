package edu.ustb.service;

import edu.ustb.domain.LocalAuth;
import edu.ustb.exception.LoginException;

public interface LocalAuthService {
	public LocalAuth isLogin(String username,String password) throws LoginException;
}
