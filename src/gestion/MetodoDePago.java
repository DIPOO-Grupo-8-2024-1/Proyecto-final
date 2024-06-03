package gestion;

public enum MetodoDePago {
    DEBITO("debito"),
    TARJETA_CREDITO("credito"),
    EFECTIVO("efectivo"),
    CHEQUE("cheque"),
    TRANSFERENCIA_ELECTRONICA("transferencia");

    private final String metodo;

    MetodoDePago(String metodo) {
        this.metodo = metodo;
    }

    public String getMetodoDePago() {
        return metodo;
    }
}

