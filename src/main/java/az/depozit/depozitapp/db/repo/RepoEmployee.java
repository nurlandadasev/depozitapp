package az.depozit.depozitapp.db.repo;

import az.depozit.depozitapp.db.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepoEmployee extends JpaRepository<Employee,Long> {

    Optional<List<Employee>> findAllBy();




}
