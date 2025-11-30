package neetcode150.arraysandhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
  class Solution {

    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for (String s : strs) {
        sb.append(s.length() + "#" + s);
      }
      return sb.toString();
    }

    public List<String> decode(String str) {
      List<String> result = new ArrayList<>();

      int i = 0;
      int j = 0;
      while (i < str.length()) {
        while (str.charAt(j) != '#') {
          j++;
        }
        int lengthOfString = Integer.parseInt(str.substring(i, j));
        i = j + 1;
        j = i + lengthOfString;
        result.add(str.substring(i, j));
        i = j;
      }
      return result;
    }
  }
}
