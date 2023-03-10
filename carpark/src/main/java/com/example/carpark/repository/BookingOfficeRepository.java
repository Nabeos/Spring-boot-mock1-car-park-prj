package com.example.carpark.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.carpark.entity.BookingOffice;

@Repository
public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {

  @Query(value = "SELECT * FROM bookingoffice WHERE officeName LIKE ?1", countQuery = "SELECT Count(*) from bookingoffice where officeName LIKE ?1", nativeQuery = true)
  Page<BookingOffice> getAllBookingOffices(String searchName, Pageable page);

}
