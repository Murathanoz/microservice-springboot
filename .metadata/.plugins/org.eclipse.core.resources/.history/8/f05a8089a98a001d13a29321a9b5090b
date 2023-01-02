package com.example.inventoryservice.contoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventoryservice.service.*;

@Controller
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/{code}")
	public boolean isInStock(@PathVariable("code") String code) {
		return inventoryService.isInStock(code);
	}
	
}
