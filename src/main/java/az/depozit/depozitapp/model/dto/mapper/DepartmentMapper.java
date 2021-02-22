package az.depozit.depozitapp.model.dto.mapper;

import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.db.entities.Employee;
import az.depozit.depozitapp.model.dto.views.DepartmentView;
import az.depozit.depozitapp.model.dto.views.EmployeeView;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DepartmentMapper {
    public static final DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);


    public abstract DepartmentView mapToDepartmentView(Department department);

    public abstract Department mapToDepartment(DepartmentView departmentView);

    public abstract List<DepartmentView> mapDepartmentsToViews(List<Department> department);


}
