package com.app.service;

import java.util.List;

import com.app.pojos.Maid;

public interface IMaidService {

	public boolean register(Maid maid);
	public Maid login(Maid maid);
	public Maid getMaid(Integer id);
	public Maid getMaidByEmail(String email);
	//public List<Maid> getAllMaids(int currentPage, int numberOfRecords);
	public List<Maid> getAllMaids(Integer pageNo, Integer pageSize, String sortBy, String searchBy);
	public boolean updateMaid(Maid maid);
	public boolean deleteMaid(Maid maid);
	public int getNumberOfRows();
	public List<Maid> getAllMaidList();
}
