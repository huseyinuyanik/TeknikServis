package com.turkcell.TeknikServis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TeknikServis.model.Booking;
import com.turkcell.TeknikServis.service.BookingService;
import com.turkcell.TeknikServis.service.ServiceManager;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "booking")
@AllArgsConstructor
//@RequiredArgsConstructor
public class BookingController
{
	// final olup requeiredargsconstructor kullanılabilir
	private BookingService service;
	private ServiceManager serviceManager;
	
	@PostMapping(path = "save")
	public Booking save(@RequestBody Booking booking)
	{
		booking.setSERVICE(serviceManager.findById(booking.getSERVICE().getID()));
		return service.createBooking(booking);
//		Booking temp = service.createBooking(booking);
//		temp = service.getByID(temp.getID());
//		return temp;
	}
	
	@GetMapping(path = "getById/{id}")
	public Booking getById(@PathVariable(name = "id") Long id)
	{
		return service.getByID(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable(name="id") Long id)
	{
	service.deleteByID(id);
	return ResponseEntity.ok("Silindi");
	
	}
	
	@GetMapping("/getAllByDateAsc")
	public List<Booking> getAllByDateAsc(){
		return service.getAllByDateAsc();
	}
	
	@GetMapping("/getAllByDateDesc")
	public List<Booking> OrderByBOOKINGDATEDesc(){
		return service.OrderByBOOKINGDATEDesc();
		
	}
	
	@GetMapping("/getAll")
	public List<Booking> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/findByBookingLikeName")
	public List<Booking> findByBookingLikeName(String name) {
		return service.findByBookingLikeName(name);
		
		
	}
	@PutMapping("update/{id}")
	public Booking isCompleted(@PathVariable(name="id") Long id) {
		return service.isCompleted(id);
		
		
	}
}