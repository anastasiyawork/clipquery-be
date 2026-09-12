package com.clipquery.clipquery_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "statuses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Status {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;
}
