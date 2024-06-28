package io.indpro.usermanagementsystem.services;

import io.indpro.usermanagementsystem.entities.User;

public interface UserServices {
	public User addUser(User user);

	public User updateUser(Long id, User user);

	public User getUserById(Long id);
}
