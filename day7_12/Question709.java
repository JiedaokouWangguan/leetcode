public class Question709{
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
