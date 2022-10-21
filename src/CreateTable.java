import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class CreateTable {
    public static void main(String[] args) {
        try {
//            System.out.println("OK");
            Configuration conf = HBaseConfiguration.create();
            Connection connection = ConnectionFactory.createConnection(conf);

            Admin admin = connection.getAdmin();

            HTableDescriptor tableName = new HTableDescriptor(TableName.valueOf("notifications"));

            tableName.addFamily(new HColumnDescriptor("attributes"));
            tableName.addFamily(new HColumnDescriptor("metrics"));

            if (!admin.tableExists(tableName.getTableName())) {
                System.out.println("Create table...");
                admin.createTable(tableName);
                System.out.println("Done.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
