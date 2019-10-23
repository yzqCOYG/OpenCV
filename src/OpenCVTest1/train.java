package OpenCVTest1;

import java.util.ArrayList;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.ml.KNearest;
import org.opencv.ml.Ml;
import org.opencv.ml.TrainData;
import org.opencv.utils.Converters;

public class train {
	static void cardtrain() {
		Mat NumData = new Mat();
		ArrayList<Integer> NumLabels = new ArrayList<Integer>();
		Mat FlagData = new Mat();
		ArrayList<Integer> FlagLabels = new ArrayList<Integer>(); 
	
		int trainNum = 40;
	
		String NumName[] = {"1_", "2_", "3_", "4_", "5_", "6_", "7_", "8_", "9_", "10_", "j_", "q_", "k_"};
		String FlagName[] = {"hearts_", "diamonds_", "clubs_", "spades_"};
		for(int i = 0; i < trainNum * 13; i++) {
			Mat img = new Mat();
			Mat tmp = new Mat();
			String path = "./TrainSample/";
			path += (NumName[i / trainNum] + new String(i % trainNum + "") + ".jpg");
			img = Imgcodecs.imread(path, 0);
			Imgproc.resize(img, tmp, new Size(30, 40));
			NumData.push_back(tmp.reshape(0, 1));
			NumLabels.add(i / trainNum + 1);
		}	
		NumData.convertTo(NumData, 5);
		
		int K = 5;
		TrainData tData = TrainData.create(NumData,Ml.ROW_SAMPLE,Converters.vector_int_to_Mat(NumLabels));
		KNearest NumModel = KNearest.create();
		NumModel.setDefaultK(K);
		NumModel.setIsClassifier(true);
		NumModel.train(tData);
		NumModel.save("./num_knn_pixel.yml");
		
		for (int i = 0; i < trainNum * 4; i++){
			Mat img = new Mat();
			Mat tmp = new Mat();
			String path = "./TrainSample/";
			path += ((FlagName[i / trainNum]) + ((i%trainNum) + "") +".jpg");
			img = Imgcodecs.imread(path, 0);
			Imgproc.resize(img, tmp, new Size(30, 30));
			FlagData.push_back(tmp.reshape(0, 1));  //序列化后放入特征矩阵
			FlagLabels.add(i / trainNum + 1);  //对应的标注
		}
		FlagData.convertTo(FlagData, CvType.CV_32F); //uchar型转换为cv_32f
		//使用KNN算法
		int L = 5;
		TrainData tFlag = TrainData.create(FlagData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(FlagLabels));
		KNearest FlagModel = KNearest.create();
		FlagModel.setDefaultK(L);
		FlagModel.setIsClassifier(true);
		FlagModel.train(tFlag);
		FlagModel.save("./flag_knn_pixel.yml");
		
	}
	
}
