package it.advancia.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import it.advancia.dto.EmployeeDto;
import it.advancia.entity.Department;
import it.advancia.service.EmployeeService;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService empService;

    @GET
    @Path("/{id}")
    public EmployeeDto getEmployee(@PathParam(value = "id") Long id) {
        return empService.getEmployee(id);
    }

    @GET
    @Path("/queryParam")
    public EmployeeDto getEmployeeById(@QueryParam(value = "id") Long id) {
        return empService.getEmployee(id);
    }

    @GET
    public List<EmployeeDto> getAllEmployees() {
        return empService.getAllEmployees();
    }


    @GET
    @Path("/dept/{id}")
    public List<EmployeeDto> getEmployeesByDepartment(@PathParam(value = "id") Long departmentId) {
        return empService.getEmployeesByDepartment(departmentId);
    }

    @GET
    @Path("/search/{name}")
    public List<EmployeeDto> searchEmpsByName(@PathParam(value = "name") String name) {

        return empService.searchEmpsByName(name);
    }

    @POST
    public EmployeeDto createEmployee(EmployeeDto employee) {
        return empService.createEmployee(employee);
    }

    @PUT
    @Path("/{id}")
    public EmployeeDto updateEmployee(@PathParam(value = "id") Long id, EmployeeDto employee) {

        if (employee.getFirst_name() == null || employee.getLast_name() == null) {
            throw new WebApplicationException("first_name or last_name was not set on request.", 422);
        }
        return empService.updateEmployee(id, employee);
    }

//    @PUT
//    public EmployeeDto updateEmployee(EmployeeDto employee) {
//
//        if (employee.getFirst_name() == null || employee.getLast_name() == null) {
//            throw new WebApplicationException("first_name or last_name was not set on request.", 422);
//        }
//        return empService.updateEmployee(employee);
//    }

    @PATCH
    @Path("/{id}/updateDept")
    public EmployeeDto updateEmpDepartmentById(@PathParam(value = "id") Long emp_id, Department department) {

        return  empService.updateEmpDepartment(emp_id,department);
    }

    @PATCH
    @Path("/{empId}/dept/{deptId}")
    public EmployeeDto updateEmpDepartment(@PathParam(value = "empId") Long emp_id ,@PathParam(value = "deptId") Long dept_id ) {

        return  empService.updateEmpDepartment(emp_id,dept_id);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam(value = "id") Long id) {
        return empService.deleteEmployee(id);
    }
}