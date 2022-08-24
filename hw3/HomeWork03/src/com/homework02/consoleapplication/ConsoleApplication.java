package com.homework02.consoleapplication;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

	private static Scanner scanner = new Scanner(System.in);

	private static List<Supplier> supplierList = new ArrayList<>();

	private final static String path = System.getProperty("user.home") + "/Documents/ConsoleApplication.txt";

	private static void printMenu() {
		System.out.println("Menu: ");
		System.out.println("1. Yükle");
		System.out.println("2. Sakla");
		System.out.println("3. Dizelgele");
		System.out.println("4. Bul");
		System.out.println("5. Ekle");
		System.out.println("6. Güncelle");
		System.out.println("7. Sil");
		System.out.println("0. Çık");
	}

	private static int scanChoice() {
		System.out.println("Seçiniz: ");
		int choice = scanner.nextInt();
		System.out.println("Seçilen: " + choice);
		return choice;

	}

	private static void doLoad() throws IOException {
		System.out.println("Yükleniyor...");
		System.out.println();
		SupplierFiler supplierFiler = new SupplierFiler(path);
		supplierList = supplierFiler.load();
		System.out.println("Yüklendi");
	}

	private static void doStore() throws IOException {
		System.out.println("Saklanıyor...");
		System.out.println();

		SupplierFiler supplierFiler = new SupplierFiler(path);
		supplierFiler.store(supplierList);

		System.out.println(supplierList.size() + " supplier " + path + " dizine saklandı");
	}

	private static void doList() {
		System.out.println("Dizelgeleniyor...");
		if (supplierList.size() > 0) {
			for (Supplier supplier : supplierList) {
				System.out.println(
						supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
			}
		} else {
			System.out.println("Liste boş, yeni supplier ekleyin");
		}
	}

	private static void doFind() {
		System.out.println("Supplier ID giriniz: ");
		long supplierId = scanner.nextLong();

		System.out.println("Bulunuyor...");
		Supplier supplier = isExist(supplierId);

		if (supplier != null) {
			System.out.println(
					supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
		} else {
			System.out.println("Supplier bulunamadı");
		}
	}

	private static void doAdd() {
		System.out.println("Supplier ID giriniz: ");
		long supplierId = scanner.nextLong();
		scanner.nextLine();

		Supplier supplier = isExist(supplierId);
		if (supplier == null) {
			System.out.println("Supplier Name giriniz: ");
			String supplierName = scanner.nextLine();

			System.out.println("Supplier Total Credit giriniz: ");
			double totalCredit = scanner.nextDouble();
			System.out.println(totalCredit);

			System.out.println("Ekleniyor...");
			supplierList.add(new Supplier(supplierId, supplierName, totalCredit));
			System.out.println("Eklenidi");
		} else {
			System.out.println("Girdiyiniz supplierId listede bulunuyor");
		}

	}

	private static void doUpdate() {
		System.out.println("Güncellemek için Supplier ID giriniz: ");
		long supplierId = scanner.nextLong();
		scanner.nextLine();
		Supplier supplier = isExist(supplierId);
		
		if (supplier != null) {

			System.out.println("Supplier Name giriniz: ");
			String supplierName = scanner.nextLine();
			supplier.setSupplierName(supplierName);

			System.out.println("Supplier Total Credit giriniz: ");
			double totalCredit = scanner.nextDouble();
			supplier.setTotalCredit(totalCredit);

			System.out.println("Güncellendi");
		} else {
			System.out.println("Supplier bulunamadı");
		}

	}

	private static void doDelete() {
		System.out.println("Supplier ID giriniz: ");
		long supplierId = scanner.nextLong();
		Supplier supplier = isExist(supplierId);
		if (supplier != null) {
			System.out.println("Siliniyor...");
			supplierList.remove(supplier);
			System.out.println("Silinidi");
		} else {
			System.out.println("Supplier bulunamdı");
		}

	}

	private static void doExit() {
		System.exit(0);
	}

	private static Supplier isExist(long supplierId) {
		for (Supplier supplier : supplierList) {
			if (supplier.getSupplierId() == supplierId) {
				return supplier;
			}
		}
		return null;
	}

	private static void handleChoice(int choice) {
		switch (choice) {
		case 0:
			doExit();
			break;
		case 1:
			try {
				doLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case 2:
			try {
				doStore();
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case 3:
			doList();
			break;
		case 4:
			doFind();
			break;
		case 5:
			doAdd();
			break;
		case 6:
			doUpdate();
			break;
		case 7:
			doDelete();
			break;
		default:
			System.out.println("Geçersiz seçim: " + choice);
		}
	}

	public static void main(String[] args) {
		while (true) {
			printMenu();
			int choice = scanChoice();
			handleChoice(choice);
		}

	}
}
