import java.util.HashMap;
import java.util.Map;

 class LinkShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;

     LinkShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
    }

     String shorten(String longUrl) {
        String shortUrl = generateShortUrl(longUrl);
        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);
        return shortUrl;
    }

     String expand(String shortUrl) {
        return shortToLongMap.getOrDefault(shortUrl, "Short URL not found");
    }

     boolean containsShortUrl(String shortUrl) {
        return shortToLongMap.containsKey(shortUrl);
    }

     boolean containsLongUrl(String longUrl) {
        return longToShortMap.containsKey(longUrl);
    }

     void handleDuplicateMapping(String longUrl) {
        if (containsLongUrl(longUrl)) {
            String shortUrl = longToShortMap.get(longUrl);
            System.out.println("Shortened URL already exists for the given long URL: " + shortUrl);
        }
    }

     String generateShortUrl(String longUrl) 
    {
        return "short/" + longUrl.substring(longUrl.length() - 5);
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        String longUrl = "www.youtube.com";
        String shortUrl = linkShortener.shorten(longUrl);
        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Expanded URL: " + linkShortener.expand(shortUrl));
    }
}
