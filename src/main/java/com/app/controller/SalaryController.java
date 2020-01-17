package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Salary;
import com.app.service.ISalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	ISalaryService salaryService;

	@RequestMapping(value = "/getSalary", method = RequestMethod.POST)
	public ResponseEntity<?> getSalary(@RequestBody Integer id) {

		Salary salary = salaryService.getSalary(id);
		if (salary != null) {
			return new ResponseEntity<Salary>(salary, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Maid not found", HttpStatus.OK);
	}

	@RequestMapping(value = "/addSalary", method = RequestMethod.POST)
	public ResponseEntity<?> addSalary(@RequestBody Salary salary) {

		if (salaryService.addSalary(salary)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Addition of salary failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/paySalary", method = RequestMethod.POST)
	public ResponseEntity<String> paySalary(@RequestBody Salary salary) {

		if (salaryService.paySalary(salary)) {
			return new ResponseEntity<String>("Salary payment successfull", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Salary payment failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteSalary", method = RequestMethod.POST)
	public ResponseEntity<?> deleteSalary(@RequestBody Salary salary) {

		if (salaryService.deleteSalary(salary)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deletion of salary failed", HttpStatus.OK);
	}
}
