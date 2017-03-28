package com.ll.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ll.user.dao.UserDao;
import com.ll.user.entity.User;
import com.ll.user.service.DemoService;

public class DemoServiceImpl implements DemoService {
	@Autowired
	private UserDao<User> dao;

	public boolean doUserLogin(User user) {
		/*
		 * if ("1".equals(user.getPassword())) { return true; } else { return
		 * false; }
		 */
		System.out.println("doUserLogin-in");
		List<User> list = dao.selectId(user.getUsername());
		if (list.size() == 0) {
			return false;
		} else {
			if (list.get(0).getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
