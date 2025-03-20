package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		// 입력 + 출력 => 복사
		try {
			InputStream is = new FileInputStream("c:/temp/image.jpg"); // 그 위치에 있는 파일을 읽어옴
			OutputStream os = new FileOutputStream("c:/temp/image3.jpg");

			byte[] buf = new byte[100]; // 한 번에 100바이트씩 읽어올 수 있도록 배열 선언
			while (true) {
				int data = is.read(buf); // 한 바이트 읽어온 걸 => buf라는 배열을 넣어서 한번에 100바이트씩 읽어와 buf에 담음
				if (data == -1) {
					// 더이상 읽어올 게 없으면 종료
					break;
				}
				os.write(buf); // 한 바이트 씀
				os.flush();
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");

	}// 메인 끝

	static void write() {
		// 출력스트림(바이트)
		try {
			OutputStream os = new FileOutputStream("c:/temp/data.bin");
			os.write(10); // 파일에다 이런 정보를 쓰겠다고 하는? 메소드
			os.write(20); // 정수를 넣음 =>
			os.write(30);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	static void read() {
		// 입력 스트림(바이트)
		try {
			InputStream is = new FileInputStream("c:/temp/data.bin");
			while (true) {
				int data = is.read();// 한 바이트씩 읽어들여 정수 타입으로 반환해줌. 더이상 읽어들일 바이트가 없으면 -1 반환.
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
}
