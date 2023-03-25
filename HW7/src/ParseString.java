import java.util.*;

public class ParseString {
    private final HashMap<Character, Integer> strStats;
    private String originalString = "";

    ParseString() {
        strStats = new HashMap<>();
    }

    ParseString(String strToAnalyse) {
        this();
        originalString = strToAnalyse.toLowerCase();
        setStringForAnalysis(originalString);
    }

    public void setStringForAnalysis(String strToAnalyse) {

        char[] strToAnalyseArray = strToAnalyse.toCharArray();

        for (Character ch : strToAnalyseArray) {
            strStats.put(ch, 0);
        }
    }

    public void analyseString() {

        for (Character ch : originalString.toCharArray()) {

            if (strStats.containsKey(ch))
                strStats.put(ch, strStats.get(ch) + 1);
        }
    }

    public int countDigits() {
        int digitCount = 0;
        for (Character ch : strStats.keySet()) {
            if (Character.isDigit(ch))
                digitCount += strStats.get(ch);

        }
        return digitCount;
    }

    public int letterCount() {
        int lettersCount = 0;
        for (Character ch : strStats.keySet()) {
            if (Character.isAlphabetic(ch))
                lettersCount += strStats.get(ch);
        }
        return lettersCount;
    }

    public int whitespaceCount() {
        return strStats.get(' ');
    }

    public int countPunctuation() {
        int punctuationCount = 0;
        for (Character ch : strStats.keySet()) {
            if (ch.equals('!') | ch.equals('.') | ch.equals('?') | ch.equals(':') | ch.equals(';') |
                    ch.equals(',') | ch.equals('-') | ch.equals('(') | ch.equals(')'))
                punctuationCount += strStats.get(ch);
        }
        return punctuationCount;
    }
    //not used
    private int countCharacter(Character charToCount) {
        int charCount = 0;
        for (Character ch : strStats.keySet()) {
            if (ch.equals(charToCount))
                charCount++;
        }
        return charCount;
    }

    @Override
    public String toString() {
        return "ParseString{" + '\n' +
                "strStats=" + strStats.toString() + '\n' +
                "total letters: " + letterCount() + '\n' +
                "total digits: "+ countDigits() + '\n' +
                "total punctuation symbols: " + countPunctuation() + '\n' +
                "total whitespaces: " + whitespaceCount() + '\n' +
                '}';
    }

    public HashMap<Character, Integer> getStats() {
        return strStats;
    }

    public static void main(String[] args) {

        ParseString myStr = new ParseString("Absolute Java by: Walter Savitch, 5-th edition, 2012 year.");
        myStr.analyseString();
        System.out.println(myStr);
        System.out.println(myStr.getStats());
        System.out.println("Letters total count: "+myStr.letterCount());
        System.out.println("Digits total count: "+myStr.countDigits());
        System.out.println("Whitespaces total count: "+ myStr.whitespaceCount());
        System.out.println("Punctuation total count: "+myStr.countPunctuation());
    }
}
