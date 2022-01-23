package com.example.world.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.world.entity.jpa.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
	List<Country> findAllByContinent(String continent);

	Country findTopByOrderByPopulationDesc();

	@Query("select distinct c.continent from Country c")
	List<String> getAllContinents();

	@Query(nativeQuery = true, 
			value = "select distinct continent from country")
	List<String> kitalariGetir();

}