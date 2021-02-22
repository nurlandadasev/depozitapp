package az.depozit.depozitapp.db.services.employee;

import az.depozit.depozitapp.db.entities.Employee;
import az.depozit.depozitapp.db.repo.RepoEmployee;
import az.depozit.depozitapp.db.services.DataBaseServices;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository(value = "EmployeeDb")
public class EmployeeDbImpl implements DataBaseServices<Employee,Long> {

    private final RepoEmployee repoEmployee;
    private final EntityManager em;

    public EmployeeDbImpl(RepoEmployee repoEmployee, EntityManager em) {
        this.repoEmployee = repoEmployee;
        this.em = em;
    }


    @Override
    public Optional<Employee> getById(Long aLong) {
        return repoEmployee.findById(aLong);
    }

    @Override
    public Optional<List<Employee>> getAll() {
        return repoEmployee.findAllBy();
    }

    @Override
    public Optional<Employee> save(Employee employee) {
        return Optional.of(repoEmployee.save(employee));
    }

    @Override
    public Optional<Employee> update(Employee employee) {
        return repoEmployee.findById(employee.getIdEmployee())
                .map(e -> repoEmployee.save(employee));
    }

    @Override
    public void delete(Employee employee) {
        repoEmployee.delete(employee);
    }



    public Optional<TypedQuery<Employee>> getAllWithFiltration(String name, String surname,
                                                               String phoneNumber, String username,
                                                               LocalDate startDate, LocalDate finishDate){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);

        List<Predicate> predicateList = new ArrayList<>();


        if (name != null && !name.isBlank())
            predicateList.add(cb.like(root.get("name"),"%"+name+"%"));

        if (surname != null && !surname.isBlank())
            predicateList.add(cb.like(root.get("surname"),"%"+surname+"%"));

        if (phoneNumber != null && !phoneNumber.isBlank())
            predicateList.add(cb.like(root.get("phone"),"%"+phoneNumber+"%"));

        if (username != null && !username.isBlank())
            predicateList.add(cb.like(root.get("username"),"%"+username+"%"));

        if (startDate != null && finishDate != null)
            predicateList.add(cb.between(root.<LocalDateTime>get("dateTime"), startDate.atStartOfDay(), finishDate.atTime(23, 59, 59)));


        cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

        cq.orderBy(cb.desc(root.get("dateTime")));

        return Optional.of(em.createQuery(cq));
    }




}
