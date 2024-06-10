package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, SparePart> inventario = new HashMap<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Dar de alta SparePart");
            System.out.println("2. Dar de alta Component");
            System.out.println("3. Buscar pieza");
            System.out.println("4. Mostrar todas las piezas");
            System.out.println("5. Generar JSON y grabar a fichero");
            System.out.println("6. Importar desde JSON");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    crearSparePart();
                    break;
                case 2:
                    crearComponent();
                    break;
                case 3:
                    buscarPieza();
                    break;
                case 4:
                    mostrarTodasPiezas();
                    break;
                case 5:
                    grabarFichero();
                    break;
                case 6:
                    importarJSON();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearSparePart() {
        System.out.print("Ingrese el código de la pieza: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la descripción de la pieza: ");
        String text = scanner.nextLine();

        System.out.print("Ingrese el precio de la pieza: ");
        double price = scanner.nextDouble();

        SparePart sparePart = new SparePart(code, text, price);
        inventario.put(code, sparePart);
        System.out.println("SparePart creada: " + sparePart);
    }

    private static void crearComponent() {
        System.out.print("Ingrese el código del componente: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la descripción del componente: ");
        String text = scanner.nextLine();

        System.out.print("Ingrese el precio del componente: ");
        double price = scanner.nextDouble();

        Component component = new Component(code, text, price);
        inventario.put(code, component);
        System.out.println("Component creado: " + component);

        boolean addingParts = true;
        while (addingParts) {
            System.out.print("¿Desea agregar una pieza al componente? (s/n): ");
            String addPart = scanner.next();
            if (addPart.equalsIgnoreCase("s")) {
                System.out.print("Ingrese el código de la pieza: ");
                int partCode = scanner.nextInt();
                scanner.nextLine();

                if (inventario.containsKey(partCode)) {
                    SparePart part = inventario.get(partCode);
                    component.addPart(part);
                    System.out.println("Pieza agregada al componente: " + part);
                } else {
                    System.out.println("La pieza con el código " + partCode + " no existe en el inventario.");
                }
            } else {
                addingParts = false;
            }
        }
    }

    private static void buscarPieza() {
        System.out.print("Ingrese el código de la pieza a buscar: ");
        int code = scanner.nextInt();

        if (inventario.containsKey(code)) {
            System.out.println("Pieza encontrada: " + inventario.get(code));
        } else {
            System.out.println("Pieza no encontrada.");
        }
    }

    private static void mostrarTodasPiezas() {
        if (inventario.isEmpty()) {
            System.out.println("No hay piezas en el inventario.");
        } else {
            inventario.values().forEach(System.out::println);
        }
    }

    private static void grabarFichero() {
        try (FileWriter writer = new FileWriter("inventario.json")) {
            gson.toJson(inventario, writer);
            System.out.println("Inventario guardado en inventario.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void importarJSON() {
        try (FileReader reader = new FileReader("inventario.json")) {
            Map<Integer, SparePart> importarInventario = gson.fromJson(reader, inventario.getClass());
            inventario.putAll(importarInventario);
            System.out.println("Inventario importado desde inventario.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}