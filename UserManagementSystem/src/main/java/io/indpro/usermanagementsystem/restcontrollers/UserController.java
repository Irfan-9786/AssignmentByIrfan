package io.indpro.usermanagementsystem.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.indpro.usermanagementsystem.entities.User;
import io.indpro.usermanagementsystem.services.UserServices;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServices userServices;
	@PostMapping("/")
	public User creatUser(@RequestBody User user) {
		return userServices.addUser(user);
	}
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") Long id,@RequestBody User user) {
		return userServices.updateUser(id, user);
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userServices.getUserById(id);
	}
}
