package az.depozit.depozitapp.model.dto.views;

import az.depozit.depozitapp.db.entities.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeView {

    private long idEmployee;
    @JsonIgnore
    private long idDepartment;


    private String name;
    private String surname;

    private String username;

    private String password;

    private String phone;

    private LocalDateTime dateTime;

    private int age;


}
