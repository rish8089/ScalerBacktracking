package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SubsetsII {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(str[i]));
        SubsetsII obj=new SubsetsII();
        System.out.println(obj.subsetsWithDup(A));
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Collections.sort(A);
        for (int i = 0; i <=A.size(); i++)
            subsetsWithDupUtil(A, ans, new ArrayList<>(), 0, i, 0);
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
    private void subsetsWithDupUtil(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int listIdx, int num, int idx) {
        if(listIdx==num){
            ArrayList<Integer> cloned=new ArrayList<>();
            for(int i=0;i<listIdx;i++)
                cloned.add(list.get(i));
            ans.add(cloned);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=idx;i<A.size()-(num-listIdx-1);i++){
            if(!set.contains(A.get(i))){
                set.add(A.get(i));
                if(listIdx<list.size())
                    list.set(listIdx,A.get(i));
                else
                    list.add(A.get(i));
                subsetsWithDupUtil(A,ans,list,listIdx+1,num,i+1);
            }
        }
    }
}
