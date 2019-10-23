package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class CannyTest1 {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//输入图像
		Mat src = Imgcodecs.imread("d:\\OpenCV\\8.png");
		if(src.empty()) {
			return;
		}

		
		//得到灰度图像
//		Mat gray = new Mat();
//		Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
//		ImageUI win = new ImageUI();
//		win.imshow("input", gray);
		
		ImageUI win = new ImageUI();
		win.imshow("input image", src);
		
		Mat dst = new Mat();
		Imgproc.GaussianBlur(src, dst, new Size(3, 3), 0);
		
		Mat gray = new Mat();
		Imgproc.cvtColor(dst, gray, Imgproc.COLOR_BGR2GRAY);
		
		Mat xgrad = new Mat();
		Imgproc.Sobel(gray, xgrad, CvType.CV_8U, 1, 0);
		
		Mat ygrad = new Mat();
		Imgproc.Sobel(gray, ygrad, CvType.CV_8U, 0, 1);
		
		Mat output = new Mat();
//		Imgproc.Canny(gray, output, 50, 150, 3, true);
		Imgproc.Canny(dst, output, 50, 150);
		ImageUI edge = new ImageUI();
		edge.imshow("edge", output);
	}
}
