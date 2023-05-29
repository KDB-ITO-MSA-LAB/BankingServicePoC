package com.samsungsds.kdbito.bankingservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.samsungsds.kdbito.bankingservice.entity.Account;
import com.samsungsds.kdbito.bankingservice.repository.AccountRepository;
import com.samsungsds.kdbito.bankingservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
    private final AccountRepository accountRepository;
	
	
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account saveAccount(Account book) {
        return accountRepository.save(book);
    }

    public void deleteAccountById(Long id) {
    	accountRepository.deleteById(id);
    }


}
