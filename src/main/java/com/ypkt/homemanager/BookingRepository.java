package com.ypkt.homemanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByBookingStatus(String bookingStatus);
	
	


}
