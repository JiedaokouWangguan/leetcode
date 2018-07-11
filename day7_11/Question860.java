public class Question860{
    public boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        for(int bill : bills){
            if(bill == 5) num5 += 1;
            else if(bill == 10){
                if(num5 < 1)
                    return false;
                num5 -= 1;
                num10 += 1;
            }
            else{
                if(num5 >= 1 && num10 >= 1){
                    num5 -= 1;
                    num10 -= 1;
                }
                else if(num5 >= 3 ) num5 -= 3;
                else return false;
            }
        }
        return true;
    }
}
