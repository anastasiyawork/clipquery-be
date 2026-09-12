package com.clipquery.clipquery_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "thread_clips")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ThreadClip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clip_id")
    private Clip clip;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private ChatThread chatThread;
}
