package eti.aguiar.imageinfo.jpeg;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.File;
import java.io.IOException
import java.util.HashMap;

public class JpegInfo {

    public static void main(String[] args) {
        String fileName = "";
        try{
            fileName = "D:\\Documentos\\Pictures\\Fotos\\iPhone\\IMG_0723.JPG";
            JpegInfo info = new JpegInfo();
            info.getInfoJepg(fileName);
        }catch(Exception e){
            System.out.println("ATENÇÃO: Informe o caminho completo até a imagem JPG");
            System.exit(0);
        }
        
    }

    public void getInfoJepg(String fileName){
        
        //javaxt.io.Image image = new javaxt.io.Image("D:\\iPhone\\DCIM\\965YOKDJ\\IMG_2655.JPG");
        javaxt.io.Image image = new javaxt.io.Image(fileName);

        double[] gps = image.getGPSCoordinate();

        HashMap map = image.getGpsTags();

        System.out.println("Latitude.:" + gps[0]);
        System.out.println("Longitude:" + gps[1]);
        System.out.println("-----------------outras informações----------------------");
        File jpegFile = 
            new File(fileName); //("D:\\iPhone\\DCIM\\965YOKDJ\\IMG_2655.JPG");
        Metadata metadata;
        try {
            metadata = ImageMetadataReader.readMetadata(jpegFile);
            for (Directory directory: metadata.getDirectories()) {
                for (Tag tag: directory.getTags()) {
                    //System.out.println(tag);
                    System.out.println(tag.getTagName() + " : " + 
                                       tag.getDescription());
                }
            }
        } catch (IOException e) {
            // TODO
        } catch (ImageProcessingException e) {
            // TODO
        }    
    }
}



/*
 Directory directory;
 // Keywords
 directory = metadata.getDirectory(IptcDirectory.class);
 String keywords[] = directory.getStringArray(IptcDirectory.TAG_KEYWORDS);

 // Dimensions
 directory = metadata.getDirectory(JpegDirectory.class);     
 String height = directory.getString(JpegDirectory.TAG_JPEG_IMAGE_HEIGHT);
 String width = directory.getString(JpegDirectory.TAG_JPEG_IMAGE_WIDTH); */
