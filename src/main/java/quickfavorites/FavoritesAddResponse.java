package quickfavorites;

public class FavoritesAddResponse {
    private Favorites favorties;
    private String resourcePath;

    public FavoritesAddResponse(Favorites favorites, String resourcePath) {
        this.favorties = favorites;
        this.resourcePath = resourcePath;
    }

    /**
     * @return the resourcePath
     */
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     * @param resourcePath the resourcePath to set
     */
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * @return the favorties
     */
    public Favorites getFavorties() {
        return favorties;
    }

    /**
     * @param favorties the favorties to set
     */
    public void setFavorties(Favorites favorties) {
        this.favorties = favorties;
    }
}