package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSumII {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        int B=Integer.parseInt(br.readLine());
        CombinationSumII obj=new CombinationSumII();
        System.out.println(obj.combinationSum(A,B));
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Collections.sort(A);
        combinationSumUtil(A,B,0,new ArrayList<>(),ans,0);
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
    private void combinationSumUtil(ArrayList<Integer> A, int B, int startIdx, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans, int listIdx){
        if(B==0){
            ArrayList<Integer> cloned=new ArrayList<>();
            for(int i=0;i<listIdx;i++)
                cloned.add(list.get(i));
            ans.add(cloned);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=startIdx;i<A.size();i++){
            if(B-A.get(i)>=0 && !set.contains(A.get(i))){
                set.add(A.get(i));
                if(listIdx<list.size())
                    list.set(listIdx,A.get(i));
                else
                    list.add(A.get(i));
                combinationSumUtil(A,B-A.get(i),i+1,list,ans,listIdx+1);
            }
        }
    }

}
