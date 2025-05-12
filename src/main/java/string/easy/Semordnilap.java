package string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {
  public ArrayList<ArrayList<String>> semordnilap(String[] words) {
    ArrayList<ArrayList<String>> semordnilapPair = new ArrayList<ArrayList<String>>();
    Set<String> wordlist = new HashSet<String>(Arrays.asList(words));
    Set<String> usedWords = new HashSet<String>();
    for (String s : words) {
      if (!usedWords.contains(s)) {
        String palindrome = reverseString(s);
        if (!palindrome.equals(s) && wordlist.contains(palindrome)) {
          ArrayList<String> pair = new ArrayList<String>();
          pair.add(s);
          pair.add(palindrome);
          semordnilapPair.add(pair);
          usedWords.add(s);
          usedWords.add(palindrome);
        }
      }
    }
    return semordnilapPair;
  }

  /**
   * public String reverseString(String string) { StringBuilder sb = new StringBuilder(); for (int i
   * = string.length() - 1; i >= 0; i--) { sb.append(string.charAt(i)); } return sb.toString(); }
   */
  public String reverseString(String string) {
    return new StringBuilder(string).reverse().toString();
  }
}
