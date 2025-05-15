package string.medium;

// 2 * O(n) & O(n)
public class OneEdit {
  public boolean oneEdit(String stringOne, String stringTwo) {
    char[] charArrayStringOne = stringOne.toCharArray();
    char[] charArrayStringTwo = stringTwo.toCharArray();

    int errorCount = 0;
    int indexAdjustment = 0;

    if (charArrayStringOne.length == charArrayStringTwo.length) {
      return hasMaxOneError(charArrayStringOne, charArrayStringTwo);
    } else {
      return hasMaxOneCharacterDiff(charArrayStringOne, charArrayStringTwo);
    }
  }

  public boolean hasMaxOneError(char[] charArrayStringOne, char[] charArrayStringTwo) {
    int error = 0;
    for (int idx = 0; idx < charArrayStringOne.length; idx++) {
      if (charArrayStringOne[idx] != charArrayStringTwo[idx]) {
        error += 1;
      }
    }
    return error <= 1;
  }

  public boolean hasMaxOneCharacterDiff(char[] charArrayStringOne, char[] charArrayStringTwo) {
    char[] longerCharArray;
    char[] shorterCharArray;

    if (charArrayStringOne.length > charArrayStringTwo.length) {
      longerCharArray = charArrayStringOne;
      shorterCharArray = charArrayStringTwo;
    } else {
      longerCharArray = charArrayStringTwo;
      shorterCharArray = charArrayStringOne;
    }

    if (longerCharArray.length - shorterCharArray.length > 1) {
      return false;
    }
    boolean diffActivated = false;

    for (int i = 0; i < shorterCharArray.length; i++) {
      if (!diffActivated) {
        if (longerCharArray[i] != shorterCharArray[i]) {
          if (longerCharArray[i + 1] != shorterCharArray[i]) {
            return false;
          }
          diffActivated = true;
        }
      } else {
        if (longerCharArray[i + 1] != shorterCharArray[i]) {
          return false;
        }
      }
    }
    return true;
  }
}
