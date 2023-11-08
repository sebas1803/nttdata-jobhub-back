package com.nttdata.jobhub.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String dni;
    private String password;
    private String address;
    private String birthdate;
    @Column(columnDefinition = "boolean default false")
    private boolean isRemote;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_office",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private List<Office> offices; //Es mejor usar set
}
