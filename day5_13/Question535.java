package leetcode.day5_13;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Song on 2018/5/13.
 */
public class Question535
{
    HashMap<String, String> short2Long = new HashMap<>();
    Random random = new Random();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String result = null;
        while (true)
        {
            String tmp = getString();
            if (!short2Long.containsKey(tmp))
            {
                short2Long.put(tmp, longUrl);
                result = tmp;
                break;
            }
        }
        return result;
    }

    private String getString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<6;i++)
        {
            int tmp = random.nextInt(62);
            if (tmp >=0 && tmp < 26)
            {
                sb.append((char)(tmp+'a'));
            }
            else if(tmp >= 26 && tmp < 52)
            {
                sb.append((char)(tmp - 26 + 'A'));
            }
            else
            {
                sb.append((char)(tmp - 52 + '0'));
            }
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (short2Long.containsKey(shortUrl))
            return short2Long.get(shortUrl);
        else
            return null;
    }
}
