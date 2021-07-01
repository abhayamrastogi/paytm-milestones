package com.example.milestone1.repository;

import com.example.milestone1.entity.PaytmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaytmUserRepository extends JpaRepository<PaytmUser, Long> {

}
