package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.ItemDetails;
import com.luv2code.springboot.cruddemo.entity.ItemMaster;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.ItemMaster;
import com.luv2code.springboot.cruddemo.service.MasterServiceImpl;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class MasterRestController {

    private MasterServiceImpl masterService;

    @Autowired
    public MasterRestController(MasterServiceImpl theMasterService) {
        masterService = theMasterService;
    }

    // expose "/masters" and return list of employees
    @GetMapping("/masters")
    public List<ItemMaster> findAll() {
        return masterService.findAll();
    }

    @GetMapping("/ma")
    public String findAl() {
        System.out.println("I'm Hereeeeeeeeeeeeeeeeeee");
        System.err.println("I'm Thereeeeeeeeeeeeeeeeee");
        return "Hello World";
    }

    // add mapping for GET /employees/{employeeId}
//	
    @GetMapping("/masters/{itemName}")
    public ItemMaster getItemMasterByName(@PathVariable("itemName") String itemName) {

        ItemMaster theMaster = masterService.findByItemName(itemName);

        return theMaster;
    }

    @GetMapping("/masters/byName/{itemName}")
    public List<ItemDetails> getItemDetailsByName(@PathVariable("itemName") String itemName) {
        List<ItemDetails> itemDetails = new ArrayList<ItemDetails>();
        if (itemName.isEmpty() || itemName == null) {
            itemDetails.add(new ItemDetails());

        } else {
            itemDetails = masterService.findItmByItemNameStartingWithName(itemName);
        }

        return itemDetails;
    }

    @PostMapping("/masters/save/{itemMaster}")
    public ItemMaster save(@PathVariable("itemMaster") ItemMaster itemMaster){
        ItemMaster ItemMaster = new ItemMaster();
        ItemMaster = masterService.save(new ItemMaster());
        return  itemMaster;
    }
//	
//	// add mapping for POST /employees - add new employee
//	
//	@PostMapping("/employees")
//	public Master addEmployee(@RequestBody Master theEmployee) {
//		
//		// also just in case they pass an id in JSON ... set id to 0
//		// this is to force a save of new item ... instead of update
//		
//		theEmployee.setId(0);
//		
//		employeeService.save(theEmployee);
//		
//		return theEmployee;
//	}
//	
//	// add mapping for PUT /employees - update existing employee
//	
//	@PutMapping("/employees")
//	public Master updateEmployee(@RequestBody Master theEmployee) {
//		
//		employeeService.save(theEmployee);
//		
//		return theEmployee;
//	}
//	
//	// add mapping for DELETE /employees/{employeeId} - delete employee
//	
//	@DeleteMapping("/employees/{employeeId}")
//	public String deleteEmployee(@PathVariable int employeeId) {
//		
//		Master tempEmployee = employeeService.findById(employeeId);
//		
//		// throw exception if null
//		
//		if (tempEmployee == null) {
//			throw new RuntimeException("Employee id not found - " + employeeId);
//		}
//		
//		employeeService.deleteById(employeeId);
//		
//		return "Deleted employee id - " + employeeId;
//	}

}
