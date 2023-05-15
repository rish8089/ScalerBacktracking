package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NQueens {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        NQueens obj=new NQueens();
        System.out.println(obj.solveNQueens(A));
    }
    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ArrayList<StringBuilder> board=new ArrayList<>();
        for(int i=0;i<A;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<A;j++)
                sb.append('.');
            board.add(sb);
        }
        solveNQueensUtil(A,0,board,ans);
        return ans;
    }
    private void solveNQueensUtil(int A, int idx, ArrayList<StringBuilder> board, ArrayList<ArrayList<String>> ans){
        if(idx==A){
            ArrayList<String> cloned=new ArrayList<>();
            for(int i=0;i<board.size();i++)
                cloned.add(board.get(i).toString());
            ans.add(cloned);
            return;
        }
        StringBuilder row=board.get(idx);
        for(int i=0;i<A;i++){
            row.setCharAt(i,'Q');
            if(isValid(board,idx,i)){
                solveNQueensUtil(A,idx+1,board,ans);
            }
            row.setCharAt(i,'.');
        }
    }
    private boolean isValid(ArrayList<StringBuilder> board, int x, int y){
        int n=board.size();
        int m=board.get(0).length();
        int []dx={-1,-1,-1,1,1,1,0,0};
        int []dy={1,0,-1,1,0,-1,-1,1};
        for(int i=0;i<8;i++){
            int tempx=x;
            int tempy=y;
            while(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m){
                x=x+dx[i];
                y=y+dy[i];
                if(board.get(x).charAt(y)=='Q')
                    return false;
            }
            x=tempx;
            y=tempy;
        }
        return true;
    }
}
