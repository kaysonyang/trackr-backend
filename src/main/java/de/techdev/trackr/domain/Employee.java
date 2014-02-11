package de.techdev.trackr.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Moritz Schulze
 */
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private boolean active;

    @OneToMany
    private List<Authority> authorities;
}
