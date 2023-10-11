package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "user_id")
    private Long school_id;

    // @Column(name = "Name", nullable = false, unique = true, length = NAME_DB_LENGTH)
    private String name;

    //@Column(name = "Email", nullable = false, unique = true, length = EMAIL_DB_LENGTH)
    private String cp;



    @OneToMany(mappedBy = "school")
    @JsonIgnoreProperties({"school","profile"})
    private List<User> usersList= new ArrayList<>();



}
