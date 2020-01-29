package wci.message;

public class Message {
    private MessageType type;
    private Object body;

    public Message(MessageType messageType, Object body) {
        this.type = messageType;
        this.body = body;
    }

    public MessageType getType() {
        return type;
    }

    public Object getBody() {
        return body;
    }
}
