package com.ypkt.homemanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>{
	
	Employer getByEmail(String email);
	
	

}
