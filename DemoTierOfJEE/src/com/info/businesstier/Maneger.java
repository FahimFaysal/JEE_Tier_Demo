package com.info.businesstier;

import java.util.ArrayList;

import com.infy.persistencetier.Service;

public class Maneger {
Service service = new Service();
	public String addEmplyoee(EmployeeTO employeeTO) throws Exception {

		new Validation().validate(employeeTO);

		if (service.getEmployee(employeeTO.getEmpId()) == null) { 
			
			service.addEmployee(employeeTO);
			
		} else {
			throw new Exception("The Employee id already registerd");
		}
		return "";
	}


	public String deleteEmplyoee(String empId) throws Exception {
		
		EmployeeTO delteEmployeeTO = service.getEmployee(empId);
		String re = null;
		
		if (delteEmployeeTO == null) {
			
			throw new Exception("The Employee found with this employee Id");
			
		} else {
			re = service.deleteEmployee(delteEmployeeTO);
		}
		
		return re+" : "+empId;
	}

	public String updateEmployee(EmployeeTO updateEmployeeTO) throws Exception{
		String result = null;
	
			if (service.getEmployee(updateEmployeeTO.getEmpId()) != null) { 
				
				result = service.UpdateEmployee(updateEmployeeTO);
				
			} else {
				throw new Exception("The Employee is not found !");
			}
			
		
		return result;
		
	}


	public ArrayList<EmployeeTO> allEmployee() {
	
		return service.allEmployee();
	}
	
}
