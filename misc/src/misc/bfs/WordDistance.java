package misc.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * 自己做一家公司的online test见过一次，也看同学遇到过几次，和leetcode上的edit 
 * distance不太一样，望大牛给个code。
 * 
 * 两个anagram string S 和 P，定义两个操作:
 * 1)相邻的character swap算一次操作
 * 2)第一个character 和最后一个character swap算一次操作
 * 问从S变到P的最小操作数。
 */

public class WordDistance {
	public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "acb";
        System.out.println(WordDistance.minDistance(s1, s2));
    }
    
    public static int minDistance(String s1, String s2) {
        int LEN = s1.length();
        
        Set<String> visited = new HashSet<String>();
        Queue<String> cur_level = new LinkedList<String>();
        Queue<String> next_level = new LinkedList<String>();
        
        cur_level.add(s1);
        visited.add(s1);
        int level = 1;
        while (!cur_level.isEmpty()) {
            String str = cur_level.remove();
            char[] str_ar = str.toCharArray();
            for (int i=0; i<LEN; i++) {
                char temp = str_ar[i];
                if (i == LEN - 1) {
                    str_ar[i] = str_ar[0];
                    str_ar[0] = temp;
                }
                else {
                    str_ar[i] = str_ar[i+1];
                    str_ar[i+1] = temp;
                }
                
                String newString = new String(str_ar);
                if (newString.equals(s2)) return level; // done!

                if (!visited.contains(newString)) {
                    next_level.add(newString);
                    visited.add(newString);
                }
            }
            
            if (cur_level.isEmpty()) {
                Queue<String> temp = cur_level;
                cur_level = next_level;
                next_level = temp;
                level++;
            }
        }
        return level;
    }
}
