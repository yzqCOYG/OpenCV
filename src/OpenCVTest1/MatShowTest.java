package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;


public class MatShowTest {
	public static void main(String[] args) {
//		�������֣�����OpenCV��dll��
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		imread:����
		Mat src = Imgcodecs.imread("D:\\OpenCV\\1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);//�Ҷȣ��ڰף�ͼ��CV_LOAD_IMAGE_GRAYSCALE

		ImageUI ui = new ImageUI();
		ui.imshow("Gunners", src);
		
		Mat src1 = Imgcodecs.imread("D:\\OpenCV\\2.jpg");
		ImageUI ui2 = new ImageUI();
		ui2.imshow("FIFA19", src1);
	}
}
