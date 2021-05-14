package com.bigdata.hadoop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class SaveFileLocalToHDFS {

    private static final String HDFS_PATH = "hdfs://localhost:9000";
    private static final String HDFS_USER = "root";
    private static FileSystem fileSystem;

    static {

        try {
            Configuration configuration = new Configuration();
            configuration.set("dfs.replication", "1");
            fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration,
                    HDFS_USER);
        } catch (IOException e) {
            // TODO Code your exception plan and logging
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Code your exception plan and logging
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Code your exception plan and logging
            e.printStackTrace();
        }
    }

    public static FileSystem getFileSystem() {
        return fileSystem;
    }

    public static boolean mkdir(String path) throws Exception {
        return fileSystem.mkdirs(new Path(path));
    }

    /**
     * Copy from local file to HDFS.
     *
     * @param localPath the local path
     * @param hdfsPath the hdfs path
     * @throws Exception any file system exception
     */
    public static void copyFromLocalFile(String localPath, String hdfsPath)
            throws Exception {
        fileSystem.copyFromLocalFile(new Path(localPath), new Path(hdfsPath));
    }

    /**
     * Copy from HDFS file to local.
     *
     * @param hdfsPath the hdfs path
     * @param localPath the local path
     * @throws Exception any file system exception
     */
    public void copyToLocalFile(String hdfsPath, String localPath)
            throws Exception {
        fileSystem.copyToLocalFile(new Path(hdfsPath), new Path(localPath));
    }

    public static void main(String[] args) {

        try {
            //mkdir("/hadoop/dfs/name/dictionary");

            Path src = new Path("/Users/diatics/dia-git/JavaBigDataUtils/src/main/resources/Websters_Unabridged_Dictionary.txt");
            Path dst = new Path("/hadoop/dfs/name/dictionary");

            copyFromLocalFile(String.valueOf(src),String.valueOf(dst));
        } catch (Exception e) {
            // TODO Code your exception plan and logging
            e.printStackTrace();
        }

    }

}
