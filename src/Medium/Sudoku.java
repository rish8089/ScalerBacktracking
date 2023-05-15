package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sudoku {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Character>> a=new ArrayList<>();
        for(int i=0;i<9;i++){
            String str=br.readLine();
            ArrayList<Character> list=new ArrayList<>();
            for(int j=0;j<9;j++)
                list.add(str.charAt(j));
            a.add(list);
        }
        Sudoku obj=new Sudoku();
        obj.solveSudoku(a);
        System.out.println(a);
    }
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudokuUtil(a,0);
    }
    public boolean solveSudokuUtil(ArrayList<ArrayList<Character>> a, int idx) {
        if(idx==81)
            return true;
        int i=idx/9;
        int j=idx%9;
        if(a.get(i).get(j)=='.'){
            for(char ch='1';ch<='9';ch++){
                a.get(i).set(j,ch);
                if(isValid(a,i,j)){
                    boolean res=solveSudokuUtil(a,idx+1);
                    if(res)
                        return true;
                }
                a.get(i).set(j,'.');
            }
        }else{
            return solveSudokuUtil(a,idx+1);
        }
        return false;
    }
    private boolean isValid(ArrayList<ArrayList<Character>> a, int i, int j){
        //traversing in the row
        for(int k=0;k<9;k++){
            if(k!=j && a.get(i).get(j)==a.get(i).get(k))
                return false;
        }
        //traversing in the column
        for(int k=0;k<9;k++){
            if(k!=i && a.get(i).get(j)==a.get(k).get(j))
                return false;
        }
        //traversing through the grid
        int gi=i/3;
        int gj=j/3;
        for(int k=gi*3;k<gi*3+3;k++){
            for(int l=gj*3;l<gj*3+3;l++){
                if(k!=i && l!=j && a.get(k).get(l)==a.get(i).get(j))
                    return false;
            }
        }
        return true;
    }
}
