package az.depozit.depozitapp.api.employee.controller;

import az.depozit.depozitapp.api.employee.services.CrudService;
import az.depozit.depozitapp.api.employee.services.SearchService;
import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.db.entities.Employee;
import az.depozit.depozitapp.model.dto.views.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final CrudService crudService;
    private final SearchService searchService;




    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee save(@Valid @RequestBody Employee employee){
        return crudService.save(employee);
    }



    @PutMapping
    public Employee update(@Valid @RequestBody Employee employee){
        return crudService.update(employee);
    }


    @DeleteMapping
    public void delete(@RequestBody Employee employee){
         crudService.delete(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable long id){
        return searchService.getById(id);
    }


    @GetMapping
    public EmployeeDto getAllEmployeesWithFilter(@RequestParam(required = false) String name, @RequestParam(required = false) String surname,
                                                 @RequestParam(required = false) String phoneNumber, @RequestParam(required = false) String username,
                                                 @RequestParam(required = false)LocalDate startDate,@RequestParam(required = false) LocalDate finishDate,
                                                 @RequestParam(required = false, defaultValue = "1") int pageNumber, @RequestParam(required = false, defaultValue = "10") int pageSize){
        return searchService.getAllWithFiltration(name,surname,phoneNumber,username,startDate,finishDate,pageNumber,pageSize);
    }





}
