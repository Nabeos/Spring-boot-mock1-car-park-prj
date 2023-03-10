package com.example.carpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpark.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, String>{

}
