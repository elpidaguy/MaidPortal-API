package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.dao.IMaidDao;
import com.app.pojos.Maid;

@Service
public class MaidServiceImpl implements IMaidService {

	@Autowired
	IMaidDao maidDao;

	@Override
	public boolean register(Maid maid) {

		Optional<Maid> optional = maidDao.findById(maid.getId());
		if (optional.isPresent()) {
			return false;
		}
		maidDao.save(maid);
		return true;
	}

	@Override
	public Maid login(Maid maid) {
		/*
		 * Maid temp = new Maid(); temp.setUserName(maid.getUserName());
		 * temp.setPassword(maid.getPassword()); Example<Maid> example =
		 * Example.of(temp); Optional<Maid> optional = maidDao.findOne(example);
		 * 
		 * if (optional.isPresent()) { return optional.get(); }
		 */

		Maid temp2 = maidDao.loginMaid(maid.getUserName(), maid.getPassword());
		if (temp2 != null) {
			return temp2;
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
	public List<Maid> getAllMaids(Integer pageNo, Integer pageSize, String sortBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Maid> pagedResult = maidDao.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		}
		return new ArrayList<Maid>();
	}

	@Override
	public boolean updateMaid(Maid maid) {

		/*
		 * Maid temp = new Maid(); temp.setId(maid.getId()); Example<Maid> example =
		 * Example.of(temp); Optional<Maid> optional = maidDao.findOne(example); if
		 * (optional.isPresent()) { maidDao.save(maid); return true; }
		 */

		Maid temp2 = maidDao.loginMaid(maid.getUserName(), maid.getPassword());
		if (temp2 != null) {
			maidDao.save(maid);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMaid(Maid maid) {

		/*
		 * Maid temp = new Maid(); temp.setId(maid.getId()); Example<Maid> example =
		 * Example.of(temp); Optional<Maid> optional = maidDao.findOne(example); if
		 * (optional.isPresent()) { maid.set_isActive(false); maidDao.save(maid); return
		 * true; }
		 */

		Maid temp2 = maidDao.loginMaid(maid.getUserName(), maid.getPassword());
		if (temp2 != null) {
			maid.set_isActive(false);
			maidDao.save(maid);
			return true;
		}
		return false;
	}

	@Override
	public Maid getMaidByEmail(String email) {

		/*
		 * maid.setEmail(email); Example<Maid> example = Example.of(maid);
		 * Optional<Maid> optional = maidDao.findOne(example);
		 *
		 */
		Maid maid = maidDao.getMaidByEmail(email);
		if (maid != null) {
			return maid;
		}
		return null;
	}

}
