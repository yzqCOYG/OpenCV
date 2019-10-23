package OpenCVTest1;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

public class Mat1 {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		Mat的第一种创建方法：create
		
		Mat src = new Mat();

//		Mat的创建     CV_8UC3 ->  8位  U:无符号字符  3通道
		src.create(300, 300, CvType.CV_8UC3);
		
		src.setTo(new Scalar(0, 0, 255));// BGR
		
		Imgcodecs.imwrite("D:\\OpenCV\\image_01.jpg", src);
		
//		Mat的第二种创建方法：调用OpenCV的函数zeros(ones, eyes)
		Mat src1 = Mat.zeros(300, 300, CvType.CV_8UC1);
		Imgcodecs.imwrite("D:\\OpenCV\\image_02.jpg", src1);
		
//		Mat的类型与大小
		Mat src2 = Imgcodecs.imread("D:\\OpenCV\\1.jpg");
		int type = src2.type();
		int width = src2.cols();
		int height = src2.rows();
		int channels = src2.channels();
		int depth = src2.depth();
		System.out.println("type:" + type + "\nwidth:" + width + "\nheight:" + height + "\nchannels:" + channels + "\ndepth:" + depth);
		
//		depth(8U -> 0) + channels(C3) = type(CV_8UC3)
		if(CvType.CV_8UC3 == type)//1
		{
			System.out.println("type = CvType.CV_8UC3");
		}
		else if (CvType.CV_8UC1 == type)//灰度图像时为真
		{
			System.out.println("type = CvType.CV_8UC1");
		}
		else
		{
			System.out.println("type = unknown");
		}
		
		Mat dst = new Mat(src2.size(), CvType.CV_32FC1);
		src2.convertTo(dst, CvType.CV_32F);
		
//		读取与修改每个像素点的像素值
		byte[] onepixel = new byte[channels];
		int r=0, g=0, b=0;
		int gray = 0;
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				src2.get(row, col, onepixel);
				if(channels == 3) {
					b = onepixel[0]&0xff;
					g = onepixel[1]&0xff;
					r = onepixel[2]&0xff;
					
//					修改
					b = 255 - b;
					g = 255 - g;
					r = 255 - r;

					onepixel[0] = (byte)b;
					onepixel[1] = (byte)g;
					onepixel[2] = (byte)r;
				}else {
					gray = onepixel[0]&0xff;
					gray = 255 - gray;
					onepixel[0] = (byte)gray;
				}
				src.put(row, col, onepixel);
			}
		}
		Imgcodecs.imwrite("D:\\OpenCV\\1_result.jpg", src2);
		
//		释放，避免OOM溢出
		src2.release();
		dst.release();
	}
}
