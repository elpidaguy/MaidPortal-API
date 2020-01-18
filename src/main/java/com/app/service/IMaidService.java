package com.app.service;

import java.util.List;

import com.app.pojos.Maid;

public interface IMaidService {

	public boolean Register(Maid maid);
	public Maid Login(Maid maid);
	public Maid getMaid(Integer id);
	public Maid getMaidByEmail(String email);
	public List<Maid> getAllMaids();
	public boolean updateMaid(Maid maid);
	public boolean deleteMaid(Maid maid);
	
}
