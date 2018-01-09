package cn.smbms.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User login(String userCode, String userPassword) {
		User user = null;
		user = userMapper.getLoginUser(userCode);
		if(null != user){
			if(!user.getUserPassword().equals(userPassword)){
				user = null;
			}
			
		}
		return user;
	}

}
