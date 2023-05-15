package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfSquarefulArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        NumberOfSquarefulArrays obj=new NumberOfSquarefulArrays();
        System.out.println(obj.solve(A));
    }
    public int solve(ArrayList<Integer> A) {
        return solveUtil(A,-1,0,new HashSet<>());
    }
    private int solveUtil(ArrayList<Integer> A, int lastElement, int idx, HashSet<Integer> visited){
        if(idx==A.size())
            return 1;
        int ans=0;
        //level set
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<A.size();i++){
            if(!set.contains(A.get(i)) && !visited.contains(i)){
                if(lastElement != -1){
                    if(!isPerfectSquare(lastElement+A.get(i)))
                        continue;
                }
                set.add(A.get(i));
                visited.add(i);
                ans+=solveUtil(A,A.get(i),idx+1,visited);
                visited.remove(i);
            }
        }
        return ans;
    }
    private boolean isPerfectSquare(long num){
        long sqrt=(long)Math.sqrt(num);
        return sqrt*sqrt==num;
    }
}
