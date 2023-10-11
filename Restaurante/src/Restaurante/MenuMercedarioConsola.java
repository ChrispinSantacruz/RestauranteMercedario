package Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    private String nombre;
    private double cantidad;
    private double calorias;

    public Ingrediente(String nombre, double cantidad, double calorias) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void eliminarIngrediente(int indice, ArrayList<Ingrediente> ingredientes) {
        if (indice >= 0 && indice < ingredientes.size()) {
            ingredientes.remove(indice);
        } else {
            System.out.println("Índice inválido");
        }
    }

    @Override
    public String toString() {
        return nombre + " - " + cantidad + " gramos - " + calorias + " Kcal";
    }
}

class Receta {
    private String nombre;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public Receta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void editarIngrediente(int indice, Ingrediente nuevoIngrediente) {
        if (indice >= 0 && indice < ingredientes.size()) {
            if (nuevoIngrediente == null) {
                ingredientes.remove(indice); // Elimina el ingrediente
            } else {
                ingredientes.set(indice, nuevoIngrediente); // Edita el ingrediente
            }
        } else {
            System.out.println("Índice inválido");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Receta: ").append(nombre).append("\nIngredientes:\n");
        for (Ingrediente ingrediente : ingredientes) {
            sb.append("- ").append(ingrediente.toString()).append("\n");
        }
        return sb.toString();
    }

	public void eliminarIngrediente(int i) {
		// TODO Auto-generated method stub
		
	}
}