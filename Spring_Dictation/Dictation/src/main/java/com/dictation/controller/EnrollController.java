package com.dictation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dictation.service.EnrollService;
import com.dictation.vo.EnrollVO;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/enroll")
public class EnrollController {
	
	@Autowired
	private EnrollService enrollService;
	
	
    //insert user
	@PostMapping(produces = "application/json;charset=UTF-8")
	public void execWrite(@RequestBody EnrollVO enroll) {
		enrollService.insert(enroll);
	}


      //according to id delete
	@GetMapping(value="/delete/{user_id}")
	public void delete(@PathVariable("user_id") String user_id) {
		enrollService.delete(user_id);
	}
	//modify
	//user_id는 같아야 함
	@PostMapping(value="/update")
	public void update(@RequestBody EnrollVO enroll) {
		enrollService.update(enroll);
	}

	//according to id Query students
	@GetMapping(value="/get/{user_id}")
	public EnrollVO getById(@PathVariable("user_id") String user_id) {
		EnrollVO enroll = enrollService.getById(user_id);
		return enroll;
	}
	
	//All queries
	@PostMapping(value="/list")
	public List<EnrollVO> list(){
		return enrollService.list();
	}	
}
