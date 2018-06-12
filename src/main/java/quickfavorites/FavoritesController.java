package quickfavorites;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoritesController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private FavoritesRepository favoritesRepository;

    @RequestMapping("/ping")
    public String ping() {
        return "ping";
    }

    @RequestMapping("/favorites")
    public List<Favorites> favorites() {
        List<Favorites> favorites = new ArrayList<>();
        favoritesRepository.findAll().forEach(favorites::add);
        return favorites;
    }

    @Cacheable({ "favorites" })
    @RequestMapping("/favorites/cacheable")
    public List<Favorites> favoritesCacheable() {
        List<Favorites> favorites = new ArrayList<>();
        favoritesRepository.findAll().forEach(favorites::add);
        return favorites;
    }

    @RequestMapping("/favorites/add")
    public FavoritesAddResponse add(@RequestParam(value = "email", defaultValue = "default@email.com") String email,
            @RequestParam(value = "cubsPlayer", defaultValue = "Ernie Banks") String cubsPlayer,
            @RequestParam(value = "gameOfThronesSeason") int gameOfThronesSeason) {
        // add a favorites object to the cache
        Favorites favorites = new Favorites(counter.incrementAndGet(), email, cubsPlayer, gameOfThronesSeason);
        favoritesRepository.save(favorites);
        return new FavoritesAddResponse(favorites, "http://localhost:8080/favorites");
    }
}