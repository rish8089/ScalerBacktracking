package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Subset {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        Subset obj=new Subset();
        System.out.println(obj.subsets(A));
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<A.size();i++)
            list.add(0);
        Collections.sort(A);
        subsetsUtil(A,list,0,0,ans);
        Collections.sort(ans,(list1,list2)->{
            int i=0;
            int j=0;
            while(i<list1.size() && j<list2.size()){
                if(list1.get(i)<list2.get(j))
                    return -1;
                else if(list1.get(i)>list2.get(j))
                    return 1;
                i++;
                j++;
            }
            return Integer.compare(list1.size(),list2.size());
        });
        return ans;
    }
    private void subsetsUtil(ArrayList<Integer> A, ArrayList<Integer> list, int listIdx, int idx, ArrayList<ArrayList<Integer>> ans){
        if(idx==A.size()){
            ArrayList<Integer> cloned=new ArrayList<>();
            for(int i=0;i<listIdx;i++)
                cloned.add(list.get(i));
            ans.add(cloned);
            return;
        }
        //not picking
        subsetsUtil(A,list,listIdx,idx+1,ans);
        //picking
        list.set(listIdx,A.get(idx));
        subsetsUtil(A,list,listIdx+1,idx+1,ans);
    }
}
