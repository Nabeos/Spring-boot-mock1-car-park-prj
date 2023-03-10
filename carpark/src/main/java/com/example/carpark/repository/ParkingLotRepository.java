package com.example.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpark.entity.ParkingLot;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>{

}
