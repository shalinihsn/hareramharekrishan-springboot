package harekrishan.all.repository;

import org.springframework.data.repository.CrudRepository;

import harekrishan.all.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
