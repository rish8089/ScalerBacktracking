package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UniquePathsIII {
    int []X={-1,0,0,1};
    int []Y={0,1,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> B=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                B.add(Integer.parseInt(str[j]));
            }
            A.add(B);
        }
        UniquePathsIII obj=new UniquePathsIII();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        boolean [][]visited=new boolean[n][m];
        int sx=-1,sy=-1,dx=-1,dy=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.get(i).get(j)==1){
                    sx=i;
                    sy=j;
                }else if(A.get(i).get(j)==2){
                    dx=i;
                    dy=j;
                }
            }
        }
        int noOfNonObstacleSquares=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.get(i).get(j)!=-1)
                    noOfNonObstacleSquares++;
            }
        }
        visited[sx][sy]=true;
        return solveUtil(A,visited,sx,sy,dx,dy,1,noOfNonObstacleSquares);
    }
    public int solveUtil(ArrayList<ArrayList<Integer>> A, boolean [][]visited, int sx, int sy, int dx, int dy, int cnt, int expectedCnt) {
        if(sx==dx && sy==dy){
            return cnt==expectedCnt?1:0;
        }
        int n=A.size();
        int m=A.get(0).size();
        int ans=0;
        for(int i=0;i<4;i++){
            if(isValid(sx,sy,n,m,X[i],Y[i]) && !visited[sx+X[i]][sy+Y[i]] && A.get(sx+X[i]).get(sy+Y[i])!=-1){
                int nx=sx+X[i];
                int ny=sy+Y[i];
                visited[nx][ny]=true;
                ans+=solveUtil(A,visited,nx,ny,dx,dy,cnt+1,expectedCnt);
                visited[nx][ny]=false;
            }
        }
        return ans;
    }
    private boolean isValid(int x, int y, int n, int m, int cx, int cy){
        return x+cx>=0 && x+cx<n && y+cy>=0 && y+cy<m;
    }
}
