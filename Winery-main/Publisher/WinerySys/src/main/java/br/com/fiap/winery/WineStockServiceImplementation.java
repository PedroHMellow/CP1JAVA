package br.com.fiap.winery;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {
    // private List<String> lista =new ArrayList<>();
    private String[][] listadeOpcoes = {
            { "Cabernet Sauvignon",
                    "(mais robusto e tânico)" },
            { "Merlot",
                    "(mais suave e frutado)" },
            { "Pinot Noir",
                    "(mais delicado e com aromas de frutas vermelhas)" },
            { "Sauvignon Blanc",
                    "(mais fresco e cítrico)" },
            { "Riesling",
                    "(mais ácido e versátil para estilos variados)" }
    };

    @Override
    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Vinhos Disponíveis(escolher opção pelo nome do vinho):");
        for (String[] opcaoAtual : listadeOpcoes) {
            sb.append("\n\t" + opcaoAtual[0] + opcaoAtual[1]);
        }
        sb.append("\n\n");
        //System.out.print(sb);
        return sb.toString();
    }

    @Override
    public String placeOrder(String name, int quantity) {
        // for (String[] opcaoAtual : listadeOpcoes) {
        //     if (opcaoAtual[0].equals(name) && quantity > 0) {
        //         //System.out.println(quantity + " unidades de " + name + " pedidas com sucesso!\n\n");
        //         return quantity + " unidades de " + name + " pedidas com sucesso!\n\n";
        //     }
        // }
        // System.out.println("Opção não disponível!\n");
        // return "Opção não disponível!";
        return "Pedido confirmado!";
    }

}
