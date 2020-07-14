package harekrishan.all.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Employee implements Serializable{
	
	
	
	public Employee() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int id;
	
	@NotBlank(message = "address can not be blank")
	private String address;
	@NotBlank(message="designation cannot be blank")
	private String designation;
	@NotBlank(message="name can not be blank")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", address=" + address + "]";
	}

}
