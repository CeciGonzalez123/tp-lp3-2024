package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class GiftCardPapel extends Fisico {
    public String codigoGiftCard;

    // Constructor
    public GiftCardPapel(double monto, Date fecha, String estadoReversion, String tipoFisico, String codigoGiftCard) {
        super(monto, fecha, estadoReversion, tipoFisico);
        this.codigoGiftCard = codigoGiftCard;
    }

    // Getters y Setters
    public String getCodigoGiftCard() {
        return codigoGiftCard;
    }

    public void setCodigoGiftCard(String codigoGiftCard) {
        this.codigoGiftCard = codigoGiftCard;
    }
}
