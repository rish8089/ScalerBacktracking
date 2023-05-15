package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        RemoveInvalidParentheses obj=new RemoveInvalidParentheses();
        System.out.println(obj.solve(br.readLine()));
    }
    public ArrayList<String> solve(String A) {
        int open=0;
        int num=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='(') {
                if(open<0)
                    open=0;
                open++;
            }
            else if(A.charAt(i)==')') {
                open--;
                if(open<0){
                    num+=1;
                }
            }
        }
        if(open>0)
            num+=open;
        List<Integer> positions=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==')' || A.charAt(i)=='(')
                positions.add(i);
        }
        HashSet<String> set=new HashSet<>();
        solveUtil(positions, set, new ArrayList<>(), 0, 0, num, A);
        return new ArrayList<>(set);

    }
    private void solveUtil(List<Integer> positions, HashSet<String> set, List<Integer> list, int listIdx, int idx, int num,String A){
        if(listIdx==num){
            StringBuilder sb=new StringBuilder();
            int i=0;
            for(int j=0;i<A.length() && j<list.size();i++){
                if(i==list.get(j))
                    j++;
                else
                    sb.append(A.charAt(i));
            }
            sb.append(A.substring(i));
            if(isValid(sb)){
                set.add(sb.toString());
            }
            return;
        }
        for(int i=idx;i<positions.size()-(num-listIdx-1);i++){
            int pos=positions.get(i);
            if(listIdx<list.size())
                list.set(listIdx,pos);
            else
                list.add(pos);
            solveUtil(positions,set,list,listIdx+1,i+1,num,A);
        }

    }
    private boolean isValid(StringBuilder sb){
        int open=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='(')
                open++;
            else if(sb.charAt(i)==')') {
                open--;
                if(open<0){
                    return false;
                }
            }
        }
        return open==0;
    }
}
