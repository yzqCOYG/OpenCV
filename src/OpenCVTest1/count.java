package OpenCVTest1;

public class count {
	static double cal(double a, double b, int ch)      // op: 0:+,1:-,2:*,3:/
	{
		switch (ch)                        // +-x/ ����
		{
		case 0:  return(a + b);
		case 1:  return(a - b);
		case 2:  return(a*b);
		}
		if (b == 0.0)                       //  ��ĸΪ0
			return(999.0);
		else
			return(a / b);
	}
	
	static boolean isEqual(double d1, double d2)     // �����������Ƿ�������
	{
		double d = d1 - d2;
		if (d<0)
			d = -d;                        // �����ֵ
		return(d <= 0.001);
	}
	
	static void Count24(int v0, int v1, int v2, int v3)          // ��ٷ���24��
	{
		char op[] = { '+', '-', '*', '/' };             //  +:0  -:1 *:2  /:3

		int v[] = new int[4];                                 // ����������
		v[0] = v0; v[1] = v1;
		v[2] = v2; v[3] = v3;
		//-----------����ѭ����ʼ����ĸ����ֵ�λ��: 4!=24 ��--------------------------
		int count = 0;                              // �����ɹ�����
		for (int i1 = 0; i1<4; i1++)
		for (int i2 = 0; i2<4; i2++)                 // ����ѭ�����ĸ������
		if (i2 != i1)
		for (int i3 = 0; i3<4; i3++)
		if (i3 != i2 && i3 != i1)
		for (int i4 = 0; i4<4; i4++)
		if (i4 != i3 && i4 != i2 && i4 != i1)
		{
			//-----------����ѭ����ʼ������������: 4X4X4=64 ��---------------------------
			for (int f1 = 0; f1<4; f1++)      // ����ѭ������������
			for (int f2 = 0; f2<4; f2++)
			for (int f3 = 0; f3<4; f3++)  // ����� f1,f2,f3
			{                       // ���������ȼ�ֱ���о�(5��)
				//-----------δ��ѭ����ֱ�������������������ȼ�: 3!-1=5��--------------------
				double t1, t2, t3;      // ��ż�����м�ֵ
				// ��1�����  ((a ��b)��c)��d  ��
				t1 = cal(v[i1], v[i2], f1);
				t2 = cal(t1, v[i3], f2);
				t3 = cal(t2, v[i4], f3);
				if (isEqual(t3, 24))    // ������Ƿ�Ϊ24
				{
					String fs = "((%d%c%d)%c%d)%c%d=24\n";
					System.out.printf(fs, v[i1], op[f1], v[i2], op[f2], v[i3], op[f3], v[i4]);System.out.println();
					count++;
				}
				// ��2�����(a ��b)��(c�� d) ��ʼ���� ��
				t1 = cal(v[i1], v[i2], f1);
				t2 = cal(v[i3], v[i4], f3);
				t3 = cal(t1, t2, f2);
				if (isEqual(t3, 24))      // ������Ƿ�Ϊ24
				{
					String fs = "(%d%c%d)%c(%d%c%d)=24\n";
					System.out.printf(fs, v[i1], op[f1], v[i2], op[f2], v[i3], op[f3], v[i4]);System.out.println();
					count++;
				}
				// ��3����� (a��(b��c))��d  ��ʼ���� ��
				t1 = cal(v[i2], v[i3], f2);
				t2 = cal(v[i1], t1, f1);
				t3 = cal(t2, v[i4], f3);
				if (isEqual(t3, 24))    // ������Ƿ�Ϊ24
				{
					String fs = "(%d%c(%d%c%d))%c%d=24\n";
					System.out.printf(fs, v[i1], op[f1], v[i2], op[f2], v[i3], op[f3], v[i4]);System.out.println();
					count++;
				}
				// ��4�����  a��((b��c)��d ) ��ʼ���㣺
				t1 = cal(v[i2], v[i3], f2);
				t2 = cal(t1, v[i4], f3);
				t3 = cal(v[i1], t2, f1);
				if (isEqual(t3, 24))    // ������Ƿ�Ϊ24
				{
					String fs = "%d%c((%d%c%d)%c%d)=24\n";
					System.out.printf(fs, v[i1], op[f1], v[i2], op[f2], v[i3], op[f3], v[i4]);System.out.println();
					count++;
				}
				// ��5����� a��(b��(c��d)) ��ʼ���㣺
				t1 = cal(v[i3], v[i4], f3);
				t2 = cal(v[i2], t1, f2);
				t3 = cal(v[i1], t2, f1);
				if (isEqual(t3, 24))    // ������Ƿ�Ϊ24
				{
					String fs = "%d%c(%d%c(%d%c%d))=24\n";
					System.out.printf(fs, v[i1], op[f1], v[i2], op[f2], v[i3], op[f3], v[i4]);System.out.println();
					count++;
				}
			}
		}
		//-------------- ��ٽ����� �� 24*64*5=7680 �ֱ��ʽ ---------------------------
		if (count == 0)
			System.out.printf("%d,%d,%d,%d �������24.", v0, v1, v2, v3);
		else
			System.out.println("");
	}
}
	


