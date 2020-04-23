package com.emp.controllerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dto.EmpDTO;
import com.emp.vo.EmpVO;
import com.emp.service.EmpService;



public class EmpControllerServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		EmpVO vo = null;
		EmpDTO dto = null;
		EmpService service = null;
		PrintWriter pw = null;
		
		String empNo = null;
		String empName = null;
		String empAddr = null;
		String basicSalary = null;
		String deptNo = null;
		
		String result = null;
		
		
// reading data given from user .............by presentation layer............
		empNo = req.getParameter("empno");
		empName = req.getParameter("empname");
		empAddr = req.getParameter("empaddr");
		basicSalary = req.getParameter("basicsalary");
		deptNo = req.getParameter("deptno");
		
// create EmpVo class object having form data ................................
		vo = new EmpVO();
		
		vo.setEmpNo(empNo);
		vo.setEmpName(empName);
		vo.setEmpAddr(empAddr);
		vo.setBasicSalary(basicSalary);
		vo.setDeptNo(deptNo);
//......converting VO class object to DTO class object.....................
		dto = new EmpDTO();
		
		dto.setEmpNo(Integer.parseInt(empNo));
		dto.setEmpName(empName);
		dto.setEmpAddr(empAddr);
		dto.setBasicSalary(Float.parseFloat(basicSalary));
		dto.setDeptNo(Integer.parseInt(deptNo));

//.......use service class to exacute business logic over it .................
		service = new EmpService();
		result = service.generateEmpStatus(dto);
		
//..............display result ................................................
		
		pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1>"+result+"<h1>");
		
	}// end of doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doGet(req,res);
	}// end of doPost
}//end of class
