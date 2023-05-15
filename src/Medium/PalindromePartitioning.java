package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PalindromePartitioning {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        PalindromePartitioning obj=new PalindromePartitioning();
        System.out.println(obj.partition(A));
    }
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        partitionUtil(a,0,new ArrayList<>(),0,ans);
        Collections.sort(ans,(list1, list2)->{
            int i=0;
            int j=0;
            while(i<list1.size() && j<list2.size()){
                if(!list1.get(i).equals(list2.get(j))){
                    return list1.get(i).compareTo(list2.get(j));
                }
                i++;
                j++;
            }
            return Integer.compare(list1.size(),list2.size());
        });
        return ans;
    }
    private void partitionUtil(String a,int listIdx,ArrayList<String> list,int idx,ArrayList<ArrayList<String>> ans){
        if(idx==a.length()){
            ArrayList<String> cloned=new ArrayList<>();
            for(int i=0;i<listIdx;i++){
                cloned.add(list.get(i));
            }
            ans.add(cloned);
            return;
        }
        for(int i=idx;i<a.length();i++){
            String str=a.substring(idx,i+1);
            if(isPalindrome(str)){
                if(listIdx<list.size())
                    list.set(listIdx,str);
                else
                    list.add(str);
                partitionUtil(a,listIdx+1,list,i+1,ans);
            }
        }
    }
    private boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
