package br.com.fiap.winery;

import java.util.Scanner;

public class ApplicationClient2 {
    public static void main(String[] args) {

        try {
            WineStockServiceImplementationService service = new WineStockServiceImplementationService();

            WineStockService port = service.getWineStockServiceImplementationPort();

            System.out.println("Conectando ao serviço de estoque de vinhos...");

            String menu = port.getMenu();
            System.out.println(menu);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o nome do vinho que deseja pedir: ");
            String wineName = scanner.nextLine();

            System.out.print("Digite a quantidade desejada: ");
            int quantity = scanner.nextInt();

            System.out.println("\nEnviando seu pedido...");
            String orderStatus = port.placeOrder(wineName, quantity);

            System.out.println("Resposta do servidor: " + orderStatus);

            scanner.close();
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao serviço. O servidor (Publisher) está rodando?");
            e.printStackTrace();
        }
    }
}
