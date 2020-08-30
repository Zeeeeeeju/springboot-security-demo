package securitydemo.demo.utils;

import java.security.MessageDigest;

public class MD5Util {
    private static final  String SALT = "corl0323a9195ade5f56695ed9f2eb6b036f3e6417115d0cbe2fb9d74d8740406838dc84f152014b39a2414fb3530a40bc028a9e87642bd03cf5c36a1f70801e";

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes("utf-8")));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        return resultString;
    }

    public static String MD5EncodeWithSalt(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(mergePasswordAndSalt(resultString)
                    .getBytes("utf-8")));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        return resultString;
    }

    private static String mergePasswordAndSalt(String origin) {
        if (origin == null) {
            origin = "";
        }
        return origin + "{" + SALT + "}";
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

}
