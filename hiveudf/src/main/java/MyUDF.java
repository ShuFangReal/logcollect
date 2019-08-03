import org.apache.hadoop.hive.ql.exec.UDF;

public class MyUDF extends UDF {
    public String evaluate(String a){


        return a.toUpperCase();
    }

    public static void main(String[] args) {
        MyUDF myUDF = new MyUDF();
        System.out.println(myUDF.evaluate("helloworld"));
    }
}
