package py.edu.uc.lp3.apirestjava11;

public class SkinArmas extends Skin {
    public String modeloArma;
    public String efectoVisual;

    // Constructor
    public SkinArmas(int id_producto, String nombre, double precio, boolean disponibilidad, String color, String rangoRaridad, String modeloArma, String efectoVisual) {
        super(id_producto, nombre, precio, disponibilidad, color, rangoRaridad); // Llamada correcta al constructor de Skin
        this.modeloArma = modeloArma;
        this.efectoVisual = efectoVisual;
    }

    // Getters y Setters
    public String getModeloArma() {
        return modeloArma;
    }

    public void setModeloArma(String modeloArma) {
        this.modeloArma = modeloArma;
    }

    public String getEfectoVisual() {
        return efectoVisual;
    }

    public void setEfectoVisual(String efectoVisual) {
        this.efectoVisual = efectoVisual;
    }
}
