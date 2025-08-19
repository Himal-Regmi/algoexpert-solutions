package string.easy;

public class CaesarCipherEncryptor3 {
  // Space Complexity - O(N) and Time Complexity - O(N)
  public static String caesarCypherEncryptor(String str, int key) {
    char[] encryptedLetters = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      encryptedLetters[i] = getEncryptedLetter(str.charAt(i), key);
    }
    return new String(encryptedLetters);
  }

  public static char getEncryptedLetter(char letter, int key) {
    int offset = (letter - 'a' + key) % 26;
    return (char) ('a' + offset);
  }
}
