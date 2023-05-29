package com.samsungsds.kdbito.bankingservice.service;

import java.util.List;
import java.util.Optional;

import com.samsungsds.kdbito.bankingservice.entity.Account;


public interface AccountService {
	
	    public List<Account> getAllAccounts() ;

	    public Optional<Account> getAccountById(Long id) ;

	    public Account saveAccount(Account account) ;

	    public void deleteAccountById(Long id);


}
