package at.htl;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends PApplet {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Figure> figures = new ArrayList<Figure>();

    public static void main(String[] args) {


        int menuSelection;

        do {

            System.out.println("\nProgrammenü:");
            System.out.println("-------------------------------------------");
            System.out.println("<1> Quadrat anlegen");
            System.out.println("<2> Kreis anlegen");
            System.out.println("<3> Figuren ausgeben (nach Fläche sortiert)");
            System.out.println("<4> Figuren ausgeben (nach Umfang sortiert)");
            System.out.println("<5> Programm beenden");
            System.out.println("-------------------------------------------");
            System.out.print("Auswahl (1-5): ");
            menuSelection = scanner.nextInt();
            scanner.nextLine();

            switch (menuSelection) {
                case 1:
                    figures.add(createSquare());
                    break;
                case 2:
                    figures.add(createCircle());
                    break;
                case 3:
                    printFiguresSortedByArea(figures);
                    break;
                case 4:
                    printFiguresSortedByCircumference(figures);
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
            }

        } while (menuSelection != 5);

    }

    private static Square createSquare() {

        System.out.print("x-Koordinate (linke obere Ecke): ");
        float x = scanner.nextFloat();

        System.out.print("y-Koordinate (linke obere Ecke): ");
        float y = scanner.nextFloat();

        System.out.print("Seitenlänge: ");
        float length = scanner.nextFloat();

        return new Square(length, new Point(x, y));

    }

    private static Circle createCircle() {

        System.out.print("x-Koordinate (Mittelpunkt): ");
        float x = scanner.nextFloat();

        System.out.print("y-Koordinate (Mittelpunkt): ");
        float y = scanner.nextFloat();

        System.out.print("Radius: ");
        float radius = scanner.nextFloat();

        return new Circle(new Point(x, y), radius);

    }

    private static void printFiguresSortedByArea(ArrayList<Figure> figures) {

        Figure helpinBoi;

        for (int i = 0; i < figures.size(); i++) {
            for (int j = i + 1; j < figures.size(); j++) {
                if (figures.get(j).area() < figures.get(i).area()) {
                    helpinBoi = figures.get(i);
                    figures.set(i, figures.get(j));
                    figures.set(j, helpinBoi);
                }
            }
        }

        for (Figure f: figures) {

            System.out.println(f);

        }
    }

    private static void printFiguresSortedByCircumference(ArrayList<Figure> figures) {

        Figure helpinBoi;

        for (int i = 0; i < figures.size(); i++) {
            for (int j = i + 1; j < figures.size(); j++) {
                if (figures.get(j).circumference() < figures.get(i).circumference()) {
                    helpinBoi = figures.get(i);
                    figures.set(i, figures.get(j));
                    figures.set(j, helpinBoi);
                }
            }
        }

        for (Figure f: figures) {

            System.out.println(f);

        }
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        noFill();
    }

    public void draw() {

        Square square;
        Circle circle;

        for (Figure f: figures) {
            if (f instanceof Square) {
                square = (Square) f;
                rect(square.getUpperLeftCorner().x, square.getUpperLeftCorner().y, square.getLength(), square.getLength());
            } else if (f instanceof Circle) {
                circle = (Circle) f;
            }
        }
    }
}
