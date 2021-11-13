package recipes.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import recipes.businesslayer.Recipe;
import recipes.businesslayer.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.businesslayer.User;


import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping("/api/recipe/new")
    public Map<String, Long> saveRecipe(@Valid @RequestBody Recipe recipe,
                                        @AuthenticationPrincipal UserDetails details) {
        User authUser = new User();
        authUser.setEmail(details.getUsername());
        authUser.setPassword(details.getPassword());

        recipe.setUser(authUser);
        recipe.setDate(LocalDateTime.now());

        Recipe recipeCreate = recipeService.save(recipe);
        return Map.of("id", recipeCreate.getId());
    }

    @PutMapping("/api/recipe/{id}")
    public void updateRecipe(@Valid @RequestBody Recipe recipe,
                             @PathVariable Long id,
                             @AuthenticationPrincipal UserDetails details) {
        User authUser = new User();
        authUser.setEmail(details.getUsername());
        authUser.setPassword(details.getPassword());

        Recipe recipeById = recipeService.findRecipeById(id);
        Recipe recipeToUpdate = recipeService.findRecipeByIdAndAndUser(id, authUser);
        if (recipeById == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else if (recipeToUpdate == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else {
            recipeToUpdate.setId(id);
            recipeToUpdate.setName(recipe.getName());
            recipeToUpdate.setDescription(recipe.getDescription());
            recipeToUpdate.setDate(LocalDateTime.now());
            recipeToUpdate.setCategory(recipe.getCategory());
            recipeToUpdate.setIngredients(recipe.getIngredients());
            recipeToUpdate.setDirections(recipe.getDirections());
            recipeService.save(recipeToUpdate);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipes(@PathVariable Long id) {
        Recipe recipe = recipeService.findRecipeById(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe;
    }

    @DeleteMapping("/api/recipe/{id}")
    public void deleteRecipes(@PathVariable Long id,
                              @AuthenticationPrincipal UserDetails details) {
        User authUser = new User();
        authUser.setEmail(details.getUsername());
        authUser.setPassword(details.getPassword());

        Recipe recipe = recipeService.findRecipeById(id);
        Recipe recipeByUser = recipeService.findRecipeByIdAndAndUser(id, authUser);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else if (recipeByUser == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } else {
            recipeService.deleteRecipeById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/recipe/search")
    public ResponseEntity<List<Recipe>> search(@RequestParam(required = false) String name,
                                               @RequestParam(required = false) String category) {
        if (name == null && category == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Recipe> result;
        if (name == null) {
            result = recipeService.searchByCategory(category);
        } else if (category == null) {
            result = recipeService.searchByName(name);
        } else {
            result = recipeService.searchByNameAndCategory(name, category);
        }
        return ResponseEntity.ok(result);
    }
}
