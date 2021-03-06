package String;


import java.util.*;

public class DNASequence {
    public Map<Character,Long> dnaMap = new HashMap<Character,Long>(){{
        put('A',1L);
        put('C',2L);
        put('G',3L);
        put('T',4L);

    }};

    public static void main(String[] args) {
        DNASequence dnaSequence = new DNASequence();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(dnaSequence.findRepeatedDnaSequences(s));

    }

    public List<String> findRepeatedDnaSequences(String s) {
        //use rolling hash method
        String firstString = s.substring(0,10);
        Set<Long> hashstoreset = new HashSet<Long>();
        long hashValue = computeFirstHash(firstString);
        List<String> finalResult = new ArrayList<String>();
        hashstoreset.add(hashValue);
        for (int i=1;i<=s.length()-10;i++){
            char oldremove = s.charAt(i-1);
            char newadd = s.charAt(i+10-1);
            hashValue = computeRollingHashValue(s.substring(i,i+10),oldremove,  newadd,hashValue);
            if(hashstoreset.contains(hashValue)){
                finalResult.add(s.substring(i,i+10));
            } else {
                hashstoreset.add(hashValue);
            }
        }
        return finalResult;
    }

    public long computeFirstHash(String firstString){
        long res = 0;
        for(int p =1;p<=10;p++){
            res += (long)Math.pow(2,p)*dnaMap.get(firstString.charAt(10-p));
        }
        return res;
    }

    public long computeRollingHashValue(String s2,char oldremove, char newadd,long oldhashValue){
        long res  = oldhashValue - (long)Math.pow(2,10)*dnaMap.get(oldremove);
        res = res*2L;
        res = res + 2L*dnaMap.get(newadd);
        System.out.println(oldremove +  " : " + newadd);
        System.out.println(s2 +  " : " + res);

        return res;
    }
}
