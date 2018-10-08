package com.example.jason_jukes.laihuo.tool;

/**
 * Created by Yanan_Wu on 2017/9/26.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class StringUtil {


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    // 加密
    public static String base64Encrypt(String str) {
        String result = "";
        if (str != null) {
            result = new String(Base64.encode(str.getBytes(), Base64.DEFAULT));
        }
        return result;
    }

    // 解密
    public static String base64Decrypt(String str) {
        String result = "";
        if (str != null) {
            try {
                result = new String(Base64.decode(str, Base64.DEFAULT), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHexString(byte[] b) {  //String to  byte
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    //md5加密
    public static String md5Encrypt(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }


    /**
     * SHA加密
     *
     * @param strSrc 明文
     * @return 加密之后的密文
     */
    public static String shaEncrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-1");// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bts 数据源
     * @return 16进制字符串
     */
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }


    //  AES加密
    private static byte[] AESEncrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    //AES解密
    private static byte[] AESDecrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    //密码验证,为8-20位
    public static boolean isPassword(String password) {
        if (password.matches("^(?=.*[0-9].*)(?=.*[a-zA-Z].*).{8,16}$")) {
            return true;
        }
        return false;
    }

    //手机号验证
    public static boolean isPhone(String phone) {
        if (phone.matches("^1[34578]+\\d{9}$")) {
            return true;
        }
        return false;
    }

    //对手机号格式的设定
    public static boolean isMobileNo(String mobiles) {
        Pattern pattern = Pattern.compile("^[1][3456789][0-9]{9}$");
        //        "[1]"代表第1位为数字1，"[34578]"代表第二位可以为3、4、5、7、8中的一个，
        //        "{9}"代表后面是可以是0～9的数字，有9位。
        Matcher matcher = pattern.matcher(mobiles);
        return matcher.matches();
    }

    //身份证号验证
    public static boolean userCardCheck(String userCard) {
        if (userCard.matches("^(\\d{14}|\\d{17})(\\d|[xX])$")) {
            return true;
        }
        return false;
    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    public static String getBigDecimal(String value, int retainLength) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(retainLength, BigDecimal.ROUND_HALF_UP).toString();
    }

    /*时间戳转换为时间*/
    //pattern 时间格式  eg:  yyyy-MM-dd HH:mm:ss
    public static String timeStamp2time(String time, String pattern) {
        SimpleDateFormat sdr = new SimpleDateFormat(pattern);
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    public static String getTimeStamp() {
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        return str;
    }

    public static String getTimeStr() {
        return getTimeStr(null);
    }

    public static String getTimeStr(Long timestamp) {
        return getTimeStr(timestamp, null);
    }

    public static String getTimeStr(Long timestamp, String pattern) {
        Date date;
        if (timestamp != null) {
            date = new Date(timestamp);
        } else {
            date = new Date();
        }
        SimpleDateFormat sdf;
        if (isEmpty(pattern)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            sdf = new SimpleDateFormat(pattern);
        }
        String sd = sdf.format(date);
        return sd;
    }

    /**
     * 判定输入汉字
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 检测String是否全是中文
     *
     * @param name
     * @return
     */
    public static boolean checkChinese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * @param originalStr   要隐藏的字符串
     * @param encryptLength 剩下要显示的长度
     * @return
     */
    public static String getEncryptStr(String originalStr, int encryptLength) {
        int length = originalStr.trim().length();
        String encrypt = "";
        if (length > 6) {
            encrypt += originalStr.substring(0, 3);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < encryptLength; i++) {
                sb.append("*");
            }
            encrypt += sb.toString();
            encrypt += originalStr.substring(length - 3, length);
            return encrypt;
        }
        return originalStr;
    }

    //根据当前日期判断是周几
    public static int getWeekOfDate(Date date) {
        int[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    //获取当前日期的前一天
    public static Date getPrevDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        return c.getTime();
    }

    public static Date str2Date(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String getSexStr(int sex) {
        if (sex == 0) {
            return "男";
        }
        if (sex == 1) {
            return "女";
        }
        return "null";
    }

    public static String getencryptPhone(String phone) {
        return phone.substring(0, 3) + "*****" + phone.substring(phone.length() - 3, phone.length());
    }

    public static String getHandleDoctorName(String name) {
        int length = name.length();
        if (2 == length || 3 == length) {
            return name.substring(0, 1) + "医生";
        }
        if (4 == length) {
            return name.substring(0, 2) + "医生";
        }
        return name;
    }

    /**
     * 判断是否为空
     *
     * @param s
     * @return
     */
    public static boolean isNull(String s) {
        if (s == "null" || s == null || s.length() == 0 || "".equals(s)) {
            return true;
        }
        return false;
    }


    //判断是否同时包含数字和字母
    public static boolean isLetterDigit(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLetter(str.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]+$";
        boolean isRight = isDigit && isLetter && str.matches(regex);
        return isRight;
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime(String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        Log.d("--33333---", sdf.format(new java.util.Date()));
        return sdf.format(new java.util.Date());
    }


    //时间转时间戳  time时间  type 格式（如："yyyy-MM-dd-HH-mm-ss"）
    public static String getTimestamp(String time, String type) {
        SimpleDateFormat sdr = new SimpleDateFormat(type, Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
            Log.d("--444444---", times);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    //马赛克
    public static Bitmap Masic(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        int[] inPixels = new int[width * height];
        int[] outPixels = new int[width * height];

        bitmap.getPixels(inPixels, 0, width, 0, 0, width, height);
        int index = 0;

        int offsetX = 0, offsetY = 0;
        int newX = 0, newY = 0;
        int size = 10;
        double total = size * size;
        double sumred = 0, sumgreen = 0, sumblue = 0;
        for (int row = 0; row < height; row++) {
            int ta = 0, tr = 0, tg = 0, tb = 0;
            for (int col = 0; col < width; col++) {
                newY = (row / size) * size;
                newX = (col / size) * size;
                offsetX = newX + size;
                offsetY = newY + size;
                for (int subRow = newY; subRow < offsetY; subRow++) {
                    for (int subCol = newX; subCol < offsetX; subCol++) {
                        if (subRow < 0 || subRow >= height) {
                            continue;
                        }
                        if (subCol < 0 || subCol >= width) {
                            continue;
                        }
                        index = subRow * width + subCol;
                        ta = (inPixels[index] >> 24) & 0xff;
                        sumred += (inPixels[index] >> 16) & 0xff;
                        sumgreen += (inPixels[index] >> 8) & 0xff;
                        sumblue += inPixels[index] & 0xff;
                    }
                }
                index = row * width + col;
                tr = (int) (sumred / total);
                tg = (int) (sumgreen / total);
                tb = (int) (sumblue / total);
                outPixels[index] = (ta << 24) | (tr << 16) | (tg << 8) | tb;

                sumred = sumgreen = sumblue = 0; // reset them...
            }
        }
        result.setPixels(outPixels, 0, width, 0, 0, width, height);
        return result;
    }


    /**
     * 根据图片的url路径获得Bitmap对象
     *
     * @param url
     * @return
     */

    private static Bitmap bitmap;

    public static Bitmap returnBitmap(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL fileUrl = null;
                bitmap = null;

                try {
                    fileUrl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                try {
                    HttpURLConnection conn = (HttpURLConnection) fileUrl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        return bitmap;
    }


    /**
     * 2.  *
     * 3.  * <p>Description:使用gzip进行解压缩</p>
     * 4.  * @param compressedStr
     * 5.  * @return
     * 6.
     */
    public static String gunZip(String compressedStr) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            // 对返回数据BASE64解码
            compressed = Base64.decode(compressedStr, Base64.DEFAULT);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);

            // 解码后对数据gzip解压缩
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }

            // 最后对数据进行utf-8转码
            decompressed = out.toString("utf-8");
        } catch (IOException e) {
            Log.e("gunzip error ", e.getMessage());
        } finally {

        }
        return decompressed;
    }


    //获取手机ip
    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    //获取指定位数的随机数字
    public static String getRandom(int lenth) {

        String strRand = "";
        for (int i = 0; i < lenth; i++) {
            strRand += String.valueOf((int) (Math.random() * 10));
        }

        return strRand;

    }

    public static List<String> splitStr(String s) {

        String[] arr = s.split(",");//分割字符串得到数组
        List<String> list = java.util.Arrays.asList(arr);

        return list;

    }

}
