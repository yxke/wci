package wci.frontend;

import java.io.IOException;

public class EofToken extends Token {
    public EofToken(Source source) throws IOException {
        super(source);
    }


    protected void extract(Source source) throws IOException {
//        super.extract();
    }
}
