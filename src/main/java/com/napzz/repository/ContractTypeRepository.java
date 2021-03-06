package com.napzz.repository;

import com.napzz.entity.room.ContractType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Integer>{

}
