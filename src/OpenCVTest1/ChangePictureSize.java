package OpenCVTest1;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ChangePictureSize {
	public static void SizeAdaption(String path) {
		int resize_height = 720;
		int resize_width = 540;
		Mat src = new Mat();
		Mat dst = new Mat();
		for(int i = 0;i<4;i++) {
			src = Imgcodecs.imread(path);
			Imgproc.resize(src, dst, new Size(resize_width, resize_height), 0, 0, Imgproc.INTER_LINEAR);
			Imgcodecs.imwrite("./OpenCV/"+i+"size.jpg", dst);
		}
//		ImageUI dstwin = new ImageUI();
//		dstwin.imshow("output", dst);
		
		src.release();
		dst.release();
	}
}
