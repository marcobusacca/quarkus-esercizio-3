package it.advancia.mapper;

import org.mapstruct.Mapper;

import it.advancia.dto.DepartmentDto;
import it.advancia.entity.Department;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface DepartmentMapper {
	
    DepartmentDto toDepartmentDto(Department department);
    
    List<DepartmentDto> toDepartmentDtoList(List<Department> departments);
    
    Department toDepartmentEntity(DepartmentDto departmentDto);
}
