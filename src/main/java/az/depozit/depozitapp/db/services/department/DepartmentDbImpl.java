package az.depozit.depozitapp.db.services.department;

import az.depozit.depozitapp.db.entities.Department;
import az.depozit.depozitapp.db.repo.RepoDepartment;
import az.depozit.depozitapp.db.services.DataBaseServices;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository(value = "DepartmentDb")
public class DepartmentDbImpl implements DataBaseServices<Department,Long> {

    private final RepoDepartment repoDepartment;

    public DepartmentDbImpl(RepoDepartment repoDepartment) {
        this.repoDepartment = repoDepartment;
    }


    @Override
    public Optional<Department> getById(Long aLong) {
        return repoDepartment.findById(aLong);
    }

    @Override
    public Optional<List<Department>> getAll() {
        return repoDepartment.findAllBy();
    }

    @Override
    public Optional<Department> save(Department department) {
        return Optional.of(repoDepartment.save(department));
    }

    @Override
    public Optional<Department> update(Department department) {
        return repoDepartment.findById(department.getIdDepartment())
                .map(d -> repoDepartment.save(department));
    }

    @Override
    public void delete(Department department) {
         repoDepartment.delete(department);
    }
}
