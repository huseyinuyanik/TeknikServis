package com.turkcell.TeknikServis.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// eski yapılan yapılan satışlar bu tabloda
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleLOG
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String krediKarti;
	
	@CreationTimestamp
	private java.sql.Timestamp saleDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private SystemUser user;
	
	@OneToOne(fetch = FetchType.EAGER)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Sale sale;
	

}
