package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Module1 {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//输入图像
		Mat src = Imgcodecs.imread("d:\\OpenCV\\A_Range.png");
		//模板图像
		Mat tpl = Imgcodecs.imread("d:\\OpenCV\\rec_result.png");
		if(src.empty() || tpl.empty()) {
			return;
		}
		
		int height = src.rows() - tpl.rows() + 1;
		int width = src.cols() - tpl.cols() + 1;
		Mat result = new Mat(height, width, CvType.CV_32FC1);
		
		int method = Imgproc.TM_SQDIFF_NORMED;
		
		Imgproc.matchTemplate(src, tpl, result, method);
		MinMaxLocResult minMaxResult = Core.minMaxLoc(result);
		Point maxloc = minMaxResult.maxLoc;
		Point minloc = minMaxResult.minLoc;
		
		Point matchloc = null;
		if(method == Imgproc.TM_SQDIFF || method == Imgproc.TM_SQDIFF_NORMED) {
			matchloc = minloc;
		}else {
			matchloc = maxloc;
		}
		
		Mat result8u = new Mat();
		Core.normalize(result, result, 0, 255, Core.NORM_MINMAX);
		result.convertTo(result8u, CvType.CV_8UC1);
		ImageUI win = new ImageUI();
		win.imshow("input", result8u);
		
		Mat copy = src.clone();
		Imgproc.rectangle(copy, matchloc, new Point(matchloc.x+tpl.cols(), matchloc.y+tpl.rows()), new Scalar(0,0,255), 2, 8, 0);
		ImageUI mWin = new ImageUI();
		mWin.imshow("Template Match", copy);
		
		Rect target = new Rect();

	}
}
