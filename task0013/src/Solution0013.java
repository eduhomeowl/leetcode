package task0013.src;

import java.util.HashMap;

public class Solution0013 {

    public static void main(String[] args) {
        System.out.println(""+romanToInt("III"));
        System.out.println(""+romanToInt("MCMXCIV"));
        System.out.println(""+romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int res = 0;

        HashMap<String, String> prev = new HashMap<>();
        HashMap<String, Integer> diff = new HashMap<>();
        HashMap<String, Integer> val = new HashMap<>();

        val.put("I",1);
        val.put("V",5);
        val.put("X",10);
        val.put("L",50);
        val.put("C",100);
        val.put("D",500);
        val.put("M",1000);

        prev.put("I","VX");
        prev.put("X","LC");
        prev.put("C","DM");

        diff.put("V",4);
        diff.put("X",9);
        diff.put("L",40);
        diff.put("C",90);
        diff.put("D",400);
        diff.put("M",900);

        int i = 0;
        while (i < s.length()) {
          String currChar = String.valueOf(s.charAt(i));
          String nextChar;
          int j = i + 1;
          if ( j < s.length() ){
              nextChar = String.valueOf(s.charAt(j));
          } else {
              nextChar = "";
          }

          int charVal = val.get(currChar);
          String prevStr = prev.get(currChar);

          if ( prevStr != null & nextChar.equals("") ){
             if ( nextChar.equals( String.valueOf( prevStr.charAt(0) ) )
                | nextChar.equals( String.valueOf( prevStr.charAt(1) ) ) ) {

                 charVal = diff.get(nextChar);
                 i = i + 1;

              }

          }

          res = res + charVal;

          i = i + 1;
        }

        return res;
    }

}
