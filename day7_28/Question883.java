class Solution{
    double radius;
    double x_center;
    double y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double rad = Math.random() * Math.PI * 2;
        double new_x = x_center + len * Math.cos(rad);
        double new_y = y_center + len * Math.sin(rad);
        return new double[]{new_x, new_y};
    }
}
