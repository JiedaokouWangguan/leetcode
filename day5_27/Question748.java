public class Question748{
    public String shortestCompletingWord(String licensePlate, String[] words)
    {
        licensePlate = licensePlate.toLowerCase();
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        
        int[] charMap = new int[26];
        for(int i = 0 ;i<licensePlate.length();i++)
        {
            if(!Character.isLetter(licensePlate.charAt(i)))
                continue;
            charMap[licensePlate.charAt(i) - 'a'] += 1;
        }

        for(int i = 0;i<words.length;i++)
        {
            if(match(charMap, words[i]))
            {
                if(words[i].length() < minLength)
                {
                    minLength = words[i].length();
                    minIndex = i;
                }
            }
        }

        return words[minIndex];
    }

    private boolean match(int[] charMap, String word)
    {
        int[] wordMap = new int[26];
        word = word.toLowerCase();
        char[] cArray = word.toCharArray();
        for(int i = 0;i<cArray.length;i++)
        {
            if(!Character.isLetter(cArray[i]))
                continue;
            wordMap[cArray[i] - 'a'] += 1;
        }
        for(int i = 0;i<26;i++)
        {
            if(wordMap[i] < charMap[i])
                return false;
        }
        return true;
    }

}
