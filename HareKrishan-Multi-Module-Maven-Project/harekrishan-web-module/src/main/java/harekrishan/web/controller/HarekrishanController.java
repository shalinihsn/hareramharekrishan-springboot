package harekrishan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harekrishan.domain.HarekrishanPerson;
import harekrishan.service.HarekrishanPersonService;

@RestController
public class HarekrishanController {
	
	@Autowired
	private HarekrishanPersonService harekrishanPersonService;

	@GetMapping("/harekrishan/allpersons")
	public List<HarekrishanPerson> getAllPersons()
	{
		return harekrishanPersonService.getPersons();
	}
}
