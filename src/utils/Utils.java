package utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;

public class Utils {
    private static final boolean DEBUG = true;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.M.d");

    /**
     * 将目标字符串进行MD5加密，并返回十六进制格式的加密后字符串
     * @param s 需要加密的字符串
     * @return 加密后的十六进制格式字符串
     */
    public static String hex_md5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4',
                             '5', '6', '7', '8', '9',
                             'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes();
            //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 网站Log
     * @param logString
     */
    public static void Log(String logString){
        if(DEBUG){
            System.out.println(logString);
        }
    }
}
