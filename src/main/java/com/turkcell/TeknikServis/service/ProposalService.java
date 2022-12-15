package com.turkcell.TeknikServis.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.repo.ProposalRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalService {
	
	private ProposalRepo proposalRepo;
	private EntityManager ent;
	
	
	public Proposal createProposal(Proposal proposal) {
		
		proposal.setProposalDate(new Date());
		proposal= proposalRepo.save(proposal);
		proposal.setApproved(false);
		ent.clear();
		
		return proposalRepo.findById(proposal.getId()).get();
		 
		  
		
	}
	
	public List<Proposal> getAll(){
		
		return proposalRepo.findAll();
		
	}
	
	public void deleteById(Long id) {
		proposalRepo.deleteById(id);
		
	}

	public List<Proposal> getAllByUserId(Long id) {
		
		return proposalRepo.findAllByUserID(id);
		
		
	}

}
