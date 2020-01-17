package com.app.service;

import com.app.pojos.Salary;

public interface ISalaryService {

	public Salary getSalary(Integer id);

	public boolean addSalary(Salary salary);

	public boolean paySalary(Salary salary);

	public boolean deleteSalary(Salary salary);

}
