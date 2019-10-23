package OpenCVTest1;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Range1 {
	public static void rangetest(Mat m,int i) {
		Mat gray = new Mat();
		Imgproc.cvtColor(m, gray, Imgproc.COLOR_BGR2GRAY);
		
		Rect rect = new Rect(0,0,140,130);
		Mat card = gray.submat(rect);
		
//		ImageUI mShow = new ImageUI();
//		mShow.imshow("card", card);
		for(i=0;i<4;i++)
			Imgcodecs.imwrite("./OpenCV/"+i+"ocr.jpg", card);
		gray.release();
		card.release();
	}
}
