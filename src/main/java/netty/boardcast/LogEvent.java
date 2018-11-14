package netty.boardcast;

import java.net.InetSocketAddress;

/**
 * Created by kaiscript on 2018/3/4.
 */
public class LogEvent {

    private final InetSocketAddress source;

    public static final byte SEPARATOR = (byte)':';

    private String fileName;
    private String msg;

    public LogEvent(InetSocketAddress source, String fileName, String msg) {
        this.source = source;
        this.fileName = fileName;
        this.msg = msg;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public InetSocketAddress getSource() {
        return source;
    }


    @Override
    public String toString() {
        return "LogEvent{" +
                "fileName='" + fileName + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
