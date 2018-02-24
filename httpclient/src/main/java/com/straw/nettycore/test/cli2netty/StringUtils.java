package com.straw.nettycore.test.cli2netty;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lanxiaowei
 * @ClassName: StringUtils
 * @Description: 字符串处理工具类
 * @date 2013-3-15 下午01:00:54
 */
@SuppressWarnings({"rawtypes", "deprecation"})
public class StringUtils {
    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: getCharsetFromContentType
     * @Description: 从Content-Type中提取字符集编码
     * @param contentType  content-Type值
     * @return String
     * @throws
     */
    private static final Pattern patternForCharset = Pattern.compile("charset\\s*=\\s*['\"]*([^\\s;'\"]*)");

    public static String getCharsetFromContentType(String contentType) {

        Matcher matcher = patternForCharset.matcher(contentType);
        if (matcher.find()) {
            String charset = matcher.group(1);
            if (Charset.isSupported(charset)) {
                return charset;
            }
        }
        return null;
    }
}
