package com.turkcell.TeknikServis.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.Booking;
import com.turkcell.TeknikServis.repo.BookingRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class BookingService
{
	private BookingRepo repo;

	private EntityManager entityManager;
	
	public void refresh(Booking booking)
	{
		entityManager.refresh(booking);
	}

	public Booking createBooking(Booking booking)
	{
		LocalDate someDate = createBookingDate(booking.getSERVICE().getDURATION());
		booking.setBOOKINGDATE(someDate);
		booking = repo.saveAndFlush(booking);
		entityManager.clear();
		booking = repo.findById(booking.getID()).get();
		// repo.flush();
		// repo.findAll();
		// Booking temp = repo.findOne(Example.of(booking)).get();
		// repo.save(temp);
		// booking = repo.findAllById(List.of(booking.getID())).get(0);
		// ExampleMatcher matcher = ExampleMatcher.matchingAny().withMatcher("ID", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnoreCase().withIgnoreNullValues();
		// booking = repo.findOne(Example.of(booking, matcher)).get();
		// booking = repo.findAllById(List.of(booking.getID())).get(0);
		// refresh(temp);
		return booking;
	}
	
	private LocalDate createBookingDate(int serviceDuration)
	{
		LocalDate bookingDate = LocalDate.now();
		int dailyWorkHours = 0;
		do
		{
			dailyWorkHours = serviceDuration;
			bookingDate = bookingDate.plusDays(1L);
			List<Booking> bookings = repo.searchByBOOKINGDATE(bookingDate);
			for (Booking booking : bookings)
			{
				dailyWorkHours += booking.getSERVICE().getDURATION();
			}
		}
		while (dailyWorkHours > 10);
		return bookingDate;
	}

	public Booking getByID(Long id)
	{	
		Booking booking= repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Bulunamadi."));
//		Response response= new Response();
		return booking;
	}

	public void deleteByID(Long id)
	{
		repo.deleteById(id);
	}
	
	public List<Booking> getAllByDateAsc(){
		return repo.OrderByBOOKINGDATEAsc();
	}
	
	public List<Booking> OrderByBOOKINGDATEDesc(){
		return repo.OrderByBOOKINGDATEDesc();
		
	}
	
	public List<Booking> findByBookingLikeName(String name) {
		return repo.findByBookingLikeName(name);
		
		
	}
	
	public Booking isCompleted(Long id)  {
		
		Booking booking=repo.findById(id).get();
		booking.setISDONE(true);
		return repo.save(booking);
		
		
//		Booking booking= repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Bulunamadi."));
//		Response response= new Response();
//		response.setID(booking.getID());
//		response.setCompleted(booking.isCompleted());
//		
//		if(booking.isCompleted()==bookingDto.isCompleted()) {
//			
//			throw new Exception("Degismedi.");
//		}
//		
//		return response;
		
	}

	public List<Booking> getAll() {
		
		return repo.findAll();
	}
}
