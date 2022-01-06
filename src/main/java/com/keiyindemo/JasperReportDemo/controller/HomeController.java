package com.keiyindemo.JasperReportDemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.keiyindemo.JasperReportDemo.model.User;

@Controller
public class HomeController {
	@Autowired
	User keiyinUser;

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getUserList(HttpServletRequest request) {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(0, "wong", "keiyin", "0175847498", "kampar"));
		userList.add(new User(1, "wong1", "keiyin", "01758474981", "kampar1"));
		userList.add(new User(2, "wong2", "keiyin", "01758474982", "kampar2"));
		userList.add(new User(3, "wong3", "keiyin", "01758474983", "kampar3"));
		userList.add(new User(4, "wong4", "keiyin", "01758474984", "kampar4"));
		userList.add(new User(5, "wong5", "keiyin", "01758474985", "kampar5"));
		userList.add(keiyinUser);
		
		/*
		 * JRBeanCollectionDataSource beanCollectionDataSource = new
		 * JRBeanCollectionDataSource(userList); try { JasperReport compileReport =
		 * JasperCompileManager.compileReport(new FileInputStream(
		 * "C:\\Users\\intern\\eclipse-workspace\\JasperReportDemo\\src\\main\\java\\com\\keiyindemo\\JasperReportDemo\\controller\\user.jrxml"
		 * )); HashMap<String, Object> map = new HashMap<String, Object>(); JasperPrint
		 * report = JasperFillManager.fillReport(compileReport, map,
		 * beanCollectionDataSource); JasperExportManager.exportReportToPdfFile(report,
		 * "user.pdf");
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (JRException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		 

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
}
