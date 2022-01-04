package uni.fmi.bachelors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataGenerator {

	public static void main(String[] args) throws IOException {
		// �� ����� � �� ����� Y
		// ��� ������� � ������� �� ���������� �� 3 � ��������� 1 (x * 3 + 1)
		// A�� ������� � ����� �� ����� �� 2 (x/2)
		// ��������� ������������ ��� ����, �� ����� ���� ����� �������� �� �� ������� �� ������� ���
		
		File myFile = new File("data.txt");
		
		if(!myFile.createNewFile()) {
			System.out.println("File exists!");
		}
		
		FileWriter writer = new FileWriter(myFile, true);				
		Scanner in = new Scanner(System.in);
		System.out.println("�������� ��������");
		
		long start = in.nextLong();
		long end = in.nextLong();
		
		for(long i = start; i < end; i++) {
			start = i;
			writer.write("\n" + start);
			
			if(i % 10000 == 0)
				System.out.println("Calculating " + i);
			
			while(start != 1) {
				if(start % 2 != 0) {
					start = start * 3 + 1;
				}else {
					start /= 2;
				}				
				writer.write("," + start);				
			}
		}
		
	}

}
