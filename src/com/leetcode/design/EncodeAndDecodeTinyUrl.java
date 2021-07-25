package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class EncodeAndDecodeTinyUrl {
    Map<String, String> map = new HashMap<>();
    java.util.Random rand = new java.util.Random();
    String url = "http://tinyurl.com/";
    char[] signs ={'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private String generateCode() {
        StringBuilder code = new StringBuilder();
        for (int idx = 0; idx < 6; idx++) {
            code.append(signs[rand.nextInt(signs.length)]);
        }
        return code.toString();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String result = null;
        do {
            String code = generateCode();
            if(!map.containsKey(code)) result = code;
        } while (result == null);
        map.put(result, longUrl);
        return url + result;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.substring(shortUrl.lastIndexOf('/') + 1);
        return map.getOrDefault(code, "");
    }
}
