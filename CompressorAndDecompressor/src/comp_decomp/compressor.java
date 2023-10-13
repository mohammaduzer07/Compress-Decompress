package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
public class compressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();

        FileInputStream FIS = new FileInputStream(file);
        FileOutputStream FOS = new FileOutputStream(fileDirectory +"/CompressedFile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(FOS);

        byte[] buffer = new byte[1024];
        int len;
        while((len = FIS.read(buffer)) != -1){
            gzip.write(buffer, 0, len);

        }
        gzip.close();
        FOS.close();
        FIS.close();

    }
    public static void main(String[] args) throws IOException {
        File path = new File("C:/Users/uzerk/oneDrive/Documents/Compressor/compressordecompressor/CompressedFile.gz");
        method(path);
    }
}
