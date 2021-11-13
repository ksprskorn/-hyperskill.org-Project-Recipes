package recipes.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name="recipeID")
    private Long id;

    @NotBlank
    @Column(name="recipeName")
    private String name;

    @NotBlank
    private String description;

    @LastModifiedDate
    private LocalDateTime date;

    @NotBlank
    private String category;

    @NotEmpty
    @ElementCollection
    @Column(name = "ingredients")
    private List<String> ingredients = new ArrayList<>();

    @NotEmpty
    @ElementCollection
    @Column(name = "directions")
    private List<String> directions = new ArrayList<>();

    @CreatedBy
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userID")
    private User user;
}
