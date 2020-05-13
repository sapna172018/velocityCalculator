package com.capacity.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.capacity.employee.Allocation;
import com.capacity.employee.Employee;


@Controller
public class controller {
	
	 @Autowired
	 ServletContext context;
		int workingDays;
		int nationalHolidays;
		int allocatedHrs;
		double finalCapacity=0.0;
	 List<Integer> allocated=new ArrayList<Integer>();
	 List<Employee> employee= new ArrayList<Employee>();
	 List<Integer> individualCapacity= new ArrayList<Integer>();
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	
	public  String capacity(Model model) {
		
		model.addAttribute("message","Welcome to capacity calculation");
		return "redirect:getExcel";
	}
	@RequestMapping(value="/getExcel",method=RequestMethod.GET)
		
		public  String upload(Model model) {
			
			model.addAttribute("message","Welcome to capacity calculation");
			return "getExcel";
		}
	
	@RequestMapping(value="/allocation",method=RequestMethod.GET)
	
	public  String getAllocation(Model model) {
		
		model.addAttribute("message","Allocation");
		return "allocation";
	}
	
	
	@RequestMapping(value="/enter",params="yes",method=RequestMethod.POST)
	public String sameAllocation(@ModelAttribute("allocation") Allocation a) {
		
		return"entry";
	}
	
	@RequestMapping(value="/enter",params="no",method=RequestMethod.POST)
	public String diffAllocation(Model model,@ModelAttribute("allocation") Allocation a) {
		
		model.addAttribute("list",employee);
        		
		return"entry2";
	}
	
	
	@RequestMapping(value="/enterFocusFactor",params="y",method=RequestMethod.POST)
	public String sameFocus(@ModelAttribute("allocation") Allocation a) {
		
		return"enterFocus";
	}
	
	@RequestMapping(value="/enterFocusFactor",params="n",method=RequestMethod.POST)
	public String diffFocus(Model model,@ModelAttribute("allocation") Allocation a) {
		model.addAttribute("list",employee);
		return"enterFocus2";
	}
	
	@RequestMapping(value="/enterFocus",method=RequestMethod.POST)
	
	public  String enterfocusFactor(Model model,@ModelAttribute("allocation") Allocation a) {
		
		//model.addAttribute("message","Allocation");
		
		 workingDays=a.getTotalWorkingDays();
		 nationalHolidays=a.getNationalHolidays();
		 allocatedHrs=a.getAllocatedHrs();
		 
		 allocated=a.getAllocated();
//		 for(int i=0;i<allocated.size();i++) {
//			 System.out.println(allocated.get(i));
//		 }
		 
			//model.addAttribute("list",employee);
		//System.out.println(workingDays);
		return "focusFactor";
	}
	
	
	@RequestMapping(value="/processExcel",method=RequestMethod.POST)
	
	public String processFile(Model model,@RequestParam("excelFile") MultipartFile excelFile ) throws IOException {
		DataFormatter formatter=new DataFormatter();
		int i=2;
		//List<Employee> employee= new ArrayList<Employee>();
		XSSFWorkbook workbook=new XSSFWorkbook(excelFile.getInputStream());
		XSSFSheet worksheet=workbook.getSheetAt(0);
		int cnum=worksheet.getRow(0).getLastCellNum();
		//int count=0;
		while(i<=worksheet.getLastRowNum()) {
			
			Employee e=new Employee();
			
			XSSFRow row=worksheet.getRow(i++);
			e.setTeamMember(formatter.formatCellValue(row.getCell(0)));
			
			for(int j=1;j<cnum;j++) {
				int count=0;
				if(formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("off")||formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("off*")) {
					count++;
				e.setLeaves(count);
				}
				
			}			
			
			employee.add(e);
		    		
		}
		
		workbook.close();
		model.addAttribute("list",employee);
		return "getExcel";
		
	}
	
@RequestMapping(value="/calculate",method=RequestMethod.POST)
	
	public  String calculateCapacity(Model model,@ModelAttribute("allocation") Allocation a) {
		
		//model.addAttribute("message","Allocation");
	  double total=0;
	 // double finalCapacity=0.0;
      
	  List<Double> fFactor=new ArrayList<Double>();
	  fFactor=a.getfFactor();
	  double focusFactor=a.getFocusFactor();
	
	
	//System.out.println("hrs"+allocatedHrs);
	//System.out.println("workingDays"+workingDays);
	
	if(allocated==null) {
     for(int i=0;i<employee.size();i++) {
    	 
    	 int capacity=(workingDays-(nationalHolidays+employee.get(i).getLeaves()))*allocatedHrs;
    	 individualCapacity.add(capacity);
    	// System.out.println(capacity);
     }
     
	}
	
	if(allocated!=null) {
		 for(int i=0;i<employee.size();i++) {
	    	 
	    	 int capacity=(workingDays-(nationalHolidays+employee.get(i).getLeaves()))*allocated.get(i);
	    	 individualCapacity.add(capacity);
	    	// System.out.println(capacity);
	     }
		
	}
     
     for(int j=0;j<individualCapacity.size();j++) {
    	
    	 total=total+individualCapacity.get(j);
    	 //System.out.println("***********************"+total+"*************************");
    	 
     }
     
    // System.out.println(total);
	
    // model.addAttribute("total",total);
     a.setTotal(total);
     System.out.println("total is"+total);
     if(fFactor!=null) {
    	 for(int j=0;j<fFactor.size();j++) {
    	 finalCapacity=finalCapacity+((fFactor.get(j)*individualCapacity.get(j))/100); 
     }
     }
     else {
     finalCapacity=finalCapacity+((focusFactor*total)/100);
     }
     //String FinalCapacity=String.valueOf(finalCapacity);
     model.addAttribute("total",total);
     //model.addAttribute("finalCapacity",finalCapacity);
	   
		return "redirect:capacity";
//	}
	
	}

	   @RequestMapping(value = "/capacity", method = RequestMethod.GET)
	       public String finalPage(Model model) {
		   model.addAttribute("finalCapacity",finalCapacity); 
	   return "capacity";
	}




}
