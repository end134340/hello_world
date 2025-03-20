package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yedam.classes.Product;

public class ObjectStreamExe {
	public static void main(String[] args) {

		// 역직렬화
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Product> list = (List<Product>) ois.readObject(); // 캐스팅 필요
			for (Product prod : list) {
				System.out.println(prod.showList());
			}
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//

	static void write() {
		// 객체 => byte: 직렬화
		// byte 기반 데이터 => 객체: 역직렬화
		// 클래스가 Serializable라는 인터페이스를 구현한 클래스여야만 가능.
		List<Product> list = new ArrayList<Product>(); // 직렬화, 역직렬화가 가능한 클래스.
		list.add(new Product("A001", "4B연필", 1200));
		list.add(new Product("B001", "샤프", 2000));

		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

}
