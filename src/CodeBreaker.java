import java.util.Arrays;

public class CodeBreaker {
    public static void main(String[] args) {
        String s = "Osman Butt";
        String encodedString = numberCypherEncoder(s);
        String decodedString = numberCypherDecoder(encodedString);
        System.out.println(encodedString);
        System.out.println(decodedString);
        String encodedCeasar = ceasarEncoder("hello world");
        System.out.println(encodedCeasar);
//        System.out.println((int) 'h'+3);
//        System.out.println((char) (107));
    }

    public static String numberCypherEncoder(String decodedString){
        String decodedStringToLower = decodedString.toLowerCase();
        String encodedString = "";
        for (int i = 0; i<decodedStringToLower.length()-1;i++){
            char decodedChar = decodedStringToLower.charAt(i);
            int numberInAlphabet = decodedChar - 'a' + 1; //making 'a'=1
            encodedString += numberInAlphabet;
            encodedString += ";";
        }
        char lastChar = decodedStringToLower.charAt(decodedStringToLower.length()-1);
        int numberInAlphabet = lastChar - 'a' + 1;
        encodedString += numberInAlphabet;
        return encodedString;
    }

    public static String numberCypherDecoder(String encodedString){
        // Letter a to z has code points ranging from 97 to 122 in java
        int codePointStart = (int) 'a' - 1 ;
        String decodedString = "";
        String[] encodedStringToArray = encodedString.split(";");
        int[] encodedStringToIntArray = new int[encodedStringToArray.length];
        for (int i = 0; i < encodedStringToArray.length; i++) {
            encodedStringToIntArray[i] = Integer.valueOf(encodedStringToArray[i]);
        }
        for (int i = 0; i<encodedStringToIntArray.length; i++){
            char decodedChar = (char) (encodedStringToIntArray[i] + codePointStart);
            decodedString += decodedChar;
        }
        return decodedString;
    }

    public static String ceasarEncoder(String decodedString){
        int amountToShiftAlphabet = 3;
        String decodedStringToLower = decodedString.toLowerCase();
        String encodedString = "";
        //Convert string to char array
        char[] charArray = new char[decodedStringToLower.length()];
        for (int i = 0; i<decodedStringToLower.length(); i++){
            charArray[i] = decodedStringToLower.charAt(i);
        }
        for (int i = 0; i<decodedStringToLower.length(); i++){
            if (charArray[i]==' '){
                encodedString += " ";
            }else{
                int charToIntShifted =  charArray[i] + amountToShiftAlphabet;
                char shiftedIntToChar = (char) (charToIntShifted);
                encodedString += shiftedIntToChar;
            }
        }
        return encodedString;
    }

}
