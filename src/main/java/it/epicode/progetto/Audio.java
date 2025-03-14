package it.epicode.progetto;

public class Audio extends ElementoMultimediale implements Riproducibile {

    private double durata;
    private int volume;

    public Audio(String titolo, double durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    @Override
    public double durata() {
        return durata;
    }

    @Override
    public void play() {
        for (int i = 0; i < (int) durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
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
}

