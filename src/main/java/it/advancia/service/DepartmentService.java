package it.advancia.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

import it.advancia.dto.DepartmentDto;
import it.advancia.entity.Department;
import it.advancia.mapper.DepartmentMapper;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentMapper departmentMapper;

    public DepartmentDto getDepartment(Long id) {
        Optional<Department> optionalDepartment = Department.findByIdOptional(id);
        Department department = optionalDepartment.orElseThrow(NotFoundException::new);
        return departmentMapper.toDepartmentDto(department);
    }

    public List<DepartmentDto> getAllDepartments() {
        return departmentMapper.toDepartmentDtoList(Department.listAll());
    }

    @Transactional
    public DepartmentDto createDepartment(DepartmentDto department) {
    	
        Department entity = departmentMapper.toDepartmentEntity(department);
        Department.persist(entity);

        if(entity.isPersistent()) {
            Optional<Department> optionalDept = Department.findByIdOptional(entity.id);
            entity = optionalDept.orElseThrow(NotFoundException::new);
            return departmentMapper.toDepartmentDto(entity);
        } else {
            throw new PersistenceException();
        }

    }
}