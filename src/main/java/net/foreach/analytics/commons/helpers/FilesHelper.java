package net.foreach.analytics.commons.helpers;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by aitor on 26/2/17.
 */
public class FilesHelper {

    private static final Logger logger= LogManager.getLogger(FilesHelper.class);

    public static FSDataInputStream getFile(String filePath) throws IOException {
        return getFile(new Configuration(), filePath);
    }

    public static FSDataInputStream getFile(Configuration conf, String filePath) throws IOException {
        Path path= new Path(filePath);
        FileSystem fileSystem= path.getFileSystem(conf);
        return fileSystem.open(path);
    }

    public static boolean copyFile(String sourcePath, String destPath) throws IOException {
        return copyFile(new Configuration(), sourcePath, destPath);
    }

    public static boolean copyFile(Configuration conf, String sourcePath, String destPath) throws IOException {
        logger.info(String.format("Copying file from %s to %s", sourcePath, destPath));

        FileSystem fs= FileSystem.get(conf);
        fs.copyFromLocalFile(false, new Path(sourcePath), new Path(destPath));
        return true;
    }
}
