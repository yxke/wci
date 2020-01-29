package wci.frontend;

import java.io.IOException;

public abstract class Scanner {
    protected Source source;
    private Token currentToken;

    public Scanner(Source source) {
        this.source = source;
    }

    public Token currentToken(){
        return this.currentToken;
    }

    public Token nextToken() throws Exception {
        currentToken = extractToken();
        return currentToken;
    }

    protected abstract Token extractToken() throws Exception;

    public char currentChar() throws IOException {
        return this.source.currentChar();
    }

    public char nextChar() throws IOException {
        return this.source.nextChar();
    }
}
