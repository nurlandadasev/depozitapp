package az.depozit.depozitapp.api.employee.services;

import az.depozit.depozitapp.db.entities.Employee;
import az.depozit.depozitapp.db.services.employee.EmployeeDbImpl;
import az.depozit.depozitapp.exceptions.NotFoundException;
import az.depozit.depozitapp.model.dto.mapper.EmployeeMapper;
import az.depozit.depozitapp.model.dto.views.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service(value = "EmployeeSearchService")
public class SearchService {

    private final EmployeeDbImpl employeeDb;


    public EmployeeDto getAllWithFiltration(String name, String surname,
                                            String phoneNumber, String username,
                                            LocalDate startDate, LocalDate finishDate,
                                            int pageNumber, int pageSize) {
        return employeeDb.getAllWithFiltration(name, surname, phoneNumber, username, startDate, finishDate)
                .map(employeeTypedQuery -> createEmployeeDto(employeeTypedQuery, pageNumber, pageSize))
                .orElseThrow(() -> new NotFoundException("Employees not found by this filters.."));
    }


    private EmployeeDto createEmployeeDto(TypedQuery<Employee> typedQuery, int pageNumber, int pageSize) {
        return EmployeeDto.builder()
                .pagesCount(getPagesCount(typedQuery.getResultList(), pageSize))
                .employeeViews(EmployeeMapper.INSTANCE.mapEmployeesToViews(getOrderListByTypedQueryWithPages(typedQuery, pageNumber, pageSize)))
                .build();
    }


    private List<Employee> getOrderListByTypedQueryWithPages(TypedQuery<Employee> typedQuery, int pageNumber, int pageSize) {
        return typedQuery.setFirstResult((pageNumber - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }


    private int getPagesCount(List<Employee> employeeList, int pageSize) {
        if (employeeList.isEmpty()) throw new NotFoundException("Employees not found...");
        double i = (double) employeeList.size() / (double) pageSize;
        return (int) Math.ceil(i);
    }

    public Employee getById(long idEmployee) {
        return employeeDb.getById(idEmployee)
                .orElseThrow(() -> new NotFoundException(String.format("Employee not found by this idEmployee: %d", idEmployee)));
    }


}
