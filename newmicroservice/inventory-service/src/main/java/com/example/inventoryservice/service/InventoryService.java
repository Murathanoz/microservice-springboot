package com.example.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {
	private InventoryRepository inventoryRepository;

	public InventoryService(InventoryRepository inventoryRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
	}

		
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> code) {
		return  inventoryRepository.findByCodeIn(code).stream()
				.map(inventory->				
					InventoryResponse.builder()
						.code(inventory.getCode())
						.isInStock(inventory.getQuantity()>0)
						.build()
				)
				.toList();		

	}
}
