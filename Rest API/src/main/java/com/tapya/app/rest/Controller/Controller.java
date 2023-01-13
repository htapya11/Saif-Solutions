package com.tapya.app.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tapya.app.rest.Models.Transaction;
import com.tapya.app.rest.Repo.TransactionDB;

@RestController
public class Controller {

    @Autowired
    private TransactionDB db;
    
    @GetMapping(value = "/")
    public String getPage(){
        return "Hello";
    }

    @GetMapping(value = "/users")
    public List<Transaction> getTransactions(){
        return db.findAll();
    }
    
    @PostMapping(value = "/save")
    public String saveTransaction(@RequestBody Transaction transaction){
        db.save(transaction);
        return "Saved";
    }

    @PutMapping(value = "update/{id}")
    public String updateTransaction(@PathVariable long id, @RequestBody Transaction transaction){
        Transaction updatedTransaction = db.findById(id).get();
        updatedTransaction.setDate(transaction.getDate());
        updatedTransaction.setItem(transaction.getItem());
        updatedTransaction.setCost(transaction.getCost());
        db.save(updatedTransaction);
        return "Updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTransaction(@PathVariable long id){
        Transaction deleteTransaction = db.findById(id).get();
        db.delete(deleteTransaction);
        return "Deleted row with id " + id;
    }
}
