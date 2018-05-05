
package model;

public class Carta {
    private String value;
    private String naipe;

    public Carta(String value, String naipe) {
        this.value = value;
        this.naipe = naipe;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
    
}
