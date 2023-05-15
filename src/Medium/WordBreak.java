package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        ArrayList<String> B=new ArrayList<>();
        int n=Integer.parseInt(br.readLine());
        String []str=br.readLine().split(" ");
        for(int i=0;i<n;i++)
            B.add(str[i]);
        WordBreak obj=new WordBreak();
        System.out.println(obj.wordBreak(A,B));
    }
    public int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dict=new HashSet<>();
        dict.addAll(B);
        int []results=new int[A.length()];
        Arrays.fill(results,-1);
        return wordBreakUtil(A,dict,results,0);
    }
    private int wordBreakUtil(String A, HashSet<String> dict, int []results, int idx){
        if(idx==A.length())
            return 1;
        for(int i=idx;i<A.length();i++){
            String str=A.substring(idx,i+1);
            if(dict.contains(str)){
                if(results[i]==-1)
                    results[i]=wordBreakUtil(A,dict,results,i+1);
                if(results[i]==1)
                    return 1;
            }
        }
        return 0;
    }
}
