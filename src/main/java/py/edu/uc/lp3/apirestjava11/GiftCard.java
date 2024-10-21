package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class GiftCard extends Digital {
    private String codigoDigital;

    // Constructor
    public GiftCard(double monto, Date fecha, String tipoIrreversible, String medioDigital, String codigoDigital) {
        super(monto, fecha, tipoIrreversible, medioDigital);
        this.codigoDigital = codigoDigital;
    }

    // Getters y Setters
    public String getCodigoDigital() {
        return codigoDigital;
    }

    public void setCodigoDigital(String codigoDigital) {
        this.codigoDigital = codigoDigital;
    }
}
