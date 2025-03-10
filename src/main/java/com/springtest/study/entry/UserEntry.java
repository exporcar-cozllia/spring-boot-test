package com.springtest.study.entry;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.SpringApplication;

@Entity
@Table(name = "td_member")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
}
