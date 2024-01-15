import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MazeSolver extends JFrame {
    private int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    public ArrayList<Integer> path = new ArrayList<>();
    public  MazeSolver(){
        setTitle("Maze Solver");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchDepth(maze,1,1,path);
//        System.out.println(path);

    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i = 0;i < maze.length;i++){
            for(int j = 0;j<maze[0].length;j++){
                Color color = switch (maze[i][j]) {
                    case 1 -> Color.BLACK;
                    case 9 -> Color.RED;
                    default -> Color.WHITE;
                };
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i =0;i<path.size();i+=2){
            int pathX = path.get(i);
            int pathY = path.get(i+1);

            g.setColor(Color.GREEN);
            g.fillRect(30*pathX,30*pathY,25,25);
        }
    }

    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.setVisible(true);
    }
}