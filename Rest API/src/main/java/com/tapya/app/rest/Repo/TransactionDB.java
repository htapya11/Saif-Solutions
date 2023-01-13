package com.tapya.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapya.app.rest.Models.Transaction;

public interface TransactionDB extends JpaRepository<Transaction, Long>{
    
}
