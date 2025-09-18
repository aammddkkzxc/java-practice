package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesCopyPractice1 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");
        //파일의 데이터를 자바로 불러오고 또 자바에서 읽은 데이터를 다시 파일에 전달
        fis.transferTo(fos);
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }

}
