package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.dao.IMaidDao;
import com.app.pojos.Maid;

@Service
public class MaidServiceImpl implements IMaidService {

	@Autowired
	IMaidDao maidDao;

	@Override
	public boolean Register(Maid maid) {

		Optional<Maid> optional = maidDao.findById(maid.getId());
		if (optional.isPresent()) {
			return false;
		}
		maidDao.save(maid);
		return true;
	}

	@Override
	public Maid Login(Maid maid) {

		Maid temp = new Maid();
		temp.setUserName(maid.getUserName());
		temp.setPassword(maid.getPassword());
		Example<Maid> example = Example.of(temp);
		Optional<Maid> optional = maidDao.findOne(example);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Maid getMaid(Integer id) {

		Optional<Maid> optional = maidDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Maid> getAllMaids() {

		return maidDao.findAll();
	}

	@Override
	public boolean updateMaid(Maid maid) {

		Maid temp = new Maid();
		temp.setId(maid.getId());
		Example<Maid> example = Example.of(temp);
		Optional<Maid> optional = maidDao.findOne(example);
		if (optional.isPresent()) {
			maidDao.save(maid);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteMaid(Maid maid) {

		Maid temp = new Maid();
		temp.setId(maid.getId());
		Example<Maid> example = Example.of(temp);
		Optional<Maid> optional = maidDao.findOne(example);
		if (optional.isPresent()) {
			maid.set_isActive(false);
			maidDao.save(maid);
			return true;
		}
		return false;
	}

}
