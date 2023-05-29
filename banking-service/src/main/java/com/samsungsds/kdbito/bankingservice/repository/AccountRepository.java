package com.samsungsds.kdbito.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samsungsds.kdbito.bankingservice.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

