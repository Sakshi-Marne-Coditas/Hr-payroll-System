package com.leaveManager.Entity;

import com.leaveManager.constants.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    private String designation;

    private String email;

    private double salary;

    private UserStatus userStatus;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqBy")
    private List<Leave> leaves = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paySlipOf")
    private List<PaySlip> slips = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}
