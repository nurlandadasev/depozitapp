package az.depozit.depozitapp.api.employee.services;


import az.depozit.depozitapp.api.department.services.SearchService;
import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.db.entities.Employee;
import az.depozit.depozitapp.db.services.employee.EmployeeDbImpl;
import az.depozit.depozitapp.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service(value = "EmployeeCrudService")
public class CrudService {

    private final EmployeeDbImpl employeeDb;
    private final SearchService searchServiceDep;



    public Employee save(Employee employee) {
        Department byId = searchServiceDep.getById(employee.getIdDepart());
        employee.setDepartment(byId);
        return employeeDb.save(employee)
                .orElseThrow(() -> new InternalError("Employee saving error please contact technical support"));
    }

    public Employee update(Employee employee) {
        return employeeDb.update(employee)
                .orElseThrow(() -> new NotFoundException(String.format("Employee not found by this idEmployee: %s", employee.getIdEmployee())));
    }


    public void delete(Employee employee) {
        log.info("employee : {}",employee);
        employeeDb.getById(employee.getIdEmployee()).orElseThrow(() -> new NotFoundException("Employee not found for delete."));
        employeeDb.delete(employee);
    }

}
