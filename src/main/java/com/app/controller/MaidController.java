package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.BaseWrapper;
import com.app.pojos.Maid;
import com.app.service.IMaidService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maid")
public class MaidController {

	@Autowired
	IMaidService maidService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody Maid maid) {

		if (maidService.register(maid)) {
			return new ResponseEntity<String>("Register Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong", HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Maid maid) {

		Maid temp = maidService.login(maid);
		if (temp != null) {
			return new ResponseEntity<Maid>(temp, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Authentication failed", HttpStatus.OK);
	}

	@RequestMapping(value = "/getMaid/{id}")
	public ResponseEntity<?> getMaid(@PathVariable Integer id) {

		Maid maid = maidService.getMaid(id);
		if (maid != null) {
			return new ResponseEntity<Maid>(maid, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Maid Not Found", HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllMaids", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMaids(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "") String searchBy) {

		BaseWrapper baseWrapper = new BaseWrapper();
		BaseWrapper.Meta meta = baseWrapper.new Meta();
		int numberOfRows = maidService.getNumberOfRows();
		baseWrapper.setItems(maidService.getAllMaids(pageNo, pageSize, sortBy, searchBy));
		if (baseWrapper.getItems() != null) {
			meta.setPage(pageNo);
			meta.setPageSize(pageSize);
			meta.setTotalCount(numberOfRows);
			meta.setTotalPages(numberOfRows / pageSize);
			
			baseWrapper.setMeta(meta);
			
			return new ResponseEntity<BaseWrapper>(baseWrapper, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Nothing found", HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/getAllMaids", method = RequestMethod.GET) public
	 * ResponseEntity<?> getAllMaids(@RequestBody BaseWrapper baseWrapper) {
	 * 
	 * BaseWrapper temp = new BaseWrapper();
	 * temp.setItems(maidService.getAllMaids(baseWrapper.getMeta().getPage(),
	 * baseWrapper.getMeta().getPageSize()));
	 * temp.getMeta().setPage(baseWrapper.getMeta().getPage());
	 * temp.getMeta().setPageSize(baseWrapper.getMeta().getPageSize());
	 * temp.getMeta().setTotalCount(maidService.getNumberOfRows());
	 * temp.getMeta().setTotalPages((temp.getMeta().getTotalCount()) /
	 * (baseWrapper.getMeta().getPageSize())); System.out.println(temp); return new
	 * ResponseEntity<BaseWrapper>(temp, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/updateMaid", method = RequestMethod.POST)
	public ResponseEntity<?> updateMaid(@RequestBody Maid maid) {

		if (maidService.updateMaid(maid)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Maid Not Found", HttpStatus.OK);
	}
}
