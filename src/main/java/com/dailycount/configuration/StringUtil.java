package com.dailycount.configuration;

import antlr.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.alibaba.druid.util.StringUtils.isEmpty;

/**
 * Collection of utility methods for the String operations.
 */
public final class StringUtil extends StringUtils {

    /**
     * Represents the HEX_CHARS.
     */
    private static final String HEX_CHARS = "0123456789abcdef";

    /**
     * Represents the email regexp.
     */
    private static final String EMAIL_REGEXP = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*[.]\\w+([-.]\\w+)*";

    /**
     * Represents the mobile phone regexp.
     */
    private static final String MOBILE_PHONE_REGEXP = "^1\\d{10}";

    /**
     * Represents the password regexp.
     */
    private static final String PASSWORD_REGEXP = "\\S{6,16}";

    /**
     * Represents the phone regexp.
     */
    private static final String PHONE_REGEXP;

    /**
     * The regex to match the Chinese characters.
     */
    private static final String CHINESE_CHARACTERS_REGEXP = "[\u4e00-\u9fa5]+";

    /**
     * Represents the error message for unsupported encoding.
     */
    private static final String ERROR_UNSUPPORTED_ENCODING = "UTF-8 is apparently not supported on this machine.";

    /**
     * All the possible phone pattern.
     */
    private static final Pattern PHONE_PATTERN;

    /**
     * The decimal pattern.
     */
    private static final Pattern DECIMAL_PATTERN = Pattern.compile("(-?\\d+)(\\.\\d+)?");

    /**
     * The integer pattern.
     */
    private static final Pattern INT_PATTERN = Pattern.compile("(\\d+)");

    /**
     * The integer type regex.
     */
    private static final String INT_TYPE_REGEX = "^[0-9]{0,9}$";

    /**
     * The positive integer regex.
     */
    private static final String POSITIVE_INT_REGEX = "^[1-9]{1}[0-9]{0,8}$";

    /**
     * The float regex.
     */
    private static final String FLOAT_REGEX = "^[0-9]+\\.?[0-9]*$";

    /**
     * IDENTITY_REGEXP
     */
    private static final String IDENTITY_REGEXP = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";

    static {
        String fixedTelephoneRegexp = "(\\d{3,4}-)?\\d{7,8}(-\\d{1,4})?";
        String merchantServicePhoneRegexp = "(\\d{4}-\\d{3}-\\d{3})|(\\d{3}-\\d{3}-\\d{4})|(\\d{10})";
        PHONE_REGEXP =
            "(" + merchantServicePhoneRegexp + ")|(" + MOBILE_PHONE_REGEXP + ")|(" + fixedTelephoneRegexp + ")";
        PHONE_PATTERN = Pattern.compile(PHONE_REGEXP);
    }

    /**
     * Private empty constructor.
     */
    private StringUtil() {
        // Hide constructor.
    }

    /**
     * To check if an email is valid
     *
     * @param email email
     * @return boolean (false if email is null or empty)
     */
    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        return email.matches(EMAIL_REGEXP);
    }

    /**
     * To check if a mobile number is valid
     *
     * @param mobilePhone mobile phone
     * @return boolean (false if mobile phone is null or empty)
     */
    public static boolean isValidMobilePhone(String mobilePhone) {
        if (isEmpty(mobilePhone)) {
            return false;
        }
        return mobilePhone.matches(MOBILE_PHONE_REGEXP);
    }

    /**
     * To check if a identity is valid
     *
     * @param identity identity
     * @return boolean (false if identity is null or empty)
     */
    public static boolean isValidIdentity(String identity) {
        if (isEmpty(identity)) {
            return false;
        }
        return identity.matches(IDENTITY_REGEXP);
    }

    /**
     * To check if a password is valid
     *
     * @param password password
     * @return boolean (false if password is null or empty)
     */
    public static boolean isValidPassword(String password) {
        if (isEmpty(password)) {
            return false;
        }
        return password.matches(PASSWORD_REGEXP);
    }

    /**
     * To check if a String is an integer
     *
     * @param value value
     * @return boolean (false if password is null or empty)
     */
    public static boolean isIntegerType(String value) {
        if (isEmpty(value)) {
            return false;
        }
        return value.matches(INT_TYPE_REGEX);
    }

    /**
     * To check if a String is constructed by digits
     *
     * @param value value
     * @return boolean
     */
    public static boolean isInteger(String value) {
        if (isEmpty(value)) {
            return false;
        }
        return INT_PATTERN.matcher(value).matches();
    }

    /**
     * To check if a String is an positive integer
     *
     * @param value value
     * @return boolean (false if value is not integer)
     */
    public static boolean isPositiveInteger(String value) {
        if (isEmpty(value)) {
            return false;
        }
        return value.matches(POSITIVE_INT_REGEX);
    }

    /**
     * To check if a String is an float
     *
     * @param value value
     * @return boolean (false if password is null or empty)
     */
    public static boolean isFloat(String value) {
        if (isEmpty(value)) {
            return false;
        }
        return value.matches(FLOAT_REGEX);
    }

    /**
     * This method is used to convert the null string to empty string.
     *
     * @param target the target string
     * @return the string.
     */
    public static String nullToEmpty(String target) {
        return target == null ? "" : target;
    }

    /**
     * This method is used to SBC to DBC.
     *
     * @param input the input text
     * @return the DBC string
     */
    public static String toDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);
        return returnString;
    }

    /**
     * This method is used to process user input text.
     *
     * @param text the user input text
     * @return the processed text
     */
    public static String normalizeInput(String text) {
        if (text == null) {
            return null;
        }
        text = text.replaceAll("\\s", " ").trim();
        if (text.isEmpty()) {
            return "";
        }
        return toDBC(text);
    }

    /**
     * This method is used to convert the html text to string.(Just remove $nbsp; for now.)
     *
     * @param htmlText the html text
     * @return the string text
     */
    public static String normalizeHtmlText(String htmlText) {
        if (htmlText == null) {
            return null;
        }
        return normalizeInput(htmlText.replaceAll("\u00a0", " ")).trim();
    }

    /**
     * This method is used to remove the content surrounded by parentheses.
     *
     * @param text the text to process
     * @return the processed text
     */
    public static String removeParenthesesContent(String text) {
        return text == null ? null : text.replaceAll("\\(.*?\\)", "").trim();
    }

    /**
     * This method is used to remove the content surrounded by square brackets.
     *
     * @param text the text to process
     * @return the processed text
     */
    public static String removeSquareBracketsText(String text) {
        return text == null ? null : text.replaceAll("\\[.*?\\]", "").trim();
    }

    /**
     * URL-encode the given string using UTF-8.
     *
     * @param string the string to be URL-encoded using UTF-8.
     * @return the given string, URL-encoded using UTF-8, or <code>null</code> if <code>null</code> was given.
     * @throws UnsupportedOperationException When UTF-8 is not supported.
     */
    public static String encodeURL(String string) {
        try {
            return string == null ? null : URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(ERROR_UNSUPPORTED_ENCODING, e);
        }
    }

    /**
     * This method is used to grab the first integer number in the text.
     *
     * @param text the text to grab
     * @return the integer value
     */
    public static Integer grabInt(String text) {
        if (text == null) {
            return null;
        }
        text = text.trim();
        Matcher m = INT_PATTERN.matcher(text);
        while (m.find()) {
            return Integer.parseInt(m.group());
        }
        return null;
    }

    /**
     * URL-decode the given string using UTF-8.
     *
     * @param string the string to be URL-decode using UTF-8.
     * @return the given string, URL-decode using UTF-8, or <code>null</code> if <code>null</code> was given.
     * @throws UnsupportedOperationException When UTF-8 is not supported.
     */
    public static String decodeURL(String string) {
        try {
            return string == null ? null : URLDecoder.decode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(ERROR_UNSUPPORTED_ENCODING, e);
        }
    }

    /**
     * This method is used to grab phones information from the input text.
     *
     * @param text the input text
     * @return the concentration of the phones.
     */
    public static String grabPhonesFromPage(String text) {
        if (isEmpty(text)) {
            return null;
        }
        text = normalizeHtmlText(text);
        Matcher m = PHONE_PATTERN.matcher(text);
        StringBuilder sb = null;
        while (m.find()) {
            if (sb == null) {
                sb = new StringBuilder(m.group());
                continue;
            }
            sb.append(", ");
            sb.append(m.group());
        }
        return sb == null ? null : sb.toString();
    }

    /**
     * This method is used to grab the Chinese Characters
     *
     * @param text the text to process
     * @return the Chinese Characters
     */
    public static String grabChineseCharacters(String text) {
        if (null == text) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Matcher matcher = Pattern.compile(CHINESE_CHARACTERS_REGEXP).matcher(text);
        while (matcher.find()) {
            builder.append(matcher.group(0));
        }
        return builder.toString();
    }

    /**
     * This method is used to grab double value
     *
     * @param text the text to be processed
     * @return the double value
     */
    public static Float grabDecimal(String text) {
        if (text == null) {
            return null;
        }
        text = text.trim();
        Matcher m = DECIMAL_PATTERN.matcher(text);
        while (m.find()) {
            return Float.parseFloat(m.group());
        }
        return null;
    }

    /**
     * This method is used to parse content by regex.
     *
     * @param pattern the regex pattern
     * @param text the text
     * @return the content
     */
    public static String parseContent(Pattern pattern, String text) {
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            return m.group();
        }
        return null;
    }

    /**
     * Converts the String list to String array.
     *
     * @param list the list to be converted
     * @return the converted string array
     */
    public static String[] toStringArray(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    /**
     * Converts the Long list to Long array.
     *
     * @param list the list to be converted
     * @return the converted Long array
     */
    public static Long[] toLongArray(List<Long> list) {
        return list.toArray(new Long[list.size()]);
    }

    /**
     * <p>
     * Concatenates the given values to a string.
     * </p>
     *
     * @param values the values.
     * @return the result.
     */
    public static String concat(Object... values) {
        StringBuilder sb = new StringBuilder();

        for (Object value : values) {
            sb.append(value);
        }

        return sb.toString();
    }

    /**
     * 该方法用于16进制字符串转换成字符串
     *
     * @param hexStr 16进制
     * @return string
     * @throws UnsupportedEncodingException if any error occurs
     */
    public static String hexStr2Str(String hexStr) throws UnsupportedEncodingException {
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;

        for (int i = 0; i < bytes.length; i++) {
            n = HEX_CHARS.indexOf(hexs[2 * i]) * 16;
            n += HEX_CHARS.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }

        return new String(bytes, "UTF-8");
    }

    /**
     * 该方法用于字符串转换成16进制字符串
     *
     * @param b b
     * @return 16进制字符串
     */
    public static String toHexString(byte[] b) {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            stringbuffer.append(HEX_CHARS.charAt(b[i] >>> 4 & 0x0F));
            stringbuffer.append(HEX_CHARS.charAt(b[i] & 0x0F));
        }
        return stringbuffer.toString();
    }

    /**
     * E4B88AE6B5B7 --> 上海<br/>
     * 区别于%E4%B8%8A%E6%B5%B7 ---> 上海
     *
     * @param s UTF8字串
     * @return 原字串
     */
    public static String convertUTF8ToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        try {
            s = s.toUpperCase();
            int total = s.length() / 2;
            int pos = 0;
            byte[] buffer = new byte[total];
            for (int i = 0; i < total; i++) {
                int start = i * 2;
                buffer[i] = (byte) Integer.parseInt(s.substring(start, start + 2), 16);
                pos++;
            }
            return new String(buffer, 0, pos, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 将文件名中的汉字转为UTF8编码的串<br/>
     * 上海 --> E4B88AE6B5B7<br/>
     * 区别于上海 ---> %E4%B8%8A%E6%B5%B7
     *
     * @param c 原字符
     * @return UTF8字串
     */
    public static String convertCharToUTF8(char c) {
        StringBuffer sb = new StringBuffer();
        try {
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                b = Character.toString(c).getBytes("utf-8");
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) {
                        k += 256;
                    }
                    sb.append(Integer.toHexString(k).toUpperCase());
                }
            }
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }

    /**
     * base64EncodeChars
     */
    private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '+', '/' };

    /**
     * 该方法用于base64编码
     *
     * @param data data
     * @return String
     */
    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }

    /**
     * Returns a String where those characters that QueryParser expects to be escaped are escaped by a preceding
     * <code>\</code>.
     *
     * @param s 字符串
     * @return 转义后的字符串
     */
    public static String elasticsearchQueryEscape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // These characters are part of the query syntax and must be escaped
            if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')' || c == ':' || c == '^'
                || c == '[' || c == ']' || c == '\"' || c == '{' || c == '}' || c == '~' || c == '*' || c == '?'
                || c == '|' || c == '&' || c == '/') {
                sb.append('/');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 该方法用于把汉字转成拼音
     *
     * @param str str
     * @return String
     */
    public static String convertHanziToPinyin(String str) {
        return PinyinUtil.toPinYin(str);
    }
}
