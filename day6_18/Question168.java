public class Question168{
    public String convertToTitle(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        String result = sb.reverse().toString();
        return result;
    }
}
