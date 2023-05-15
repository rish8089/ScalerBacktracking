package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        Permutations obj=new Permutations();
        System.out.println(obj.permute(A));
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<A.size();i++)
            list.add(0);
        permuteUtil(A,ans,0,list, new HashSet<>());
        return ans;
    }
    public void permuteUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, int listIdx, ArrayList<Integer> list, HashSet<Integer> visited) {
        if(listIdx==A.size()){
            ArrayList<Integer> cloned=new ArrayList<>();
            for(int i=0;i<listIdx;i++)
                cloned.add(list.get(i));
            ans.add(cloned);
            return;
        }
        for(int i=0;i<A.size();i++){
            if(!visited.contains(A.get(i))) {
                visited.add(A.get(i));
                list.set(listIdx, A.get(i));
                permuteUtil(A, ans, listIdx + 1, list,visited);
                visited.remove(A.get(i));
            }
        }
    }

}
