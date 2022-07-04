package ch.bbw.persons.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2, max=30, message="Der Vorname muss zwischen 2 und 30 Zeichen lang sein.")
    private String firstname;

    @NotNull
    @Size(min=2, max=30, message="Der Nachname muss zwischen 2 und 30 Zeichen lang sein.")
    private String lastname;

    @NotNull
    @Email(message = "Es muss eine gültige Email Adresse sein.")
    private String email;

    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Das Geburtsdatum muss in der Vergangenheit liegen.")
    private Date birthdate;

    @NotNull
    @Size(min=1, max=1, message = "Es muss ein Geschlecht gewählt werden.")
    @Pattern(regexp="[MmfF]")
    private String gender;
}
