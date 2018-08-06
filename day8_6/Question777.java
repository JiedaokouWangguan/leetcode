public class Question777{
    public boolean canTransform(String start, String end) {
        int result = 0;
        char[] st = start.toCharArray();
        char[] en = end.toCharArray();
        int index1 = 0;
        int index2 = 0;
        while(index1 < st.length && index2 < en.length){
            while(index1 < st.length && st[index1] == 'X') index1 += 1;
            while(index2 < en.length && en[index2] == 'X') index2 += 1;
            if(index1 == st.length && index2 == en.length) return true;
            if(index1 == st.length || index2 == en.length) return false;
            if(st[index1] != en[index2]) return false;
            if(st[index1] == 'L' && index2 > index1) return false;
            if(st[index1] == 'R' && index2 < index1) return false;
            index1 += 1;
            index2 += 1;
        }
        return true;
    }
}
