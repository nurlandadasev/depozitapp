package az.depozit.depozitapp.db.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartment",unique = true)
    @PositiveOrZero(message = "The field idDepartment cannot be negative")
    private long idDepartment;

    @NotBlank(message = "The departmentName field cannot be empty. ")
    private String departmentName;

    @NotBlank(message = "The departmentPhone field cannot be empty. ")
    private String departmentPhone;


    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employeeList;




}
