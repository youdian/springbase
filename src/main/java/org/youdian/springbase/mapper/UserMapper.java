package org.youdian.springbase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.youdian.springbase.model.User;

/**
 * 用户相关的数据库操作
 * @author zhouzhou
 *
 */
@Repository
public interface UserMapper {

	public int insertUser(User user);
	public int registerUserByPhone(User user);
	public void updateUser(User user);
	public User selectUser(int uid);
	public User selectUserByPhone(String phone);
	public User selectUserByOpenId(String openId);
	public List<User> listUser();
	public List<User> searchUser(String name);
	public void deleteUser(int uid);
}
