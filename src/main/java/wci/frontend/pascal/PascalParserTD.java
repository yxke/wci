package wci.frontend.pascal;

import wci.frontend.*;
import wci.message.Message;
import wci.message.MessageType;

public class PascalParserTD extends Parser {

    protected static PascalErrorHandler errorHandler = new PascalErrorHandler();

    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();


        while(!((token=nextToken()) instanceof EofToken)){
            TokenType tokenType = token.getType();

//            if (tokenType != ERROR) {
//
//            } else {
//                errorHandler.flag(token, )
//            }
        }

        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        sendMessage(new Message(MessageType.PARSER_SUMMARY,
                new Number[]{token.getLineNumber(), getErrorCount(), elapsedTime}
                ));
    }

    @Override
    public int getErrorCount() {
        return 0;
    }
}
