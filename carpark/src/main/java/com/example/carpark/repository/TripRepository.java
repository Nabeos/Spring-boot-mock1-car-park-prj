package com.example.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpark.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{

}
