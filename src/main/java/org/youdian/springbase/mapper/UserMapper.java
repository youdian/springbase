package org.youdian.springbase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.youdian.springbase.model.User;

@Repository
public interface UserMapper {

	public int insertUser(User user);
	
	public void updateUser(User user);
	public User selectUser(int uid);
	public List<User> listUser();
	public List<User> searchUser(String name);
	public void deleteUser(int uid);
}
