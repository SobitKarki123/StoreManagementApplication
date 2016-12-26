package mum.store.bal;

import mum.store.model.Employee;
import mum.store.repository.EmployeeRepository;

public class EmployeeManager {
	//private Employee employee;
	private EmployeeRepository empRepo=new EmployeeRepository();
	public boolean insertEmployee(Employee emp){
		boolean status = empRepo.add(emp);
		return status;
	}

}
