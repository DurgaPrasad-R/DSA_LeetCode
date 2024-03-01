public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String res = "";
        int n = longUrl.length();
        for(int i=0;i<n;i++){
            res+=(char)(longUrl.charAt(i)+1);
        }
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String res = "";
        int n = shortUrl.length();
        for(int i = 0;i<n;i++){
            res+=(char)(shortUrl.charAt(i)-1);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));