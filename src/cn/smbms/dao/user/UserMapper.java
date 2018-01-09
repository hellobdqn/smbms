package cn.smbms.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;
/**
 * 用户管理映射接口
 * @author Administrator
 *
 */
public interface UserMapper {
	/**
	 * 根据用户编码查找用户信息
	 * @param userCode
	 * @return
	 */
	User getLoginUser(@Param("userCode") String userCode);

}
