package wci.frontend;

import wci.message.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 这个类实现得相当巧妙，值得仔细研究
 */
public class Source implements MessageProducer {

    public static final char EOL = '\n';
    public static final char EOF = 0;

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPos;

    protected static MessageHandler messageHandler;

    static {
        messageHandler = new MessageHandler();
    }

    public Source(BufferedReader reader) {
        this.lineNum = 0;
        this.currentPos = -2;   //为了和-1的情况做区分，-1指的是line已经准备好但还未开始读
        this.reader = reader;
    }

    public char currentChar() throws IOException {
        if(currentPos == -2){
            readLine();
            return nextChar();
        }else if(line == null){
            return EOF;
        }else if((currentPos==-1)||(currentPos==line.length())){
            return EOL;
        }else if(currentPos>line.length()){
            readLine();
            return nextChar();
        }else{
            return line.charAt(currentPos);
        }
    }

    public char nextChar() throws IOException {
        ++currentPos;
        return currentChar();
    }

    public char peekChar() throws IOException {
        currentChar();
        if(line==null){
            return EOF;
        }
        int nextPos = currentPos + 1;
        return nextPos < line.length()?line.charAt(nextPos):EOL;
    }

    private void readLine() throws IOException {
        line = reader.readLine();
        currentPos = -1;

        if (line!=null){
            ++lineNum;
        }

        if (line!=null) {
            sendMessage(new Message(MessageType.SOURCE_LINE, new Object[]{lineNum, line}));
        }
    }

    public void close() throws IOException {
        if(reader!=null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public int getLineNum() {
        return lineNum;
    }

    public int getPosition() {
        return currentPos;
    }


    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
