package OpenCVTest1;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import Test.Tess4JTest1;

public class main {
	public static void main(String[] args) throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		File f=new File("out.txt");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        
//		Release.releaseRank();
				
		int rank[] = new int[4];
		String path = "";
		for(int i = 0;i < 4;i++) {
			path = "./OpenCV/"+i+".jpg";
//			Mat src = Imgcodecs.imread(path);
//			if(src.empty()) {
//				return;
//			}
			ChangePictureSize.SizeAdaption(path);
			Mat dst = new Mat();
			dst = Imgcodecs.imread("./OpenCV/"+i+"size.jpg");
			FindCardTest.findCard(dst,i);

//		ImageUI win = new ImageUI();
//		win.imshow("output", src);
		
//		Mat src1 = Imgcodecs.imread("./OpenCV/FindResult.jpg");
//		if(src1.empty()) {
//			return;
//		}
//		Mat gray = new Mat();
//		Imgproc.cvtColor(src1, gray, Imgproc.COLOR_BGR2GRAY);
//		splitCard.splitCard(gray, 1, "num", "flag");
//		ImageUI rangewin = new ImageUI();
//		rangewin.imshow("range", src1);
//		Imgcodecs.imwrite("./OpenCV/range.jpg", src1);
		
		
			Mat src2 = Imgcodecs.imread("./OpenCV/"+i+"find.jpg");
			if(src2.empty()) {
				return;
			}
		
			Range1.rangetest(src2, i);
//		ImageUI wins = new ImageUI();
//		wins.imshow("output", gray);
//		Imgcodecs.imwrite("./OpenCV/target.jpg", src2);
		
			String Num = Tess4JTest1.test(i);
//			System.out.println(Num);
			char[] arr = new char[10];
			if(Num.contains("A") || Num.contains("2") || Num.contains("3")|| Num.contains("4")|| Num.contains("5")|| Num.contains("6")|| Num.contains("7")|| Num.contains("8")|| Num.contains("9")|| Num.contains("10")|| Num.contains("J")|| Num.contains("Q")|| Num.contains("K")) {
				arr = Num.toCharArray();
//				System.out.println(arr[0]);		
			}
			else {
				System.out.println("Ê¶±ðÊ§°Ü");
			}
			
			rank[i] = (arr[0]) - 48;
		}
		count.Count24(rank[0],rank[1],rank[2],rank[3]);
		


//		String path = "./OpenCV/8club.jpg";
//		Mat src = Imgcodecs.imread(path, Imgcodecs.CV_LOAD_IMAGE_COLOR);
//		ChangePictureSize.SizeAdaption(path);
//			Mat m = new Mat();
//			m = src;
//			FindCardTest.findCard(m); 
//			int result = splitCard.splitCard(m, 1, "num", "flag");
//		System.out.println(result);
	}
}
