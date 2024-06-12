package it.advancia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import it.advancia.dto.EmployeeDto;
import it.advancia.entity.Employee;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface EmployeeMapper {
	
    EmployeeDto toEmployeeDto(Employee employee);
    
    Employee toEmployeeEntity(EmployeeDto dto);
    
    List<EmployeeDto> toEmployeeList(List<Employee> employee);
    
    void updateEmployeeEntityFromDto(EmployeeDto dto, @MappingTarget Employee employee);
}
