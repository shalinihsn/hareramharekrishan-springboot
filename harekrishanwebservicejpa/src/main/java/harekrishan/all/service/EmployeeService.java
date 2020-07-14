package harekrishan.all.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import harekrishan.all.exception.RecordNotFoundException;
import harekrishan.all.model.Employee;
import harekrishan.all.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	public EmployeeRepository getEmpRepository() {
		return empRepository;
	}

	public void setEmpRepository(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}

	public List<Employee> getAllData() {
	  return 	(List<Employee>) empRepository.findAll();
	}

	public Employee saveEmployee(Employee emp) {

		
		Employee emp1=empRepository.save(emp);
		return emp1;
		
	}

	public void deleteEmployee(int empId) throws RecordNotFoundException {
		Optional<Employee> employee = empRepository.findById(empId);
		if(employee.isPresent())
		{
		   empRepository.deleteById(empId);
		}
		else
		{
			throw new RecordNotFoundException("The employee with id "+empId+" doesn't exist");
		}

}

	public Employee updateEmployee(Employee emp) throws RecordNotFoundException {
		
		Optional<Employee> employee = empRepository.findById(emp.getId());
		if(employee.isPresent())
		{
			employee.get().setAddress(emp.getAddress());
			employee.get().setDesignation(emp.getDesignation());
			employee.get().setName(emp.getName());
		Employee updatedEmployee=	empRepository.save(employee.get());
		return updatedEmployee;
		}
		else
		{
			throw new RecordNotFoundException("The employee with below details sent for update does not exist. Name : "+emp.getName()+" Address"+ emp.getAddress()+" Designation "+emp.getDesignation());
		}
	}

	@Cacheable(cacheNames="employeeCache",key="#id")
	public Employee getEmployeeById(int id) throws RecordNotFoundException {
        System.out.println("service class exceuting"); 
		Optional<Employee> optional=empRepository.findById(id);
		if(optional.isPresent())
		{
			System.out.println("getting employee from db");
			return optional.get();
		}
		else {
			throw new RecordNotFoundException("employee with empId  "+id+"  does not exist");
		}
		
	}
	}
