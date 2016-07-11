package demo.lm.viedeodemo.utils;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/5/13.
 */

    public class TimeUtils {
        public static long getCurrentTime() {
            return System.currentTimeMillis();
        }


        public static String getTimestamp() {
            return new Timestamp(getCurrentTime()).toString();
        }
    }


