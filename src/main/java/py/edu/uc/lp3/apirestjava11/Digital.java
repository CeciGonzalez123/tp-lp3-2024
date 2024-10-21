package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Digital extends PagoIrreversible {
    public String medioDigital;

    // Constructor
    public Digital(double monto, Date fecha, String tipoIrreversible, String medioDigital) {
        super(monto, fecha, tipoIrreversible);
        this.medioDigital = medioDigital;
    }

    // Getters y Setters
    public String getMedioDigital() {
        return medioDigital;
    }

    public void setMedioDigital(String medioDigital) {
        this.medioDigital = medioDigital;
    }
}
