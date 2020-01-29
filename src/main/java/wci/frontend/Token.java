package wci.frontend;

import java.io.IOException;

public class Token {
    protected TokenType type;
    protected String text;
    protected Object value;
    protected Source source;
    protected int lineNum;
    protected int position;

    public Token(Source source) throws IOException {
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position = source.getPosition();
        extract();
    }

    protected void extract() throws IOException {
        text = Character.toString(currentChar());
        value = null;

        nextChar();
    }

    protected char nextChar() throws IOException {
        return source.nextChar();
    }

    protected char currentChar() throws IOException {
        return source.currentChar();
    }

    protected char peekChar() throws IOException {
        return source.peekChar();
    }

    public int getLineNumber() {
        return lineNum;
    }
}
