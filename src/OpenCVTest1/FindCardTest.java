package OpenCVTest1;

import java.util.ArrayList;
import java.util.Iterator;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Range;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class FindCardTest {

	
	public static void findCard(Mat m, int i) {
		Mat gray = new Mat();
		Mat bin = new Mat();
		Imgproc.cvtColor(m, gray, Imgproc.COLOR_BGR2GRAY);
		
//		ImageUI grayShow = new ImageUI();
//		grayShow.imshow("gray", gray);
		
		Imgproc.threshold(gray, bin, 80, 255, Imgproc.THRESH_BINARY);
		
		ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		
		Mat hierarchy = new Mat();
		
		Imgproc.findContours(bin, contours, hierarchy, 0, 1);
//		Imgproc.findContours(image, contours, hierarchy, mode, method);
				
		int up = 2000;
		int down = 0;
		int right = 0;
		int left = 2000;
		
		for(Iterator<MatOfPoint> List = contours.iterator(); List.hasNext();) {			
			Rect rect = Imgproc.boundingRect((List.next()));
			Point tl = rect.tl();
			Point br = rect.br();
			if(up > tl.y) {
				up = (int) tl.y;
			}
			if(down < br.y) {
				down = (int)br.y;
			}
			if(left > tl.x) {
				left = (int)tl.x;
			}
			if(right < br.x) {
				right = (int)br.x;
			}
		}
//		if(up == 2000 || left == 2000) {
//			return -1;
//		}

		Mat card = gray.submat(new Range(up + 10, down), new Range(left + 2, right));
		
		Imgproc.threshold(card, card, 150, 255, Imgproc.THRESH_BINARY);
		
		Mat mask = new Mat();
		
		Imgproc.floodFill(card, mask, new Point(0, 0), new Scalar(255, 255, 255));
		Imgproc.floodFill(card, mask, new Point(0, card.rows()-1), new Scalar(255, 255, 255));
		Imgproc.floodFill(card, mask, new Point(card.cols()-1, 0), new Scalar(255, 255, 255));
		Imgproc.floodFill(card, mask, new Point(card.cols()-1, card.rows()-1), new Scalar(255, 255, 255));
		
//		ImageUI mShow = new ImageUI();
//		mShow.imshow("card", card);
		
		for(i=0;i<4;i++)
			Imgcodecs.imwrite("./OpenCV/"+i+"find.jpg", card);
//		return 0;
	}
	
}
