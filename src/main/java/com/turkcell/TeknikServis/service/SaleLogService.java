package com.turkcell.TeknikServis.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.TeknikServis.model.SaleLOG;
import com.turkcell.TeknikServis.repo.SaleLogRepo;
import com.turkcell.TeknikServis.repo.SaleRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleLogService {
	
	private SaleLogRepo saleLogRepo;
	private EntityManager em;
	private SaleRepo saleRepo;
	
	
//	@Transactional(readOnly = true)
	public SaleLOG createLog(SaleLOG saleLog) {
		
		saleLog=saleLogRepo.save(saleLog);
		
		saleLogRepo.flush();
		em.clear();
		
		saleLog=saleLogRepo.findById(saleLog.getId()).get();
		saleLog.getSale().setISSold(true);
		saleRepo.save(saleLog.getSale());
		return saleLog;
	}

}
