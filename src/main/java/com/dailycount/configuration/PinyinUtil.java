package com.dailycount.configuration;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转化为拼音的工具类
 */
public class PinyinUtil {

    /**
     * format
     */
    private static HanyuPinyinOutputFormat format = null;

    static {
        format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    /**
     * 该方法用于把汉字转成拼音
     *
     * @param str str
     * @return String 汉字
     */
    public static String toPinYin(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        String[] convertArray;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= 128) {
                result.append(c);
            } else {
                try {
                    convertArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    continue;
                }

                if (convertArray.length > 0) {
                    result.append(convertArray[0]);
                }
            }
        }
        return result.toString();
    }

}