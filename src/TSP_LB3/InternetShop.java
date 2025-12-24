package TSP_LB3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
	private String name;
	private String category;
	private String description;
	private double price;
	private boolean isInStorage;
	private int quantity;
	private LocalDate deliveryDate;

	public Product(String name, String category, String description,
				   double price, int quantity, LocalDate deliveryDate) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		if (quantity == 0)
		{
			this.isInStorage = false;
			this.quantity = 0;
		}
		else
		{
			this.isInStorage = true;
			this.quantity = quantity;
		}
		this.deliveryDate = deliveryDate;
	}

	public String getName() { return name; }
	public String getCategory() { return category; }
	public String getDescription() { return description; }
	public double getPrice() { return price; }
	public boolean isInStorage() { return isInStorage; }
	public int getQuantity() { return quantity; }
	public LocalDate getDeliveryDate() { return deliveryDate; }

	@Override
	public String toString() {
		return String.format("Товар: %s | Категорія: %s | Ціна: %.2f | Кількість: %d | Наявність: %s",
				name, category, price, quantity, isInStorage ? "є" : "немає");
	}
}

public class InternetShop {
	private static List<Product> products = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		products.add(new Product("Ноутбук Lenovo", "Електроніка", "15.6'' FullHD", 25000, 10, LocalDate.of(2025, 12, 1)));
		products.add(new Product("Смартфон Samsung", "Електроніка", "Galaxy S25", 32000, 0, LocalDate.of(2025, 12, 10)));
		products.add(new Product("Кросівки Nike", "Одяг", "Розмір 42", 3500, 5, LocalDate.of(2025, 11, 20)));
		products.add(new Product("Холодильник LG", "Побутова техніка", "No Frost", 18000, 0, LocalDate.of(2025, 12, 15)));
		products.add(new Product("Книга 'Java Basics'", "Книги", "Підручник для початківців", 500, 20, LocalDate.of(2025, 10, 5)));

		boolean exit = false;
		while (!exit) {
			showMenu();
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
				case 1 -> addProduct();
				case 2 -> showAllProducts();
				case 3 -> showOutOfStockProducts();
				case 4 -> showProductsByCategory();
				case 5 -> exit = true;
				default -> System.out.println("Невірний вибір, спробуйте ще раз.");
			}
		}
		System.out.println("Вихід з програми...");
	}

	private static void showMenu() {
		System.out.println("\n=== Меню ===");
		System.out.println("1. Додати новий продукт");
		System.out.println("2. Показати всі продукти");
		System.out.println("3. Показати відсутні продукти");
		System.out.println("4. Пошук продуктів за категорією");
		System.out.println("5. Вихід");
		System.out.print("Виберіть дію: ");
	}

	private static void addProduct() {
		System.out.print("Назва товару: ");
		String name = scanner.nextLine();
		System.out.print("Категорія: ");
		String category = scanner.nextLine();
		System.out.print("Опис товару: ");
		String description = scanner.nextLine();
		System.out.print("Ціна: ");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.print("Кількість: ");
		int quantity = Integer.parseInt(scanner.nextLine());
		System.out.print("Дата поставки (yyyy-mm-dd): ");
		LocalDate deliveryDate = LocalDate.parse(scanner.nextLine());

		products.add(new Product(name, category, description, price, quantity, deliveryDate));
		System.out.println("Продукт додано успішно!");
	}

	private static void showAllProducts() {
		System.out.println("\n=== Список усіх товарів ===");
		for (Product p : products) {
			System.out.println(p);
		}
	}

	private static void showOutOfStockProducts() {
		System.out.println("\n=== Відсутні товари ===");
		for (Product p : products) {
			if (!p.isInStorage()) {
				System.out.println(p);
			}
		}
	}

	private static void showProductsByCategory() {
		System.out.print("Введіть категорію для пошуку: ");
		String category = scanner.nextLine();
		System.out.println("\n=== Товари у категорії: " + category + " ===");
		boolean found = false;
		for (Product p : products) {
			if (p.getCategory().equalsIgnoreCase(category)) {
				System.out.println(p);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Товари у цій категорії відсутні.");
		}
	}
}