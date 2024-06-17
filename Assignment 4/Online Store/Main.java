import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Place Order");
            System.out.println("3. Display Inventory");
            System.out.println("4. Display Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    placeOrder(scanner);
                    break;
                case 3:
                    Store.displayInventory();
                    break;
                case 4:
                    Store.displayOrders();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
	    }
    }

    private static void addProduct(Scanner scanner) {
        System.out.println("Enter product type (Electronics/Clothing): ");
        String type = scanner.nextLine();

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (type.equalsIgnoreCase("Electronics")) {
            System.out.println("Enter brand: ");
            String brand = scanner.nextLine();

            System.out.println("Enter model: ");
            String model = scanner.nextLine();

            Store.addProduct(new Electronics(name, price, quantity, brand, model));
        } else if (type.equalsIgnoreCase("Clothing")) {
            System.out.println("Enter size: ");
            String size = scanner.nextLine();

            System.out.println("Enter color: ");
            String color = scanner.nextLine();

            Store.addProduct(new Clothing(name, price, quantity, size, color));
        } else {
            System.out.println("Invalid product type.");
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        for (Product product : Store.getInventory()) {
            if (product.getName().equalsIgnoreCase(name)) {
                Store.placeOrder(product, quantity);
                return;
            }
        }

        System.out.println("Product not found.");
    }
}

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract String getDetails();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Electronics extends Product {
    private String brand;
    private String model;

    public Electronics(String name, double price, int quantity, String brand, String model) {
        super(name, price, quantity);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String getDetails() {
        return "Electronics [Name: " + name + ", Brand: " + brand + ", Model: " + model + ", Price: " + price + ", Quantity: " + quantity + "]";
    }
}

class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(String name, double price, int quantity, String size, String color) {
        super(name, price, quantity);
        this.size = size;
        this.color = color;
    }

    @Override
    public String getDetails() {
        return "Clothing [Name: " + name + ", Size: " + size + ", Color: " + color + ", Price: " + price + ", Quantity: " + quantity + "]";
    }
}

class Order {
    private static int idCounter = 1;
    private int orderId;
    private Product product;
    private int quantityOrdered;

    public Order(Product product, int quantityOrdered) {
        this.orderId = idCounter++;
        this.product = product;
        this.quantityOrdered = quantityOrdered;
    }

    public String getOrderDetails() {
        return "Order ID: " + orderId + ", Product: " + product.getName() + ", Quantity Ordered: " + quantityOrdered;
    }
}

class Store {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void addProduct(Product product) {
        inventory.add(product);
    }

    public static ArrayList<Product> getInventory() {
        return inventory;
    }

    public static void placeOrder(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            orders.add(new Order(product, quantity));
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    public static void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory) {
            System.out.println(product.getDetails());
        }
    }

    public static void displayOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order.getOrderDetails());
        }
    }
}
