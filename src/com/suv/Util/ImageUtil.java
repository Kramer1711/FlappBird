package com.suv.Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by Kramer on 2016/12/10.
 */
public class ImageUtil {
    public static BufferedImage load(String file){
        try{
            return ImageIO.read(ImageUtil.class.getResourceAsStream("/"+file));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static int[] getCenter(int[] center){
        int[] flag = center;
        return flag;
    }
}
