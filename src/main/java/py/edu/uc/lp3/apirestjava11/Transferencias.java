package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Transferencias extends Fisico {
    public String bancoOrigen;
    public String numeroTransferencia;

    // Constructor
    public Transferencias(double monto, Date fecha, String estadoReversion, String tipoFisico, String bancoOrigen, String numeroTransferencia) {
        super(monto, fecha, estadoReversion, tipoFisico);
        this.bancoOrigen = bancoOrigen;
        this.numeroTransferencia = numeroTransferencia;
    }

    // Getters y Setters
    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public void setBancoOrigen(String bancoOrigen) {
        this.bancoOrigen = bancoOrigen;
    }

    public String getNumeroTransferencia() {
        return numeroTransferencia;
    }

    public void setNumeroTransferencia(String numeroTransferencia) {
        this.numeroTransferencia = numeroTransferencia;
    }
}
