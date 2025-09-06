package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class Loader {
    public static void main(String[] args) {
        System.out.print("Publicando serviços....");

        String enderecoStockService = "http://localhost:8085/WineStockService";
        WineStockService wineStock = new WineStockServiceImplementation();
        Endpoint.publish(enderecoStockService, wineStock);
        System.out.print("WineStockService publicado....");

        String enderecoWarningService = "http://localhost:8086/WineWarningService";
        WineWarningService wineWarnig = new WineWarningServiceImplementation();
        Endpoint.publish(enderecoWarningService, wineWarnig);
        System.out.println("WineWarningService publicado....");

        System.out.println("Serviços publicados com sucesso em:");
        System.out.println("\t- "+ enderecoStockService);
        System.out.println("\t- "+ enderecoWarningService);
    }
}
