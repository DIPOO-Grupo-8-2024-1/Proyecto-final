package usuario;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String id;
    private String nombre;
    private String email;
    private String password;
    private boolean verificado;
    private double limiteCompra;

    public Usuario(String id, String nombre, String email, String password, boolean verificado, double limiteCompra) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.verificado = verificado;
        this.limiteCompra = limiteCompra;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public double getLimiteCompra() {
        return limiteCompra;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public void incrementarLimiteCompra(double incremento) {
        this.limiteCompra += incremento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", verificado=" + verificado +
                ", limiteCompra=" + limiteCompra +
                '}';
    }
}


