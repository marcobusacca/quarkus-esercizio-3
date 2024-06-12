package it.advancia.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import it.advancia.entity.Department;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {

    private Long id;
    private String first_name;
    private String last_name;
    private String gender;
    private LocalDate birth_date;
    private LocalDate hire_date;
    public Department department;
}