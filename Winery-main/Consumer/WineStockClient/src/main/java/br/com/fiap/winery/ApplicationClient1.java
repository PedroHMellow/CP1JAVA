package br.com.fiap.winery;

public class ApplicationClient1 {
    public static void main(String[] args) {
        try {
            // Usando as classes geradas automaticamente pelo Maven plugin
            WineStockServiceImplementationService service = new WineStockServiceImplementationService();
            WineStockService wineStockService = service.getWineStockServiceImplementationPort();
            
            System.out.println("Conectando ao serviço de estoque de vinhos...");
            
            // Chamando o método getMenu e exibindo o resultado
            String menu = wineStockService.getMenu();
            System.out.println("----- Menu de Vinhos -----");
            System.out.println(menu);
            System.out.println("-------------------------");
            
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao serviço. O servidor (Publisher) está rodando?");
            e.printStackTrace();
        }
    }
}
