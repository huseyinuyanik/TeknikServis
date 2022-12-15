package com.turkcell.TeknikServis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Proposal
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@Column
	private double price;
	
	@Column(length = 100)
	private String note;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SystemUser user;
	
	private boolean Approved;
	
	private Date ProposalDate;
	
	

}
