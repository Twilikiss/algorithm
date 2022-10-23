package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * https://leetcode.com/problems/design-tinyurl
 * @author mlp52
 *
 */

public class TinyURL的加密与解密 {
	
	Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	String[] iStrings = longUrl.split("/");
    	
    	String p1 = iStrings[iStrings.length - 1];
    	
    	UUID p2 = UUID.randomUUID();
    	String outString = p1 + "/" + p2.toString();
    	
    	map.put(p2.toString(), longUrl);
    	
    	return outString;
    	
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] iStrings = shortUrl.split("/");
        
        String indexString = iStrings[iStrings.length - 1];
        
        String outString = map.get(indexString);
        
        return outString;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
