/*ɫ�ʿռ�
 * ����ɫ�ʿռ䣺RGB, HSV, HIS, YCrCb, YUV(Linux/Android)
 * ������໥ת����HSV��RGB��YUV��RGB
 * 
 * 
 * */

package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ColorSpace1 {
	public static void main(String[] args) {
		//�������֣�����OpenCV��dll��
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		//imread:����
		Mat src = Imgcodecs.imread("D:\\OpenCV\\1.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);//�Ҷȣ��ڰף�ͼ��CV_LOAD_IMAGE_GRAYSCALE

		ImageUI ui = new ImageUI();
		ui.imshow("Gunners", src);
		
		Mat dst = new Mat();
		//��ɫͼ���Ϊ�Ҷ�ͼ��
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		ImageUI GrayoutputWin = new ImageUI();
		GrayoutputWin.imshow("GunnersGrayResult", dst);
		
		
		Mat dst2 = new Mat();
		
		/*��ɫͼ���ΪHSVͼ��
		HSV:
		H:��תһ��(360��)  OpenCV�з�Χ��0-180
		S:���Ͷ�(0-1) OpenCV�з�Χ��0-255
		V:Value OpenCV�з�Χ��0-255*/
		
		Imgproc.cvtColor(src, dst2, Imgproc.COLOR_BGR2HSV);
		
		ImageUI HSVoutputWin = new ImageUI();
		
		HSVoutputWin.imshow("GunnersHSVResult", dst2);
		
		
		Mat dst3 = new Mat();
		
		/*��ɫͼ���ΪHLSͼ��
		HLS:
		H:��תһ��(360��)  OpenCV�з�Χ��0-180
		L:����(0-1) OpenCV�з�Χ��0-255
		S:Value OpenCV�з�Χ��0-255*/
		
		Imgproc.cvtColor(src, dst3, Imgproc.COLOR_BGR2HLS);
				
		ImageUI HLSoutputWin = new ImageUI();
		
		HLSoutputWin.imshow("GunnersHLSResult", dst3);
		
		Mat dst4 = new Mat();
		
		/*��ɫͼ���ΪHLSͼ��
		HLS:
		H:��תһ��(360��)  OpenCV�з�Χ��0-180
		L:����(0-1) OpenCV�з�Χ��0-255
		S:Value OpenCV�з�Χ��0-255*/
		
		Imgproc.cvtColor(src, dst4, Imgproc.COLOR_BGR2YUV);
				
		ImageUI YUVoutputWin = new ImageUI();
		
		YUVoutputWin.imshow("GunnersYUVResult", dst4);
		
		//inRange
		Mat binary = new Mat();
		Core.inRange(dst, new Scalar(30, 45, 45), new Scalar(180, 255, 255), binary);
		
		ImageUI outputinRange = new ImageUI();
		outputinRange.imshow("RangeResult", binary);
	}
}
