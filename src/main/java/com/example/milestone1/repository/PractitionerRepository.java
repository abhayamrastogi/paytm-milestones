package com.example.milestone1.repository;

import com.example.milestone1.model.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {

    @Query("select u from Practitioner u where u.email_id = ?1 and u.user_name = ?2")
    public Practitioner findByEmailIDAndUsername(String emailID, String username);

    @Query("select u from Practitioner u where u.email_id = ?1 and u.mobile_number = ?2")
    public Practitioner findByEmailIDAndMobileNumber(String emailID, String mobileNumber);

}
