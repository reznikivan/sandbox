package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Identicon {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Random random = new Random(s.hashCode());
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		int sym = random.nextInt(4);
		int[][] a = new int[6][6];
		int sum = 0;
		if (sym == 0){
			for(int i = 0; i < 6; i++)
				for(int j = i; j < 6; j++){
					a[i][j] = random.nextInt(2);
					a[j][i] = a[i][j];
					sum += a[i][j];
			}
			if (sum == 0){
			a[1][2]=1; a[2][1]=1; a[3][4]=1; a[4][3]=1;
			}
		}
		else if (sym == 1){
			for(int i = 0; i < 6; i++)
				for(int j = 0; j < 6 - i; j++){
					a[i][j] = random.nextInt(2);
					a[5-j][5-i] = a[i][j];
					sum += a[i][j];
			}
			if (sum == 0){
			a[1][2]=1; a[2][1]=1; a[3][4]=1; a[4][3]=1;
			}
		}
		else if (sym == 2){
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 6; j++){
					a[i][j] = random.nextInt(2);
					a[5-i][j] = a[i][j];
					sum += a[i][j];
			}
			if (sum == 0){
			a[1][2]=1; a[2][1]=1; a[3][4]=1; a[4][3]=1;
			}
		}
		else if (sym == 3){
			for(int i = 0; i < 6; i++)
				for(int j = 0; j < 3; j++){
					a[i][j] = random.nextInt(2);
					a[i][5-j] = a[i][j];
					sum += a[i][j];
			}
			if (sum == 0){
			a[1][2]=1; a[2][1]=1; a[3][4]=1; a[4][3]=1;
			}
		}
		String code = "";
		code += "<svg width=\"204\" height=\"204\">"+"\n"; 
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 6; j++){
				code += "<rect x=\""+i*34+"\" y=\""+j*34+"\" width=\"34\" height=\"34\" style=\"fill:rgb("+(255-a[i][j]*r)+", "+(255-a[i][j]*g)+", "+(255-a[i][j]*b)+")\" />";
				code += "\n";
			}
		code += "</svg>";
		FileOutputStream outstr = new FileOutputStream("C://Users//������������//Desktop//image.html");
		byte[] buffer = code.getBytes();
        outstr.write(buffer, 0, buffer.length);
		sc.close();
		
	}

}