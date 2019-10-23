package OpenCVTest1;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;

public class FloodFillDemo {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat src = Imgcodecs.imread("D:\\OpenCV\\1.jpg");
		if(src.empty()) {
			return;
		}
		ImageUI win = new ImageUI();
		win.imshow("input", src);
		
		Rect rect = new Rect(120, 40, 200, 200);
		Mat roi = src.submat(rect);
		ImageUI roiWin = new ImageUI();
		roiWin.imshow("output", roi);
	}
}
