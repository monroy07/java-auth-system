package com.jpmonroy.app;

import com.jpmonroy.app.service.AuthService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                String resultado = authService.register(email, password);
                System.out.println(resultado);

            } else if (opcion == 2) {
                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                String resultado = authService.login(email, password);
                System.out.println(resultado);

            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
                break;
            } else {
                System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}