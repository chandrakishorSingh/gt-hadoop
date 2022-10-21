import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class PutExample {
    public static void main(String[] args) {
        try {
//            System.out.println("OK");
            Configuration conf = HBaseConfiguration.create();
            Connection connection = ConnectionFactory.createConnection(conf);

//            Admin admin = connection.getAdmin();

            Table table = connection.getTable(TableName.valueOf("notifications"));

            Put put = new Put(Bytes.toBytes("2"));

            put.addColumn(Bytes.toBytes("attributes"), Bytes.toBytes("type"), Bytes.toBytes("Comment"));
            put.addColumn(Bytes.toBytes("attributes"), Bytes.toBytes("for_user"), Bytes.toBytes("Chaz"));
            put.addColumn(Bytes.toBytes("metrics"), Bytes.toBytes("open"), Bytes.toBytes("0"));

            table.put(put);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
