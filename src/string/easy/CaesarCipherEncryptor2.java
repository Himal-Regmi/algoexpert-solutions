package string.easy;

public class CaesarCipherEncryptor2 {
    //Space Complexity - O(N) and Time Complexity - O(N)
    public static String caesarCypherEncryptor(String str, int key) {
        char[] encryptedLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            encryptedLetters[i] = getEncryptedLetter(str.charAt(i), newKey);
        }
        return new String(encryptedLetters);
    }

    public static char getEncryptedLetter(char letter, int key) {
        int newLetterCode = letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }
}
