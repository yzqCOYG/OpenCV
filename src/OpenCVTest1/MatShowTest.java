package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;


public class MatShowTest {
	public static void main(String[] args) {
//		必做部分：加载OpenCV的dll库
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		imread:加载
		Mat src = Imgcodecs.imread("D:\\OpenCV\\1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);//灰度（黑白）图像：CV_LOAD_IMAGE_GRAYSCALE

		ImageUI ui = new ImageUI();
		ui.imshow("Gunners", src);
		
		Mat src1 = Imgcodecs.imread("D:\\OpenCV\\2.jpg");
		ImageUI ui2 = new ImageUI();
		ui2.imshow("FIFA19", src1);
	}
}
