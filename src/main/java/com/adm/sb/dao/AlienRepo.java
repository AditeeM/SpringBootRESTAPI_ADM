package com.adm.sb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adm.sb.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien, Integer> {
//	
//	List<Alien> findByTech(String tech);
//	List<Alien> findByAidGreaterThan(int aid);
//	// jpql
//	@Query("from Alien where tech=?1 order by aname")
//	
//	List<Alien> findByRechSorted(String tech);
	public interface AlienRepo extends JpaRepository<Alien, Integer> {
}
	
	//spring.datasource.url=jdbc:h2:file:./data/aditee for saving permanently
