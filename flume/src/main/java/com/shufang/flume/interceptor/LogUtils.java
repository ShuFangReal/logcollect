package com.shufang.flume.interceptor;

import org.apache.commons.lang.math.NumberUtils;

/**
 * 工具类，用来校验日志数据是否规范 不规范的就舍弃
 */
public class LogUtils {

    public static boolean judgeStart(String log) {
        if (log == null) return false;

        //{json}格式
        if (!log.trim().startsWith("{") && !log.trim().endsWith("}")) return false;
        return true;
    }

    public static boolean judgeEvent(String log) {

        //首先要切割 ，但是|在正则里面需要转移，是特殊字符  => "\\|"
        if (log == null) return false;

        //13位时间戳 | {json}
        String[] split = log.split("\\|");

        //切割之后数组长度不为2，舍弃
        if (split.length != 2) return false;

        //时间戳不全为数字 或者 时间戳不为13位 舍弃
        if (split[0].trim().length() != 13 || !NumberUtils.isDigits(split[0].trim())) return false;

        if (!split[1].trim().startsWith("{") || !split[1].trim().endsWith("}")) return false;
        return true;
    }
}
