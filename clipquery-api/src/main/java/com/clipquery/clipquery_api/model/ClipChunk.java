package com.clipquery.clipquery_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clip_chunks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ClipChunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "clip_id", nullable = false)
    private Long clipId;

    @Column(name = "start_ms", nullable = false)
    private double startMs;

    @Column(name = "end_ms", nullable = false)
    private double endMs;

    @Column(name = "vector(1536)")
    private float[] embedding;

    @Column(name = "content")
    private String content;
}
