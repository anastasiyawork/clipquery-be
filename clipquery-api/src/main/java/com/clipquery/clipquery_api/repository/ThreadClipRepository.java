package com.clipquery.clipquery_api.repository;

import com.clipquery.clipquery_api.model.ThreadClip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadClipRepository extends JpaRepository<ThreadClip, Long> {
}
