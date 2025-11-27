package com.leaveManager.Entity;

import com.leaveManager.constants.LeaveStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "leaves")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;
    @ManyToOne
    @JoinColumn(name = "reqBy")
    private User reqBy;

    @ManyToOne
    @JoinColumn(name = "approvedBy")
    private User approveBy;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
