package com.shufang.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ETLInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    /**
     * 处理单个event的拦截方法
     *
     * @param event
     * @return
     */
    @Override
    public Event intercept(Event event) {
        //获取数据
        byte[] body = event.getBody();
        String log = new String(body, Charset.forName("UTF-8"));

        //校验数据 分别校验start，event数据
        if (log.contains("start")) {
            if (LogUtils.judgeStart(log)) {
                return event;
            }
        } else {
            if (LogUtils.judgeEvent(log)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        ArrayList<Event> events = new ArrayList<>();
        for (Event event : list) {
            Event intercept = intercept(event);
            if (intercept != null) events.add(intercept);
        }
        return events;
    }

    @Override
    public void close() {

    }

    /**
     * 静态内部类Builder implements Interceptor.Builder必须写，保证集群能找到这个拦截器
     */
    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new ETLInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
