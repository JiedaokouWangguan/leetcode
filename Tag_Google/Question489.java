import java.util.HashSet;

public class Question489{
    // 5.03 - 5.22, 20mins
    HashSet<String> visited = new HashSet<>();
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);    
    }
    
    int[][] delta = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private void dfs(Robot robot, int row, int col, int dir){
        String key = row+","+col;
        visited.add(key);
        robot.clean();
        for(int i = dir;i<4+dir;i++){
            int newRow = row + delta[i%4][0];
            int newCol = col + delta[i%4][1];
            String tmpKey = newRow + "," + newCol;
            if(!visited.contains(tmpKey)){
                if(robot.move()){
                    dfs(robot, newRow, newCol, i%4);
                    robot.turnLeft();
                    robot.turnLeft();
                    robot.move();
                    robot.turnLeft();
                    robot.turnLeft();
                }
            }
            robot.turnRight();
        }
    }




}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}
