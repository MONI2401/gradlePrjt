package com.cg.cars.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.cars.entities.Car;


public interface ICarRepository extends JpaRepository<Car, Integer>{
	@Query("SELECT c FROM Car c WHERE city LIKE :city")
	public List<Car> findByCity(@Param("city") String city);

	public Car findByModel(String model);
	public Car findByBrand(String brand);
	
	

}
