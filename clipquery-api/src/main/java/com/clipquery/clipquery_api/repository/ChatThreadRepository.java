package com.clipquery.clipquery_api.repository;

import com.clipquery.clipquery_api.model.ChatThread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatThreadRepository extends JpaRepository<ChatThread, Long> {
}
