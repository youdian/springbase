package org.youdian.springbase.mapper;

import org.springframework.stereotype.Repository;
import org.youdian.springbase.model.User;

public interface UserMapper {

	public int insertUser(User user);
}
