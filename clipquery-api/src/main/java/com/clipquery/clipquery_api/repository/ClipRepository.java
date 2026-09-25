package com.clipquery.clipquery_api.repository;

import com.clipquery.clipquery_api.model.Clip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClipRepository extends JpaRepository<Clip, Long> {
}
