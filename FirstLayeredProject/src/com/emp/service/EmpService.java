package com.emp.service;

import com.emp.bo.EmpBO;
import com.emp.dao.EmpDAO;
import com.emp.dto.EmpDTO;

public class EmpService {
	
	public String generateEmpStatus(EmpDTO dto)
	{
		int rowAffected = 0;
		float grossSalary = 0.0f;
		float netSalary = 0.0f;
		
		EmpBO bo = null;
		EmpDAO dao = null;
		
		
		
		// use business logic to calculate gross/net salaries while 
		//basic salary is given..
		grossSalary = dto.getBasicSalary()+dto.getBasicSalary()*0.4f;
		netSalary = grossSalary - grossSalary*0.15f;
		
		//prepare BO class object having persistable data 
		
		bo = new EmpBO();
		
		bo.setEmpNo(dto.getEmpNo());
		bo.setEmpName(dto.getEmpName());
		bo.setEmpAddr(dto.getEmpAddr());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setDeptNo(dto.getDeptNo());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		
		//use DAO class................................................................
		dao = new EmpDAO();
		rowAffected = dao.insert(bo);
		
		if (rowAffected == 0)
			return "Registration failed";
		else
			return "Registration succeed number of row affected is "+rowAffected;
	}//end of method generateEmployeeStatus
}//end of class
