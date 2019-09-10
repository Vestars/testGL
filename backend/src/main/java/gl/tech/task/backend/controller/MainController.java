package gl.tech.task.backend.controller;

import gl.tech.task.backend.db.Employee;
import gl.tech.task.backend.service.EmployeeService;
import gl.tech.task.backend.utility.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Pageable<Employee> getEmployees(@RequestParam(value = "page", defaultValue = "1") int page,
                                           @RequestParam(value = "size", defaultValue = "5") int size) {
        return Pageable.buildPageableResponse(employeeService.getEmployees(page, size));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id")
                                                    @Positive(message = "Id must be greater than zero") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
}
