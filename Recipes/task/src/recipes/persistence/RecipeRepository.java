package recipes.persistence;

import recipes.businesslayer.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.businesslayer.User;

import java.util.List;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Recipe findRecipeById(Long id);
    Recipe findRecipeByIdAndAndUser(Long id, User user);
    void deleteById(Long id);

    List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);
    List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);
    List<Recipe> findAllByNameContainingIgnoreCaseAndCategoryIgnoreCaseOrderByDateDesc(String name, String category);

}

