package recipes.businesslayer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    private static final String emailRegexp = "^\\w+[@]\\w+[.]\\w{2,}";

    @Id
    @Email(regexp = emailRegexp)
    @NotNull
    private String email;

    @NotBlank
    @Size(min=8)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;

}
