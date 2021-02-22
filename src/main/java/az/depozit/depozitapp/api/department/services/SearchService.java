package az.depozit.depozitapp.api.department.services;

import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.db.services.department.DepartmentDbImpl;
import az.depozit.depozitapp.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service(value = "DepartmentSearchService")
public class SearchService {
    private final DepartmentDbImpl departmentDb;

    public Department getById(long idDepartment){
        return departmentDb.getById(idDepartment).orElseThrow(() -> new NotFoundException("Department not found..."));
    }


    public List<Department> getAll(){
        return departmentDb.getAll().orElseThrow(() -> new NotFoundException("Departments not found..."));
    }



}
