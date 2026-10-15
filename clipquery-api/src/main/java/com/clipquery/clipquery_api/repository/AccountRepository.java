package com.clipquery.clipquery_api.repository;

import com.clipquery.clipquery_api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
