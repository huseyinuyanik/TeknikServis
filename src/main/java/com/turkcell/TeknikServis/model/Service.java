package com.turkcell.TeknikServis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

// yapılan işlemler bu tabloda
@Entity
@Setter
@Getter
public class Service
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String NAME;

	private int DURATION;

	private int DESKTOP;

	private int LAPTOP;

	private int MAC;
}