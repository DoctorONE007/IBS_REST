package com.ibs.service.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "month_salary")
    private Integer monthSalary;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "employee_course", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "boss_id")
    private Employee boss;

    public Employee(Long id, String firstName, String lastName, LocalDate birthday, Department department, Integer monthSalary, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.department = department;
        this.monthSalary = monthSalary;
        this.courses = courses;
    }
}
