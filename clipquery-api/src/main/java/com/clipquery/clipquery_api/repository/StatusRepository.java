package com.clipquery.clipquery_api.repository;

import com.clipquery.clipquery_api.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {
}
