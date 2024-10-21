package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Fisico extends PagoReversible {
    public String tipoFisico;

    // Constructor
    public Fisico(double monto, Date fecha, String estadoReversion, String tipoFisico) {
        super(monto, fecha, estadoReversion);
        this.tipoFisico = tipoFisico;
    }

    // Getters y Setters
    public String getTipoFisico() {
        return tipoFisico;
    }

    public void setTipoFisico(String tipoFisico) {
        this.tipoFisico = tipoFisico;
    }
}
