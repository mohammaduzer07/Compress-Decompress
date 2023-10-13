package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
public class decompressor {
    public static void method(File file)throws IOException{
        String fileDirect = file.getParent();

        FileInputStream FIS = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(FIS);
        String fileDirectory = null;
        FileOutputStream FOS = new FileOutputStream(fileDirect+"/DecompressedFile");

        byte[] buffer = new byte[1024];
        int len;
        while((len = gzip.read(buffer)) != -1){
            FOS.write(buffer, 0, len);
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
