package az.depozit.depozitapp.model.dto.views;

import az.depozit.depozitapp.db.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private List<EmployeeView> employeeViews;
    private int pagesCount;



}
