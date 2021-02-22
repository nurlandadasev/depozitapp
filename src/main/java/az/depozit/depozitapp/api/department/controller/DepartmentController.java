package az.depozit.depozitapp.api.department.controller;


import az.depozit.depozitapp.api.department.services.SearchService;
import az.depozit.depozitapp.api.department.services.CrudService;
import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.model.dto.views.DepartmentView;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final CrudService crudService;
    private final SearchService searchService;


    @GetMapping("/{id}")
    public Department getById(@PathVariable long id){
        return searchService.getById(id);
    }



    @GetMapping
    public List<Department> getAll(){
        return searchService.getAll();
    }






    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Department save(@Valid @RequestBody Department department){
        return crudService.save(department);
    }

    @PutMapping
    public Department update(@Valid @RequestBody Department department){
        return crudService.update(department);
    }

    @DeleteMapping
    public void delete(@Valid @RequestBody Department department){
         crudService.delete(department);
    }



}
