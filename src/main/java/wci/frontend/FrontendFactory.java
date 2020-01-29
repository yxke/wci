package wci.frontend;

import wci.frontend.pascal.PascalParserTD;
import wci.frontend.pascal.PascalScanner;

public class FrontendFactory {

    public static Parser createParser(String language, String type, Source source) throws Exception {
        if (language.equals("Pascal") && type.equals("top-down")) {
            Scanner scanner = new PascalScanner(source);
            return new PascalParserTD(scanner);
        }else if (!language.equals("Pascal")) {
            throw new Exception("Parser factory: Invalid language '"+language+"'");
        }else{
            throw new Exception("Parser factory: Invalid type '" + type + "'");
        }
    }
}
