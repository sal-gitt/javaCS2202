import java.util.Scanner;

abstract class Shape {
    int dim1, dim2;

    Shape(int d1, int d2) {
        dim1 = d1;
        dim2 = d2;
    }

    abstract double area();
}

class Square extends Shape {
    Square(int side) {
        super(side, side);
    }
    @Override
    double area() {
        return dim1 * dim1;
    }
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    @Override
    double area() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    double area() {
        return 0.5 * dim1 * dim2;
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    @Override
    double area() {
        return Math.PI * dim1 * dim1;
    }
}

public class areacalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Choose any options(1-5):");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Circle");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            opt = sc.nextInt();

            Shape shape = null;

            switch (opt) {
                case 1:
                    System.out.println("Enter side of square: ");
                    int side = sc.nextInt();
                    shape = new Square(side);
                    break;
                case 2:
                    System.out.println("Enter length: ");
                    int length = sc.nextInt();
                    System.out.println("Enter breadth: ");
                    int breadth = sc.nextInt();
                    shape = new Rectangle(length, breadth);
                    break;
                case 3:
                    System.out.print("Enter base: ");
                    int base = sc.nextInt();
                    System.out.print("Enter height: ");
                    int height = sc.nextInt();
                    shape = new Triangle(base, height);
                    break;
                case 4:
                    System.out.print("Enter radius: ");
                    int radius = sc.nextInt();
                    shape = new Circle(radius);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.println("Area: " + shape.area());
        }
    }
}
