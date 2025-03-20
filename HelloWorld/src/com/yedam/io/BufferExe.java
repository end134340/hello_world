package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferExe {
	public static void main(String[] args) {
		try {
			// 입력 스트림
			FileInputStream fis = new FileInputStream("C:/Users/admin/Downloads/jdk-21_windows-x64_bin.exe"); // 파일을 읽어오기 위한 기본 스트림
			BufferedInputStream bis = new BufferedInputStream(fis); // 보조 스트림의 생성자의 매개값으로 기본 스트림을 전달.

			// 출력 스트림
			FileOutputStream fos = new FileOutputStream("c:/temp/jdk-21_windows-x64_bin.exe");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			while (true) {
				int data = bis.read();
				if (data == -1) {
					break;
				}
				bos.write(data);
			}
			bos.flush();
			// 생성한 순서의 반대로 닫아줌
			bos.close();
			fos.close();
			bis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}//
}
