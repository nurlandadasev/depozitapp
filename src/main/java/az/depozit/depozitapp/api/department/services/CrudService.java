package az.depozit.depozitapp.api.department.services;

import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.db.services.department.DepartmentDbImpl;
import az.depozit.depozitapp.exceptions.NotFoundException;
import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service(value = "DepartmentCrudService")
public class CrudService {

    private final DepartmentDbImpl departmentDb;


    public Department save(Department department){
        log.info("DepartmentView: {}",department);
        if (!department.getEmployeeList().isEmpty()) {
            department.getEmployeeList().forEach(employee -> employee.setDepartment(department));
        }
        return departmentDb.save(department).orElseThrow(() -> new InternalException("Department saving error please contact technical support"));
    }


    public Department update(Department department){
        return departmentDb.update(department)
                .orElseThrow(() -> new NotFoundException(String.format("Department not found by this idDepartment: %d",department.getIdDepartment())));
    }


    public void delete(Department department){
        departmentDb.getById(department.getIdDepartment())
                .orElseThrow(() ->new NotFoundException(String.format("Department not found by this id: %d for update...",department.getIdDepartment())));
        departmentDb.delete(department);
    }


}
