package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        LetterPhone obj=new LetterPhone();
        System.out.println(obj.letterCombinations(br.readLine()));
    }
    public ArrayList<String> letterCombinations(String A) {
        Map<Character,String> mp=new HashMap<>();
        mp.put('0',"0");
        mp.put('1',"1");
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        ArrayList<String> list=new ArrayList<>();
        letterCombinationsUtil(A,0,mp,new StringBuilder(),list);
        return list;
    }
    public void letterCombinationsUtil(String A, int idx, Map<Character,String> mp, StringBuilder sb, ArrayList<String> ans) {
        if(idx==A.length()) {
            ans.add(sb.toString());
            return;
        }
        String str=mp.get(A.charAt(idx));
        for(int i=0;i<str.length();i++){
            if(idx<sb.length())
                sb.setCharAt(idx,str.charAt(i));
            else
                sb.append(str.charAt(i));
            letterCombinationsUtil(A,idx+1,mp,sb,ans);
        }
    }
}
