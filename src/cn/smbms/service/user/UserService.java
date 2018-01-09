package cn.smbms.service.user;

import cn.smbms.pojo.User;
/**
 * 用户管理业务层
 * @author Administrator
 *
 */
public interface UserService {
	User login(String userCode,String userPassword);
	
}
