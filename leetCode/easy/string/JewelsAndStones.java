package leetCode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    // 0 ms approach
    /**public int numJewelsInStones(String J, String S) {
        int count = 0 ;
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        for (int i = 0 ; i < stones.length; i++)
        {
            for (int j = 0 ; j < jewels.length; j++)
            {
                if(stones[i] == jewels[j])
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
**/

    //slower as compared to above method, //1 ms
    public int numJewelsInStones(String J, String S) {
        int count = 0 ;
        Set<Character> setofJewels = new HashSet<>();

        for (char c : J.toCharArray())
            setofJewels.add(c);

        for (char c : S.toCharArray())
        {
            if(setofJewels.contains(c))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb"; //output :3
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.numJewelsInStones(jewels, stones));
        jewels = "z" ; stones = "ZZ"; //output : 0
        System.out.println(jewelsAndStones.numJewelsInStones(jewels, stones));
    }
}
