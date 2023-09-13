package Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMercedario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Receta> menu = new ArrayList<>();

        while (true) {
            System.out.println("\nMenú de Recetas - Restaurante Mercedario");
            System.out.println("1. Añadir Receta");
            System.out.println("2. Editar Receta");
            System.out.println("3. Ver Recetas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la receta: ");
                    String nombreReceta = scanner.nextLine();
                    Receta nuevaReceta = new Receta(nombreReceta);

                    while (true) {
                        System.out.print("Nombre del ingrediente (o 'fin' para terminar): ");
                        String nombreIngrediente = scanner.nextLine();
                        if (nombreIngrediente.equalsIgnoreCase("fin")) {
                            break;
                        }

                        System.out.print("Cantidad (gramos): ");
                        double cantidadIngrediente = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        
                        System.out.print("Cantidad (Calorias): ");
                        double cantidadCalorias = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea

                        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidadIngrediente, cantidadCalorias);
                        nuevaReceta.agregarIngrediente(ingrediente);
                        
                    }

                    menu.add(nuevaReceta);
                    System.out.println("Receta agregada al menú.");
                    break;

                case 2:
                    System.out.println("\nRecetas Disponibles:");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i).getNombre());
                    }
                    System.out.print("Seleccione una receta para editar (0 para volver): ");
                    int seleccionEditar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (seleccionEditar > 0 && seleccionEditar <= menu.size()) {
                        Receta recetaEditar = menu.get(seleccionEditar - 1);
                        System.out.println("Receta: " + recetaEditar.getNombre());
                        System.out.println("Ingredientes:");

                        for (int i = 0; i < recetaEditar.getIngredientes().size(); i++) {
                            System.out.println((i + 1) + ". " + recetaEditar.getIngredientes().get(i).toString());
                        }

                        System.out.print("Seleccione un ingrediente para editar (0 para volver): ");
                        int seleccionIngrediente = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        if (seleccionIngrediente > 0 && seleccionIngrediente <= recetaEditar.getIngredientes().size()) {
                            Ingrediente ingredienteEditar = recetaEditar.getIngredientes().get(seleccionIngrediente - 1);
                            System.out.print("Nuevo nombre del ingrediente: ");
                            String nuevoNombre = scanner.nextLine();
                            System.out.print("Nueva cantidad (gramos): ");
                            double nuevaCantidad = scanner.nextDouble();
                            scanner.nextLine(); // Consumir el salto de línea
                            System.out.print("Nueva cantidad (Calorias): ");
                            double nuevaCalorias = scanner.nextDouble();
                            scanner.nextLine(); // Consumir el salto de línea

                            Ingrediente nuevoIngrediente = new Ingrediente(nuevoNombre, nuevaCantidad, nuevaCantidad);
                            recetaEditar.editarIngrediente(seleccionIngrediente - 1, nuevoIngrediente);
                            System.out.println("Ingrediente editado exitosamente.");
                        } else if (seleccionIngrediente != 0) {
                            System.out.println("Ingrediente no válido.");
                        }
                    } else if (seleccionEditar != 0) {
                        System.out.println("Receta no válida.");
                    }
                    break;

                case 3:
                    System.out.println("\nRecetas Disponibles:");
                    for (Receta receta : menu) {
                        System.out.println(receta.toString());
                    }
                    break;

                case 4:
                    System.out.println("¡Gracias por usar el Menú de Recetas de Restaurante Mercedario!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}