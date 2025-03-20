package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExe {
	public static void main(String[] args) {
		File file = new File("c:/temp/new.txt");
		File file1 = new File("c:/temp/images/img1/new");
		try {
			if (!file.exists()) { // file.exist(): 경로상에 파일이 존재하는지 체크해주는 메소드
				// 파일이 있는지 없는지 체크해서 없으면
				file.createNewFile(); // 파일을 생성해주는 메소드
				System.out.println("파일이 생성되었습니다.");
			}
			if (!file1.exists()) {
//				file1.mkdir(); // 폴더를 만드는 메소드
				file1.mkdirs(); // 한번에 하위 폴더들을 만들어 줄 때에는 이런 방식으로(경로상에 없는 파일을 한꺼번에 생성해줌.)
				System.out.println("폴더가 생성되었습니다.");
			}
			FileWriter fw = new FileWriter(file); // 파일 객체를 생성자의 매개값으로 지정해도 됨
			fw.write("Hello\n");
			fw.write("World!\n");
			fw.flush();
			fw.close();

			if (file.exists()) {
				file.delete();
				System.out.println("파일이 삭제되었습니다.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} //

		System.out.println("프로그램이 종료되었습니다.");
	}//
}