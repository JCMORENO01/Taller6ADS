package com.restaurant.ui;

import com.restaurant.infrastructure.persistence.*;
import com.restaurant.infrastructure.notification.OrderNotifier;
import com.restaurant.application.*;
import com.restaurant.domain.model.*;

import java.util.Scanner;

public class RestaurantConsoleApp {
    private final MenuService menuSvc;
    private final OrderService orderSvc;
    private final ReportService reportSvc;

    public RestaurantConsoleApp(){
        InMemoryMenuRepository menuRepo = new InMemoryMenuRepository();
        InMemoryOrderRepository orderRepo = new InMemoryOrderRepository();
        OrderNotifier notifier = new OrderNotifier();

        menuSvc = new MenuService(menuRepo);
        orderSvc = new OrderService(orderRepo, menuRepo, notifier);
        reportSvc = new ReportService(orderRepo);

        // seed menu
        menuSvc.addMenuItem(new MenuItem("M1","Hamburguesa",15000,"Main","Clásica"));
        menuSvc.addMenuItem(new MenuItem("B1","Gaseosa",5000,"Beverage","Refresco"));
    }

    private void showMenuOptions(){
        System.out.println("\n=== MENÚ ===");
        System.out.println("1. Ver menú");
        System.out.println("2. Crear plato");
        System.out.println("3. Modificar plato");
        System.out.println("4. Eliminar plato");
        System.out.println("0. Volver");
    }

    private void menuManagement(Scanner sc){
        String opt;
        do{
            showMenuOptions();
            System.out.print("Opción: ");
            opt = sc.nextLine();
            switch(opt){
                case "1" -> menuSvc.list().forEach(System.out::println);
                case "2" -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Nombre: "); String name = sc.nextLine();
                    System.out.print("Precio: "); double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Categoría: "); String cat = sc.nextLine();
                    System.out.print("Descripción: "); String desc = sc.nextLine();
                    menuSvc.addMenuItem(new MenuItem(id,name,price,cat,desc));
                }
                case "3" -> {
                    System.out.print("ID del plato a modificar: ");
                    String id = sc.nextLine();
                    MenuItem item = menuSvc.find(id);
                    if(item != null){
                        System.out.print("Nuevo nombre (" + item.getName() + "): ");
                        String name = sc.nextLine();
                        System.out.print("Nuevo precio (" + item.getPrice() + "): ");
                        double price = Double.parseDouble(sc.nextLine());
                        item.setName(name);
                        item.setPrice(price);
                        menuSvc.updateMenuItem(item);
                    } else {
                        System.out.println("Plato no encontrado");
                    }
                }
                case "4" -> {
                    System.out.print("ID del plato a eliminar: ");
                    menuSvc.removeMenuItem(sc.nextLine());
                }
            }
        }while(!opt.equals("0"));
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        String opt;
        do{
            System.out.println("\n=== Sistema Restaurante ===");
            System.out.println("1. Gestión de menú");
            System.out.println("2. Crear pedido");
            System.out.println("3. Añadir plato a pedido");
            System.out.println("4. Avanzar estado de pedido");
            System.out.println("5. Ver pedido");
            System.out.println("6. Total del pedido (con impuestos)");
            System.out.println("7. Ventas diarias");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opt = sc.nextLine();

            try{
                switch(opt){
                    case "1" -> menuManagement(sc);
                    case "2" -> {
                        Customer cust = new Customer("C1","Cliente","Calle 1","3001234567");
                        System.out.println("ID del cliente: " + cust.getId());
                        System.out.println("Pedido creado con ID: " + orderSvc.createOrder(cust).getId());
                    }
                    case "3" -> {
                        System.out.print("ID Pedido: "); String oId = sc.nextLine();
                        System.out.print("ID Plato: "); String pId = sc.nextLine();
                        orderSvc.addItem(oId,pId);
                    }
                    case "4" -> {
                        System.out.print("ID Pedido: "); orderSvc.advanceStatus(sc.nextLine());
                    }
                    case "5" -> {
                        System.out.print("ID Pedido: ");
                        System.out.println(orderSvc.get(sc.nextLine()));
                    }
                    case "6" -> {
                        System.out.print("ID Pedido: ");
                        System.out.printf("Total (imp. incl.): $%.2f%n", orderSvc.total(sc.nextLine()));
                    }
                    case "7" -> {
                        System.out.printf("Ventas del día: $%.2f%n", reportSvc.dailySales());
                    }
                }
            }catch(Exception e){ System.out.println("Error: "+e.getMessage()); }

        }while(!opt.equals("0"));
        sc.close();
    }

    public static void main(String[] args){
        new RestaurantConsoleApp().run();
    }
}
