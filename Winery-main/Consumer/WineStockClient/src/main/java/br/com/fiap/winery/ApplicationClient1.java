package br.com.fiap.winery;

import java.util.Scanner;

public class ApplicationClient1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            WineStockServiceImplementationService service = new WineStockServiceImplementationService();
            WineStockService port = service.getWineStockServiceImplementationPort();

            System.out.println("Conectando ao serviço de estoque de vinhos...");

            // Exibe o menu de vinhos para o usuário
            String menu = port.getMenu();
            System.out.println("----- Vinhos Disponíveis -----");
            System.out.println(menu);
            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);

            System.out.print("\nDigite o nome do vinho para consultar o estoque: ");
            String wineName = scanner.nextLine();

            System.out.println("\nConsultando estoque para '" + wineName + "'...");

            // Nota: Estamos assumindo que a interface do serviço 'WineStockService'
            // possui um método 'checkStock(String wineName)' que retorna uma String.
            String stockInfo = port.checkStock(wineName);

            System.out.println("Resposta do servidor: " + stockInfo);

            scanner.close();
        
        } catch (Exception e) {
            System.err.println("\n[ERRO] Não foi possível conectar ao serviço. Verifique se o servidor (Publisher) está em execução.");
            e.printStackTrace();
        }
    }
}