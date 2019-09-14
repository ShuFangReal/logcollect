package com.shufang.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TypeInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        Map<String, String> headers = event.getHeaders();
        byte[] body = event.getBody();
        String log = new String(body, Charset.forName("UTF-8"));
        //区分类型
        if (log.contains("start")) {
            headers.put("topic", "topic_start");
        } else {
            headers.put("topic", "topic_event");
        }
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        ArrayList<Event> events = new ArrayList<>();
        for (Event event : list) {
            events.add(event);
        }
        return events;
    }

    @Override
    public void close() {

    }

    public class Builder implements Interceptor.Builder{
        @Override
        public Interceptor build() {
            return new TypeInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
