package az.depozit.depozitapp.db.repo;

import az.depozit.depozitapp.db.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepoDepartment extends JpaRepository<Department,Long> {

    Optional<List<Department>> findAllBy();



}
