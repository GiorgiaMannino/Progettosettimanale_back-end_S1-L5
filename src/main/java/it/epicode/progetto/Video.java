package it.epicode.progetto;

public class Video extends ElementoMultimediale implements Riproducibile {

    private double durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, double durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    @Override
    public double durata() {
        return durata;
    }

    @Override
    public void play() {
        for (int i = 0; i < (int) durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }

    public void alzaVolume() {
        if (volume < 5) {
            volume++;
            System.out.println("Volume aumentato a: " + volume);
        } else {
            System.out.println("Volume al massimo!");
        }
    }

    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
            System.out.println("Volume abbassato a: " + volume);
        } else {
            System.out.println("Volume al minimo!");
        }
    }

    public void aumentaLuminosita() {
        if (luminosita < 5) {
            luminosita++;
            System.out.println("Luminosità aumentata a: " + luminosita);
        } else {
            System.out.println("Luminosità al massimo!");
        }
    }

    public void diminuisciLuminosita() {
        if (luminosita > 1) {
            luminosita--;
            System.out.println("Luminosità abbassata a: " + luminosita);
        } else {
            System.out.println("Luminosità al minimo!");
        }
    }
}



