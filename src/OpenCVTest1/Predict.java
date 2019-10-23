package OpenCVTest1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.ml.KNearest;

import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;

public class Predict {
	static int predictNum(Mat m) throws FileNotFoundException, YamlException{
		YamlReader reader = new YamlReader(new FileReader("num_knn_pixel.yml"));
		KNearest model_pixel = KNearest.create();
//		model_pixel.
//				Algorithm::load<KNearest>("num_knn_pixel.yml");
		Mat temp = new Mat();
		Imgproc.resize(m, temp, new Size(30, 40));
		Mat vec1 = new Mat();
		vec1.push_back(temp.reshape(0, 1));
		vec1.convertTo(vec1, CvType.CV_32F);
		int r1 = (int)(model_pixel.predict(vec1));   //对所有行进行预测
		switch (r1){
		case 1:
			System.out.println("A"); break;
		case 11:
			System.out.println("J"); break;
		case 12:
			System.out.println("Q"); break;
		case 13:
			System.out.println("K"); break;
		default:
			System.out.println(r1); break;
		}
		System.out.println("");
		return r1;
	}

	static int predictFlag(Mat m) throws FileNotFoundException, YamlException{
		YamlReader reader = new YamlReader(new FileReader("flag_knn_pixel.yml"));
		KNearest model_pixel = KNearest.create();
		Mat temp =new Mat();
//		Imgproc.resize(m, temp, new Size(30, 30));
		ImageUI tempShow = new ImageUI();
		if (!temp.empty()) {
			tempShow.imshow("window", temp);
			}
		Mat vec1 = new Mat();
		vec1.push_back(temp.reshape(0, 1));
		vec1.convertTo(vec1, CvType.CV_32F);
		int r1 = (int)(model_pixel.predict(vec1));   //对所有行进行预测
		System.out.println("识别的扑克牌是：");
		switch (r1){
		case 1:
			System.out.println("heart"); break;
		case 2:
			System.out.println("diamond"); break;
		case 3:
			System.out.println("club"); break;
		case 4:
			System.out.println("spade"); break;
		default:
			break;
		}
		return r1;
	}
}
