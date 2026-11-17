package utils;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;


public class RegexHelper {
    private static final Logger logger = Logger.getLogger(RegexHelper.class.getName());

    /**
     * Parses text for all matches with the regex pattern regex.
     *
     * @param regex The regex pattern to use.
     * @param text  The text to be parsed
     * @return      An ArrayList with all matches of regex in text
     */
    public static ArrayList<String> parseRegex (String regex, String text){
        ArrayList<String> matchedStrings = new ArrayList<String>();
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                matchedStrings.add(matcher.group());
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }

        return matchedStrings;
    }

    /**
     * Replaces all instances of regex in text according to the method replacer.
     * <p>
     * Example:
     * <pre>{@code
     * RegexHelper.replace("\\d", "12345",
     *          x -> String.valueOf(Integer.parseInt(x) + 1)); // Returns "23456"
     * }</pre>
     *
     * @param regex    The regex pattern to use
     * @param text     The text to scan
     * @param replacer The function to replace with
     * @return The text after replacement
     */
    public static String replace (String regex, String text, Function<String, String> replacer){
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            return matcher.replaceAll(match -> replacer.apply(match.group()));
        } catch (Exception e){
            logger.warning(e.getMessage());
            return "";
        }
    }
}
