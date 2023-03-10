package com.ypkt.homemanager;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends JpaRepository <JobOffer, Long>{

	JobOffer findByEmployeeId(Long employeeId);

	JobOffer findByJobOfferStatus(String string);

	//List<JobOffer> findByJobOfferStatus(String string);


	



}
