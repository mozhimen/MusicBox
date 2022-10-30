package com.imooc.lib_network.okhttp.cookie;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * @ClassName SimpleCookieJar
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/28 22:51
 * @Version 1.0
 */
public final class SimpleCookieJar implements CookieJar {
    private final List<Cookie> allCookies = new ArrayList<Cookie>();


    private static List<Cookie> cookies;

    public static List<Cookie> getCookies() {
        return cookies != null ? cookies : new ArrayList<Cookie>();
    }

    public static void setCookies(List<Cookie> cookies) {
        SimpleCookieJar.cookies = cookies;
    }

    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        allCookies.addAll(cookies);
        setCookies(cookies);
    }

    @Override
    public synchronized List<okhttp3.Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> result = new ArrayList<Cookie>();
        for (Cookie cookie : allCookies) {
            if (cookie.matches(url)) {
                result.add(cookie);
            }
        }
        return result;
    }
}
