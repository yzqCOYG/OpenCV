package OpenCVTest1;

import java.util.ArrayList;
import java.util.Iterator;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Range;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class splitCard {
	public static int splitCard(Mat m, int i, String num_path, String flag_path) {
		
		
		Imgproc.threshold(m, m, 150, 255, Imgproc.THRESH_BINARY);
		
		ArrayList<MatOfPoint> contours_Num = new ArrayList<MatOfPoint>();
		
		Mat hierarchy_Num = new Mat();
		
		Imgproc.findContours(m, contours_Num, hierarchy_Num, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_NONE);
		
		int up = 1000;
		int down = 1000;
		int right = 1000;
		int left = 1000;
		
		for(Iterator<MatOfPoint> List = contours_Num.iterator(); List.hasNext();) {
			Rect rect = org.opencv.imgproc.Imgproc.boundingRect(List.next());
			Point tl = rect.tl();
			Point br = rect.br();
			if(up > tl.y) {
				up = (int) tl.y;
			}
			if(down > br.y) {
				down = (int) br.y;
			}
			if(left > tl.x && (br.x - tl.x > 20)) {
				left = (int) tl.x;
				right = (int) br.x;
			}
		}
		if(down - up < 25 || right - left < 20) {
//			return -1;
			System.out.println("1fail");
		}
		if(down - up > 50 || right - left > 50) {
//			return -1;
			System.out.println("2fail");
		}
		
		Mat num = m.submat(new Range(up, down), new Range(left, right));
		Mat tmp = m.submat(new Range(down, m.rows()), new Range(left, right));
//		
		ImageUI numWin = new ImageUI();
		numWin.imshow("Num", num);
		
		ArrayList<MatOfPoint> contours_Flag = new ArrayList<MatOfPoint>();
		Mat hierarchy_Flag = new Mat();
		
		Imgproc.findContours(tmp, contours_Flag, hierarchy_Flag, 0, 1);
		for(Iterator<MatOfPoint> List = contours_Flag.iterator(); List.hasNext();) {
			Rect rect = org.opencv.imgproc.Imgproc.boundingRect(List.next());
			Point tl = rect.tl();
			Point br = rect.br();
			if(left > tl.x && (br.x - tl.x > 20)) {
				left = (int) tl.x;
				right = (int) br.x;
				up = (int) tl.y;
				down = (int) br.y;
			}
		}
		
		if(down - up < 25) {
			System.out.println("3fail");
		}
		
//		Mat flag = tmp.submat(new Range(up, down), new Range(left, right));
		
//		ImageUI flagWin = new ImageUI();
//		flagWin.imshow("flag", flag);
//		
		Imgcodecs.imwrite("./OpenCV/num.png", num);
		Imgcodecs.imwrite("./OpenCV/flag.png", tmp);
		return 0;
	}

}
