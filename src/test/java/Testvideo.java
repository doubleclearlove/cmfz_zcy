import com.baizhi.util.Md5Util;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Testvideo {
  /*  @Test
    public void testutil() throws Exception {
        String realpath="C:/Users/Administrator/Desktop";
        String filename="1.mp3";
        System.out.println(Mp3Util.getSize(realpath, filename));
    }*/
    @Test
    //获取文件大小
    public void test() {
        FileInputStream fis= null;
        try{
            File f= new File("C:/Users/Administrator/Desktop/1.mp3");
            fis= new FileInputStream(f);
            //logger.info();
            System.out.println("文件大小"+fis.available());
        }catch(Exception e){
           // logger.error(e);
            System.out.println(e);
        } finally{
            if (null!=fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    //logger.error(e);
                    System.out.println(e);
                }
            }
        }
    }
//获取文件时长3
   /* @Test
    public void testduration(){
        String realpath="C:/Users/Administrator/Desktop";
        String filename="1.mp3";
        System.out.println(Mp3Util.getDuration(realpath, filename));
    }*/

    @Test
    public void Tess(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\1.mp3");
        try {
            MP3File f = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            System.out.println(audioHeader.getTrackLength());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
@Test
    public void testMd5() throws NoSuchAlgorithmException {
        String password="12345678";
        byte[] code=null;
        code=MessageDigest.getInstance("md5").digest(password.getBytes());
        String md5code=new BigInteger(1,code).toString(16);
        for (int i=0;i<32 - md5code.length();i++){
            md5code="0"+md5code;
        }
        System.out.println(md5code);

}

@Test
    public void test111(){
    System.out.println(Md5Util.getMd5Password("123456"));
}




}
