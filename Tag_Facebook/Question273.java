public class Question273{
    
    String[] twenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] thousand = new String[]{"", "Thousand", "Million", "Billion"};
    String[] hundred = new String[]{"Twenty", "Thirty", "Forty", "Fiffy", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        String result = "";
        while(num > 0){
            result = helper(num % 1000) + " " + thousand[i++];
            num /= 1000;
        }
        return result.trim();
    }

    private String helper(int num){
        if(num < 20){
            return twenty[num];
        }
        else if(num < 100){
            int tmp = num/10;
            return hundred[num-2] + " " + twenty[num%10];
        }
        else{
            int n1 = num/100;
            return twenty[num/100] + " Hundred " + helper(num%100);
        }
    }
}
