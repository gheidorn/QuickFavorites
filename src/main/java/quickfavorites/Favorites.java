package quickfavorites;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(timeToLive = 60 * 1000)
public class Favorites implements Serializable {

    private static final long serialVersionUID = 2822107912104570558L;

    private final long id;
    private final String email;
    private final String cubsPlayer;
    private final int gameOfThronesSeason;

    public Favorites(long id, String email, String cubsPlayer, int gameOfThronesSeason) {
        this.id = id;
        this.email = email;
        this.cubsPlayer = cubsPlayer;
        this.gameOfThronesSeason = gameOfThronesSeason;
    }

    public long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCubsPlayer() {
        return this.cubsPlayer;
    }

    public int getGameOfThronesSeason() {
        return this.gameOfThronesSeason;
    }
}