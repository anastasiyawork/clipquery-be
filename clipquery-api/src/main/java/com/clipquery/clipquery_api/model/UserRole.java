package com.clipquery.clipquery_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_roles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserRole {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

}
