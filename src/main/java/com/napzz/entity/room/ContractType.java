package com.napzz.entity.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ContractType {
    
    @JsonProperty("contractId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int contractId;

    private String contract;

    public ContractType() {
       
    }

    public ContractType(int contractId, String contract) {
        this.contractId = contractId;
        this.contract = contract;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "ContractType [contract=" + contract + ", contractId=" + contractId + "]";
    }

}
