package string.medium;

// O(n) and O(1)
public class OneEdit2 {
    public boolean oneEdit(String stringOne, String stringTwo) {
        int lengthOne = stringOne.length();
        int lengthTwo = stringTwo.length();

        if(Math.abs(lengthOne - lengthTwo) > 1) {
            return false;
        }

        int indexOne = 0;
        int indexTwo = 0;
        int edit = 0;

        while(indexOne < lengthOne && indexTwo < lengthTwo){

            if (stringOne.charAt(indexOne) == stringTwo.charAt(indexTwo)) {
                indexOne++;
                indexTwo++;
            } else {
                if(edit > 0) {
                    return false;
                } else {
                    edit +=1;
                    if(lengthOne == lengthTwo){
                        indexOne++;
                        indexTwo++;
                    } else if (lengthOne > lengthTwo) {
                        indexOne ++;
                    } else {
                        indexTwo ++;
                    }
                }
            }
        }
        return true;
    }

}
