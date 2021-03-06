package com.example.demo.controller;

import com.example.demo.exception.PersonNotFound;
import com.example.demo.model.InfoTransaction;
import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionRepository transactionRepository;
    @PostMapping("transaction")
    public void addTransaction(@RequestBody InfoTransaction transaction) {
        try {
            transactionService.doTransaction(transaction);
            long parrainId=transaction.getParrainId();
            long personneId=transaction.getPersonneId();
            System.out.println(parrainId+" "+personneId);
        }
        catch (PersonNotFound e){
            System.out.println(e.toString());
        }
    }
    @GetMapping("transaction/{id}")
    @ResponseBody
    public ArrayList<Transaction> getTransactions(@PathVariable("id")long id){
        ArrayList<Transaction> transactions=new ArrayList<Transaction>();
        transactions=transactionRepository.getTransactionById(id);
        System.out.println(transactions);
        return transactions;


    }

}