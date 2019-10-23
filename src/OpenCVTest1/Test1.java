package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test1 {
	public static void main(String[] args) {
//		�������֣�����OpenCV��dll��
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		imread:����
		Mat src = Imgcodecs.imread("D:\\OpenCV\\1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);//�Ҷȣ��ڰף�ͼ��CV_LOAD_IMAGE_GRAYSCALE

//		Rect:���ƾ���
		Rect rect = new Rect(10, 10, 200, 200);
		
//		public static void rectangle(Mat img, Point pt1, Point pt2, Scalar color, int thickness, int lineType, int shift)
		Imgproc.rectangle(src, rect.tl(), rect.br(), new Scalar(0), 2, Imgproc.LINE_8, 0);//Scalar:0-255 ->�ڵ���

//		imwrite:����
		Imgcodecs.imwrite("D:\\OpenCV\\1_result2.jpg", src);

		src.release();
	}
}
