import java.util.Arrays;

public class CodeBreaker {
    public static void main(String[] args) {
        String s = "Osman Butt";
        String encodedString = numberCypherEncoder(s);
        String decodedString = numberCypherDecoder(encodedString);
        System.out.println(encodedString);
        System.out.println(decodedString);
    }

    public static String numberCypherEncoder(String decodedString){
        String decodedStringToLower = decodedString.toLowerCase();
        String encodedString = "";
        for (int i = 0; i<decodedStringToLower.length()-1;i++){
            char decodedChar = decodedStringToLower.charAt(i);
            int numberInAlphabet = decodedChar - 'a' + 1;
            encodedString += numberInAlphabet;
            encodedString += ";";
        }
        char lastChar = decodedStringToLower.charAt(decodedStringToLower.length()-1);
        int numberInAlphabet = lastChar - 'a' + 1;
        encodedString += numberInAlphabet;
        return encodedString;
    }

    public static String numberCypherDecoder(String encodedString){
        // Letter a to z runs has code points ranging from 97 to 122 in java
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
}
