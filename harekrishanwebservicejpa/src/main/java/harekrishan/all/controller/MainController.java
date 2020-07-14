package harekrishan.all.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import harekrishan.all.exception.RecordNotFoundException;
import harekrishan.all.model.Employee;
import harekrishan.all.service.EmployeeService;


@RestController
public class MainController {
	
	@Autowired
	private EmployeeService empService;
	public EmployeeService getEmpService() {
		return empService;
	}


	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}
	
	@RequestMapping("/")
	public String welcome()
	{
		return "Welcome HareKrishan";
	}

	
	@GetMapping("/krishan")
	public String krishan()
	{
		return "HareKrishan";
	}
	
	
	@GetMapping("/showallemployees")
	public List<Employee> showAllData()
	{
		return empService.getAllData();
	}

	
	@PostMapping("/saveemployee")
	public String saveEmployee(@Valid @RequestBody Employee emp)
	{
	   
	 String saved="";
	 Employee savedEmp=  empService.saveEmployee(emp);
	 if(savedEmp !=null)
	 {
		 saved="Employee with name "+savedEmp.getName()+" saved succesfully in database";
		 return saved;
	 }
	 else
	 {
		 
		 saved="Employee with name "+emp.getName()+"not saved in database";
	 }
	 return saved;
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") int empId) throws RecordNotFoundException
	{
		 String deleted="";
		 empService.deleteEmployee(empId);
		 deleted="employee with id"+empId+" deleted successfully";
		 return deleted;
	}
	
	@GetMapping("/findbyid/{id}")
	public String getEmployeeById(@PathVariable int id) throws RecordNotFoundException
	{
		System.out.println("controller");
		Employee employee=empService.getEmployeeById(id);
		
		return employee.toString();
	}
	
	@PutMapping("/updateemployee")
	public String updateEmployee(@Valid @RequestBody Employee emp) throws RecordNotFoundException
	{
	   
	 String saved="";
	 Employee savedEmp=  empService.updateEmployee(emp);
	 if(savedEmp !=null)
	 {
		 saved="Employee with name "+savedEmp.getName()+" updated succesfully in database";
		 return saved;
	 }
	 else
	 {
		 
		 saved="Employee with name "+emp.getName()+"not updated in database";
	 }
	 return saved;
	}
	

	
}
