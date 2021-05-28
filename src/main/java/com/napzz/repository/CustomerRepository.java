package com.napzz.repository;

import com.napzz.entity.room.ContractType;
import com.napzz.entity.user.Customer;
import com.napzz.entity.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
