package com.example.demo.Entity;

import com.example.demo.Entity.Limits.UserFieldLimits;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "user")
public class User implements UserFieldLimits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "user_id")
    private Long user_id;

   // @Column(name = "Name", nullable = false, unique = true, length = NAME_DB_LENGTH)
    private String name;

    //@Column(name = "Email", nullable = false, unique = true, length = EMAIL_DB_LENGTH)
    private String email;

    //@Column(name = "Password", nullable = false, length = PASSWORD_DB_LENGTH)
    private String password;

    //@Column(name = "Active")
    private Boolean active;


    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Profile profile;



    @ManyToOne
    @JoinColumn(name = "fk_school_id")
    @JsonIgnoreProperties("usersList")
    private School school;


    @ManyToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "user_certifications",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "certification_id")
    )
    private List <Certifications> certificationsList=new ArrayList<>();
}
