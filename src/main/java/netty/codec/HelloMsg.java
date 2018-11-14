package netty.codec;

/**
 * Created by kaiscript on 2018/2/27.
 */
public class HelloMsg {

    private byte type;
    private int length;
    private String body;

    public HelloMsg(byte type, int length, String body) {
        this.type = type;
        this.length = length;
        this.body = body;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HelloMsg{" +
                "type=" + type +
                ", length=" + length +
                ", body='" + body + '\'' +
                '}';
    }
}
