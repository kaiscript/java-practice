package encryp;

import com.google.common.io.BaseEncoding;

/**
 * Created by kaiscript on 2017/10/18.
 */
public class EncrypTest {

    public static void main(String[] args) {
        String encode = BaseEncoding.base64().encode("123".getBytes());
        System.out.println(encode);
    }

}
