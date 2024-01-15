import java.util.ArrayList;
public class DFS {
    public static boolean searchDepth(int[][] maze,int x,int y, ArrayList<Integer> path){
        if(maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x] == 0){
            maze[y][x] = 2;
            int dx = -1;
            int dy = 0;
            if(searchDepth(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 1;
            dy = 0;
            if(searchDepth(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = -1;
            if(searchDepth(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = 1;
            if(searchDepth(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}