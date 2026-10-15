package com.clipquery.clipquery_api.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "outbox")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OutboxTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "sent_status")
    private String sent_status;

    @Column(name = "payload")
    @JdbcTypeCode(SqlTypes.JSON)
    private String payload;

    @Column(name = "attempt_count")
    private Long attemptCount;

    @Column(name = "next_attempt_sent_at")
    private LocalDateTime nextAttemptSentAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;
}
