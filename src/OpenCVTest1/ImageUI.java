package OpenCVTest1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JDialog;

import org.opencv.core.Mat;

public class ImageUI extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	
	public ImageUI() {
		this.image = null;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(image == null) {
			g2d.setPaint(Color.BLACK);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		}else {
			g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		}
	}
	
	public void imshow(String title, Mat src) {
		this.image = convert2BufferedImage(src);
		JDialog ui =new JDialog();
		ui.setTitle(title);
		ui.getContentPane().setLayout(new BorderLayout());
		ui.getContentPane().add(this, BorderLayout.CENTER);
		ui.setSize(image.getWidth() + 2, image.getHeight() + 2);
		ui.setVisible(true);
		this.repaint();
	}
	
	private BufferedImage convert2BufferedImage(Mat src) {
		int width = src.cols();
		int height = src.rows();
		int dims = src.channels();
		byte[] data = new byte[width*height*dims];
		src.get(0, 0, data);
		int[] pixels = new int[width*height];
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		int r=0, g=0, b=0;
		int index = 0;
		for(int row=0; row<height; row++) {
			for(int col=0; col<width; col++) {
				index = row*width*dims + col*dims;
				if(dims == 3) {
					b = data[index]&0xff;
					g = data[index+1]&0xff;
					r = data[index+2]&0xff;
					pixels[row*width+col] = ((255&0xff) << 24) | ((r&0xff) << 16) | ((g&0xff) << 8) | (b&0xff);
				}else if(dims == 1){
					b = data[index]&0xff;
					pixels[row*width+col] = ((255&0xff) << 24) | ((b&0xff) << 16) | ((b&0xff) << 8) | (b&0xff);
				}
			}
		}
		bi.getRaster().setDataElements(0, 0, width, height, pixels);
		return bi;
	}
}
