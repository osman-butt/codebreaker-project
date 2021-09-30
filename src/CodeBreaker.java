public class CodeBreaker {
    public static void main(String[] args) {
        String decodedString = "Osman Butt";
        String encodedString = numberCypherEncoder(decodedString);
        System.out.println(encodedString);
    }

    public static String numberCypherEncoder(String decodedString){
        String decodedStringToLower = decodedString.toLowerCase();
        String encodedString = "";
        for (int i = 0; i<decodedStringToLower.length()-1;i++){
            char decodedChar = decodedStringToLower.charAt(i);
            if (decodedChar == ' '){
                encodedString += " ;";
            }else{
                int numberInAlphabet = decodedChar - 'a' + 1;
                encodedString += numberInAlphabet;
                encodedString += ";";
            }
        }
        char lastChar = decodedStringToLower.charAt(decodedStringToLower.length()-1);
        int numberInAlphabet = lastChar - 'a' + 1;
        encodedString += numberInAlphabet;
        return encodedString;
    }
}
