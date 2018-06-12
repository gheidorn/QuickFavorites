package quickfavorites;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * FavoritesRepository
 */
@Repository
public interface FavoritesRepository extends CrudRepository<Favorites, String> {

}