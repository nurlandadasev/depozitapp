package az.depozit.depozitapp.db.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployee",unique = true)
    @PositiveOrZero(message = "The field idEmployee cannot be negative")
    private long idEmployee;


    @NotBlank(message = "The name field cannot be empty.")
    @Size(min = 2,max = 10,message = "Name must be minimum 2 symbols and maximum 10 symbols")
    private String name;

    @NotBlank(message = "The surname field cannot be empty.")
    @Size(min = 2,max = 10,message = "Surname must be minimum 2 symbols and maximum 10 symbols")
    private String surname;

    @NotBlank(message = "The username field cannot be empty.")
    @Size(min = 2,max = 10,message = "Username must be minimum 2 symbols and maximum 10 symbols")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "The password field cannot be empty.")
    @Size(min = 5,max = 15,message = "Password must be minimum 5 symbols and maximum 15 symbols.")
    private String password;


    @NotBlank(message = "The phone field cannot be empty.")
    private String phone;

    @CreationTimestamp
    private LocalDateTime dateTime;



    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "idDepartment", referencedColumnName = "idDepartment")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Department department;


    @JsonIgnore
    public Department getDepartment() {
        return department;
    }

    @NotNull(message = "The field idDepart cannot be null...")
    @PositiveOrZero(message = "The field idDepart cannot be negative..")
    private long idDepart;


    private int age;

}
