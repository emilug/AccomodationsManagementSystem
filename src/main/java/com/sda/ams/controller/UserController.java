package com.sda.ams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sda.ams.model.Client;
import com.sda.ams.model.User;
import com.sda.ams.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String getAll(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("user", users);
		return "user/list";
	}

	@GetMapping("/show/{userId}")
	public String getById(Model model, @PathVariable Integer userId) {
		Optional<User> userOptional = userService.get(userId);
		if (userOptional.isPresent()) {
			model.addAttribute("user", userOptional.get());
			return "user/show";
		} else {
			return "exceptions/404";
		}
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("user", new User());
		return "user/create";
	}

	@GetMapping("/edit/{userId}")
	public String edit(Model model, @PathVariable Integer userId) {
		Optional<User> userOptional = userService.get(userId);
		if (userOptional.isPresent()) {
			model.addAttribute("user", userOptional.get());
			return "user/edit";
		} else {
			return "exceptions/404";
		}
	}

	@PostMapping("/save")
	public String save(@ModelAttribute User user, Model model) {
		user = userService.save(user);
		model.addAttribute("user", user);
		return "user/show";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute User user, Model model) {
		user = userService.save(user);
		model.addAttribute("user", user);
		return "user/show";
	}

	@DeleteMapping("/delete/{userId}")
	public String delete(@PathVariable Integer userId) {
		userService.delete(userId);
		return "redirect:/user/list";
	}
}
