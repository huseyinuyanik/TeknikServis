package com.turkcell.TeknikServis.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.service.ProposalService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("proposal")
@AllArgsConstructor
public class ProposalController {
	
	private ProposalService proposalService;
	
	@PostMapping("/save")
	public ResponseEntity<Proposal>  createProposal(@RequestBody Proposal proposal) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proposalService.createProposal(proposal));
		
	}
	

	
	@GetMapping("/getAll")
	public List<Proposal> getAll(){
		
		return proposalService.getAll();
		
	}
	
	@GetMapping("/getAllByUserId")
	public List<Proposal> getAllByUserId(@RequestHeader(name="id") Long id){
		
		return proposalService.getAllByUserId(id);
		
	}
	
	
	
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name="id") Long id) {
		proposalService.deleteById(id);
		return ResponseEntity.ok("Basariyla silindi");
		
	}

	
	

}
