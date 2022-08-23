package com.godoro.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> provinceList = new ArrayList<String>();
		provinceList.add("İstanbul");
		provinceList.add("Ankara");
		provinceList.add("Izmir");
		provinceList.add(1, "Bursa");
		provinceList.add("Adana");

		Collections.sort(provinceList, Collections.reverseOrder());

		String found = provinceList.get(3);
		System.out.println("4. İl: " + found);
		provinceList.remove("İzmir");

		for (String province : provinceList) {
			System.out.println("* " + province);
		}

	}

}
