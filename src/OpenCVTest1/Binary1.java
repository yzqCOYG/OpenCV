package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Binary1 {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//输入图像
		Mat src = Imgcodecs.imread("d:\\OpenCV\\rec.png");
		if(src.empty()) {
			return;
		}
		
		Mat gray = new Mat();
		Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
		ImageUI win = new ImageUI();
		win.imshow("input", gray);
		
		Mat dst = new Mat();
		Imgproc.threshold(gray, dst, 127, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);//Triangle
		ImageUI binWin = new ImageUI();
		binWin.imshow("binary", dst);
		Imgcodecs.imwrite("D:\\OpenCV\\rec_result.png", dst);
	}
}
