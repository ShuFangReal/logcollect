package com.shufang.udtf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.json.JSONArray;
import org.json.JSONException;

public class MyUDTF extends GenericUDTF {
    @Override
    public void process(Object[] args) throws HiveException {

    }

    //这个要标明返回值的名字，以及返回值的类型 如 event_name（事件类型名称 如：dispaly）   event_json(时间内容)
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        return super.initialize(argOIs);
    }

    @Override
    public void close() throws HiveException {

    }

    public static void main(String[] args) {
        try {
            JSONArray jsonArray = new JSONArray("[{\"ett\":\"1541146624055\",\"en\":\"display\",\"kv\":{\"copyright\":\"ESPN\",\"content_provider\":\"CNN\",\"extend2\":\"5\",\"goodsid\":\"n4195\",\"action\":\"2\",\"extend1\":\"2\",\"place\":\"3\",\"showtype\":\"2\",\"category\":\"72\",\"newstype\":\"5\"}},{\"ett\":\"1541213331817\",\"en\":\"loading\",\"kv\":{\"extend2\":\"\",\"loading_time\":\"15\",\"action\":\"3\",\"extend1\":\"\",\"type1\":\"\",\"type\":\"3\",\"loading_way\":\"1\"}},{\"ett\":\"1541126195645\",\"en\":\"ad\",\"kv\":{\"entry\":\"3\",\"show_style\":\"0\",\"action\":\"2\",\"detail\":\"325\",\"source\":\"4\",\"behavior\":\"2\",\"content\":\"1\",\"newstype\":\"5\"}},{\"ett\":\"1541202678812\",\"en\":\"notification\",\"kv\":{\"ap_time\":\"1541184614380\",\"action\":\"3\",\"type\":\"4\",\"content\":\"\"}},{\"ett\":\"1541194686688\",\"en\":\"active_background\",\"kv\":{\"active_source\":\"3\"}}]");

            System.out.println(jsonArray.get(0));
        } catch (JSONException e) {


        }


    }
}
