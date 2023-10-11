package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "certifications")
public class Certifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "user_id")
    private Long certification_id;

    // @Column(name = "Name", nullable = false, unique = true, length = NAME_DB_LENGTH)
    private String name;

    //@Column(name = "Email", nullable = false, unique = true, length = EMAIL_DB_LENGTH)
    private String description;

    //@Column(name = "Password", nullable = false, length = PASSWORD_DB_LENGTH)
    private String date;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                fetch = FetchType.EAGER,
                mappedBy = "certificationsList")
    @JsonIgnoreProperties({"school","profile"})
    private List<User> usersList=new ArrayList<>();


}
