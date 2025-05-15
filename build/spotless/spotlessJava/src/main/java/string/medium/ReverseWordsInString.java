package string.medium;

// O(n) - Time & O(n) - Space
public class ReverseWordsInString {
  public String reverseWordsInString(String string) {
    StringBuilder finalString = new StringBuilder();
    StringBuilder currentString = new StringBuilder();
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == ' ') {
        finalString.insert(0, currentString.toString());
        currentString.setLength(0);
        finalString.insert(0, string.charAt(i));
      } else {
        currentString.append(string.charAt(i));
      }
    }
    finalString.insert(0, currentString.toString());
    return finalString.toString();
  }
}
