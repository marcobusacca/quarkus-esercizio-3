package it.advancia.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import it.advancia.dto.DepartmentDto;
import it.advancia.service.DepartmentService;

@Path("/department")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;

    @GET
    @Path("/{id}")
    public DepartmentDto getDepartment(@PathParam(value = "id") Long id) {
        return departmentService.getDepartment(id);
    }

    @GET
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @POST
    public DepartmentDto createEmployee(DepartmentDto department) {
        return departmentService.createDepartment(department);
    }

}
