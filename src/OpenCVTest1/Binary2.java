package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Binary2 {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//输入图像
		Mat src = Imgcodecs.imread("d:\\OpenCV\\A.png");
		if(src.empty()) {
			return;
		}
		
		//得到灰度图像
		Mat gray = new Mat();
		Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
		ImageUI win = new ImageUI();
		win.imshow("input", gray);
		
		Mat dst = new Mat();
		Imgproc.adaptiveThreshold(gray, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 5, 10);
		//高斯：均值M必须为奇数
		//Imgproc.adaptiveThreshold(gray, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 5, 10);
		
		ImageUI binWin = new ImageUI();
		binWin.imshow("binary", dst);
		Imgcodecs.imwrite("D:\\OpenCV\\A_result.png", dst);
	}
}
