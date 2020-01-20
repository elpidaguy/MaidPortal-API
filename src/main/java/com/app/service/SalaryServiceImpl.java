package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ISalaryDao;
import com.app.pojos.Salary;

@Service
public class SalaryServiceImpl implements ISalaryService {

	@Autowired
	ISalaryDao salaryDao;

	@Override
	public Salary getSalary(Integer id) {

		Optional<Salary> optional = salaryDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean addSalary(Salary salary) {

		/*
		 * Salary sal = new Salary(); sal.setId(salary.getId()); Example<Salary> example
		 * = Example.of(sal); Optional<Salary> optional = salaryDao.findOne(example);
		 */
		Optional<Salary> optional = salaryDao.findById(salary.getId());
		if (optional.isPresent()) {
			return false;
		}
		salaryDao.save(salary);
		return true;
	}

	@Override
	public boolean paySalary(Salary salary) {

		/*
		 * Salary sal = new Salary(); sal.setId(salary.getId()); Example<Salary> example
		 * = Example.of(sal); Optional<Salary> optional = salaryDao.findOne(example);
		 */
		Optional<Salary> optional = salaryDao.findById(salary.getId());
		if (optional.isPresent()) {
			salary.set_isPaid(true);
			salaryDao.save(salary);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSalary(Salary salary) {

		/*
		 * Salary sal = new Salary(); sal.setId(salary.getId()); Example<Salary> example
		 * = Example.of(sal); Optional<Salary> optional = salaryDao.findOne(example);
		 */
		Optional<Salary> optional = salaryDao.findById(salary.getId());
		if (optional.isPresent()) {
			salary.set_isDeleted(true);
			salaryDao.save(salary);
			return true;
		}
		return false;
	}

}
