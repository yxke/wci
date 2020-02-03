package wci.frontend.pascal.tokens;

import wci.frontend.Source;
import wci.frontend.pascal.PascalErrorCode;
import wci.frontend.pascal.PascalToken;

import java.io.IOException;

public class PascalErrorToken extends PascalToken {
    public PascalErrorToken(Source source, PascalErrorCode errorCode, String tokenText) throws IOException {
        super(source);
        this.text = tokenText;
        this.value = errorCode;

    }
}
