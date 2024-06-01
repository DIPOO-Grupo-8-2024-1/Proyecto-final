package oferta;

public enum MetodoDePago {
    DEBITO("debito"),
    CREDITO("credito"),
    EFECTIVO("efectivo"),
    CHEQUE("cheque"),
    TRANSFERENCIA("transferencia");

    private final String metodo;

    MetodoDePago(String metodo) {
        this.metodo = metodo;
    }

    public String getMetodoDePago() {
        return metodo;
    }
}

