package com.turkcell.TeknikServis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.TeknikServis.model.Service;

public interface ServiceRepo extends JpaRepository<Service, Long> {

}
