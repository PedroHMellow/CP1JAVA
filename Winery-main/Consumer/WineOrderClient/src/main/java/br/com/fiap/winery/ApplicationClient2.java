package br.com.fiap.winery;

import java.util.Scanner;

public class ApplicationClient2 {
    public static void main(String[] args) {

        try {
            WineStockServiceImplementationService stockServiceFactory = new WineStockServiceImplementationService();
            WineStockService stockPort = stockServiceFactory.getWineStockServiceImplementationPort();

            System.out.println("Conectando aos serviços...");

            String menu = stockPort.getMenu();
            System.out.println(menu);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o nome do vinho que deseja pedir: ");
            String wineName = scanner.nextLine();
            
            System.out.print("Digite a quantidade desejada: ");
            int quantity = scanner.nextInt();

            if (quantity > 10) {
                WineWarningServiceImplementationService warningServiceFactory = new WineWarningServiceImplementationService();
                WineWarningService warningPort = warningServiceFactory.getWineWarningServiceImplementationPort();
                String warningMessage = warningPort.sendWarn();
                System.out.println("\nResposta do servidor de avisos: " + warningMessage);
            } else {
                System.out.println("\nEnviando seu pedido...");
                String orderStatus = stockPort.placeOrder(wineName, quantity);
                System.out.println("Resposta do servidor: " + orderStatus);
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao serviço. O servidor (Publisher) está rodando?");
            e.printStackTrace();
        }
    }
}
