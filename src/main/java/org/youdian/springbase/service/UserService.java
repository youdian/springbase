package org.youdian.springbase.service;

import java.util.List;

import org.youdian.springbase.model.User;

/**
 * 用户服务操作
 * @author zhouzhou
 *
 */
public interface UserService {
	/**
	 * 增加一个用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	/**
	 * 手机号注册用户
	 * @param user
	 * @return
	 */
	public int registerUserByPhone(User user);
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	public User selectUser(int id);
	/**
	 * 根据手机号查找用户
	 * @param phone
	 * @return
	 */
	public User selectUserByPhone(String phone);
	/**
	 * 根据openid查找用户
	 * @param openId
	 * @return
	 */
	public User selectUserByOpenId(String openId);
	public List<User> listUser();
	/**
	 * 根据用户名关键字查找用户
	 * @param name
	 * @return
	 */
	public List<User> searchUser(String name);
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUser(int id);
}
