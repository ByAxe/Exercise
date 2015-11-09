package regular.experience;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public final String ANSWER = "([Yy][Ee][Ss])|[Yy]|([Nn][Oo])|[Nn]";


    public boolean test(String testString, String requeredPattern){
        Pattern p = Pattern.compile(requeredPattern);
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}
