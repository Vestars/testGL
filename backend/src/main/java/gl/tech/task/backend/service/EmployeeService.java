package gl.tech.task.backend.service;

import gl.tech.task.backend.db.Employee;
import gl.tech.task.backend.exception.EmployeeNotFoundException;
import gl.tech.task.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployees(int page, int size){
        return employeeRepository.findAll(PageRequest.of(page - 1, size,
                Sort.by(Sort.Direction.ASC,"id")));
    }

    public Employee getEmployeeById(Long id){
        final Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by current id: " + id));
        return employee;
    }
}
