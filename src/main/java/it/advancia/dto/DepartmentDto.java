package it.advancia.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import it.advancia.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentDto {

//	private BigInteger id;
    private String name;
    public List<Employee> employees = new ArrayList<>();
}
