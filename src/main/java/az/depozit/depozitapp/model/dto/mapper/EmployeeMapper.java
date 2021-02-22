package az.depozit.depozitapp.model.dto.mapper;

import az.depozit.depozitapp.db.entities.Employee;
import az.depozit.depozitapp.model.dto.views.EmployeeView;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EmployeeMapper {

    public static final EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    public abstract EmployeeView mapToEmployeeView(Employee employee);

    public abstract List<EmployeeView> mapEmployeesToViews(List<Employee> employeeList);




}
