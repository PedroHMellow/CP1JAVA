

import br.com.fiap.winery.WineStockService;
import br.com.fiap.winery.WineStockServiceImplementation;

public class Main {
    public static void main(String[] args) {
        WineStockService servico = new WineStockServiceImplementation();
        
        System.out.print(servico.getMenu());
        System.out.print(servico.placeOrder("Pinot Noir", 69));
        System.out.print(servico.getMenu());
        System.out.print(servico.placeOrder("Riesling", 420));     
    }
}