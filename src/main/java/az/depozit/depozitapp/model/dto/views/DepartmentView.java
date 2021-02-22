package az.depozit.depozitapp.model.dto.views;

import az.depozit.depozitapp.db.entities.Employee;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentView {

    private long idDepartment;

    private String departmentName;

    private String departmentPhone;

    private List<Employee> employeeList;

}
