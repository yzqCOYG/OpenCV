package Test;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
 
/** 
* 绫昏鏄� 锛� tess4j娴嬭瘯绫�
*/
public class Tess4JTest1 {
   public static String test(int i) throws TesseractException {
	   
        ITesseract instance = new Tesseract();
        //濡傛灉鏈皢tessdata鏀惧湪鏍圭洰褰曚笅闇�瑕佹寚瀹氱粷瀵硅矾寰�
        //instance.setDatapath("the absolute path of tessdata");
        
        //濡傛灉闇�瑕佽瘑鍒嫳鏂囦箣澶栫殑璇锛岄渶瑕佹寚瀹氳瘑鍒绉嶏紝骞朵笖闇�瑕佸皢瀵瑰簲鐨勮瑷�鍖呮斁杩涢」鐩腑
        //instance.setLanguage("chi_sim");
        
        // 鎸囧畾璇嗗埆鍥剧墖
        String ocrResult = null;
        for(i=0;i<4;i++) {
        	File imgDir = new File("./OpenCV/"+i+"ocr.jpg");
        	instance.setLanguage("chi_sim");
        	ocrResult = instance.doOCR(imgDir);
        } 
        // 杈撳嚭璇嗗埆缁撴灉
//        System.out.println(ocrResult);
//        return ocrResult;
		return ocrResult;
    }
}

