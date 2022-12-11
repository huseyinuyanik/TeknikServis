package com.turkcell.TeknikServis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.Sale;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {

	

	List<Sale> findAllByProductId(Long id);

	List<Sale> findAllByISSold(boolean ISSold);

	List<Sale> findAllByProductIdAndISSold(Long id, boolean ISSold);

	
}
