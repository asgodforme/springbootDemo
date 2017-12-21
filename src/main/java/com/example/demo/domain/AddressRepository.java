package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository  extends JpaRepository<Address, Long>  {

	@Query("select a.city as address, a.userName as userName, b.email as email from"
			+ " Address a, User b where a.userName = b.userName")
	PersonInfo findPersonInfo();
}
