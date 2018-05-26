public class Question812{
    public double largestTriangleArea(int[][] points)
    {
        double maxArea = 0;
        int len = points.length;
        double a = 0;
        double b = 0;
        double c = 0;
        double S = 0;
        for(int i = 0;i<len;i++)
        {
            for(int j = i+1;j < len;j++)
            {
                for(int k = j + 1;k<len;k++)
                {
                    a = euclideanDistance(points[i], points[j]);
                    a = euclideanDistance(points[i], points[k]);
                    a = euclideanDistance(points[k], points[j]);
                    if(isValidTriangle(a,b,c))
                    {
                        S = (a + b + c) /2;
                        maxArea = Math.max(maxArea, Math.sqrt(S * (S-a) * (S-b) * (S-c)));
                    }   
                }
            }
        }
        return maxArea;
    }

    private double euclideanDistance(int[] p1, int[] p2)
    {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return Math.sqrt(x * x + y * y);
    }

    private boolean isValidTriangle(double a, double b, double c)
    {
        return a + b > c && b + c > a && a + c > b;
    }

}
