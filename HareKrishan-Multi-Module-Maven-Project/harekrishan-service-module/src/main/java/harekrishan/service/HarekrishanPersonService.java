package harekrishan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harekrishan.domain.HarekrishanPerson;
import harekrishan.repository.HarekrishanPersonRepository;


@Service
public class HarekrishanPersonService {
	
	
	
	  @Autowired 
	  HarekrishanPersonRepository harekrishanPersonRepository;
	 
	public void savePersons()
	{
		List<HarekrishanPerson> list = new ArrayList<>();
		list.add(new HarekrishanPerson(1,"Krishan","GauLok"));
		list.add(new HarekrishanPerson(2,"Radha","Gaulok"));
		harekrishanPersonRepository.saveAll(list);
		
	}
	
	public List<HarekrishanPerson> getPersons()
	{
		savePersons();
		List<HarekrishanPerson> list = new ArrayList<>();
		list=harekrishanPersonRepository.findAll();
		return list;
	}

}
