package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharacterExe {
	public static void main(String[] args) {

		Scanner scn = null;
		try {
			scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while (true) {
				// nextLine(): 한 라인을 읽어옴
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" "); //split(): ()안에 있는 것을 기준으로 문자를 나누어 배열로 반환하는 메소드
				System.out.println("코드: " + msgAry[0] + ", 이름: " + msgAry[1] + ", 가격: " + msgAry[2]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// nextLine()이 더이상 읽어올 값이 없으면 발생하는 예외.
		}

		scn.close();
		System.out.println("프로그램이 종료되었습니다.");
	}

	static void write() {
		try {
			Writer writer = new FileWriter("c:/temp/data.txt");
			writer.write('a'); // 2byte씩 쓸 수 있는 char 타입
			writer.write('b');
			writer.write('c');

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	static void write2() {
		Scanner scn = new Scanner(System.in);

		// 사용자가 입력한 값을 읽어들여 txt에 저장
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while (true) {
				System.out.print("입력>>");
				String msg = scn.nextLine();
				if (msg.equals("quit")) {
					break;
				}
				writer.write(msg + "\n");
				writer.flush();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
		System.out.println("프로그램이 종료되었습니다.");
	}

	static void read() {
		try {
			Reader reader = new FileReader("D:/Dev/git/hello_world/HelloWorld/src/com/yedam/io/StreamExe.java"
			/* "c:/temp/data.txt" */);
			while (true) {
				int data = reader.read(); // 2byte씩 읽어옴
				if (data == -1) {
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
}
