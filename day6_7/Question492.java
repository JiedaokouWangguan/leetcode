public class Question492{
    public int[] constructRectangle(int area){
        int w = (int)Math.sqrt(area);
        while(area % w != 0)
            w -= 1;
        return new int[]{area/w, w};
    }
}
