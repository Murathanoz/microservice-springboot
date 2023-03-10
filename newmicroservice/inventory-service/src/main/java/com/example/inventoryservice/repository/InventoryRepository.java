package com.example.inventoryservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	List<Inventory> findByCodeIn(List<String> code);


}
