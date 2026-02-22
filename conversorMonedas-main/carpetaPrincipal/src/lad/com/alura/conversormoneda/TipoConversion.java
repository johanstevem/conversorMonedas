package lad.com.alura.conversormoneda;

public enum TipoConversion {
    USD_EUR(1,"Dolar a Euro", "USD", "EUR"),
    EUR_USD(2,"Euro a Dolar", "EUR", "USD"),
    USD_MXN(3,"Dolar a Peso Mexicano", "USD", "MXN"),
    BRL_USD(4,"Real Brasileño a Dolar", "BRL", "USD"),
    USD_BRL(5,"Dolar a Real Brasileño", "USD", "BRL"),
    ARG_USD(6,"Peso Argentino a Dolar", "ARG", "USD"),
    USD_ARG(7,"Dolar a Peso Argentino", "USD", "ARG")
    ;
    private final int identificador;
    private final String descripcion;
    private final String origen;
    private final String destino;

    TipoConversion( int identificador,String descripcion, String origen, String destino) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.origen = origen;
        this.destino = destino;

    }
    //getter
    public String getDescripcion(){
        return descripcion;
    }
    public int getIdentificador(){
        return identificador;
    }

    public String getOrigen(){
        return origen;
    }
    public String getDestino(){
        return destino;
    }

    //metodo para recorrer Tipoconversion
    public static TipoConversion recorrerConversion(int numero){
        for (TipoConversion tipoConversion: TipoConversion.values() ){
            if (tipoConversion.getIdentificador() == numero){
                return tipoConversion;
            }
        }
        return null;
    }
}
