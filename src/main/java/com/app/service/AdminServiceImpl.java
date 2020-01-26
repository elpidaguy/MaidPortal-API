package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminDao adminDao;

	@Override
	public Admin login(String email, String password) {

		Admin admin = adminDao.loginAdmin(email, password);
		if (admin != null) {
			return admin;
		}
		return null;
	}

}
