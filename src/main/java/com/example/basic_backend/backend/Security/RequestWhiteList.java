package com.example.basic_backend.backend.Security;

import java.util.Arrays;
import java.util.List;

/**
 * @程志豪 时间：2019 07 24 11:10
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
public class RequestWhiteList {
        private static List<String> whitelist = Arrays.asList(
                "/data/add",
                "/user/login"

        );

        public static List<String> get() {
            return whitelist;
        }
}
