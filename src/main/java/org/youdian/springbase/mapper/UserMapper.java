package org.youdian.springbase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.youdian.springbase.model.User;

@Repository
public interface UserMapper {

	public int insertUser(User user);
	
	public void updateUser(User user);
	public User selectUser(int id);
	public List<User> listUser();
	public void deleteUser(User user);
}
