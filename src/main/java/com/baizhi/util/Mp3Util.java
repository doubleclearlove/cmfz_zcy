package com.baizhi.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Mp3Util {

    public static double getSize(String realpath,String filename) throws Exception{
        FileInputStream fis= null;
        double size=0.0;
        try{
            File f= new File(realpath+"/"+filename);
            fis= new FileInputStream(f);
            size=fis.available()/1024.0/1024.0;
        }catch(Exception e){
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
        return size;
    }
    public static double getDuration(String realpath,String filename){
        File file = new File(realpath+"/"+filename);
        double duration=0.0;
        try {
            MP3File f = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            duration=audioHeader.getTrackLength()/60.0;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return duration;
    }
}
