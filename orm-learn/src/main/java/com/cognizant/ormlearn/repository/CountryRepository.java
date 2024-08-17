package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	@Query(value = "select * from country where co_name like %:search% order by co_code asc",nativeQuery = true)
	public List<Country> searchCountries(@Param("search")String search);
	
	
	@Query(value = "select * from country where co_name like :search% order by co_code asc",nativeQuery = true)
	public List<Country> searchCountriesByAlphabet(@Param("search")char search);
}
