package it.epicode.progetto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        System.out.println("Crea 5 elementi multimediali a scelta tra Immagini, Video o Audio.");

        for (int i = 0; i < 5; i++) {
            System.out.println("\n--- Creazione dell'elemento #" + (i + 1) + " ---");
            System.out.println("Inserisci il tipo di elemento (1- Immagine, 2- Video, 3- Audio):");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il titolo dell'elemento:");
            String titolo = scanner.nextLine();

            if (tipo == 1) { // Immagine
                System.out.println("Inserisci la luminosità dell'immagine (1-5):");
                int luminosita = scanner.nextInt();
                scanner.nextLine();
                elementi[i] = new Immagine(titolo, luminosita);

            } else if (tipo == 2) { // Video
                System.out.println("Inserisci la durata del video in minuti (tra 0.1 e 30):");
                double durata = scanner.nextDouble();
                System.out.println("Inserisci il volume del video (1-5):");
                int volume = scanner.nextInt();
                System.out.println("Inserisci la luminosità del video (1-5):");
                int luminosita = scanner.nextInt();
                scanner.nextLine();
                elementi[i] = new Video(titolo, durata, volume, luminosita);

            } else if (tipo == 3) { // Audio
                System.out.println("Inserisci la durata dell'audio in minuti (tra 0.1 e 30):");
                double durata = scanner.nextDouble();
                System.out.println("Inserisci il volume dell'audio (1-5):");
                int volume = scanner.nextInt();
                scanner.nextLine();
                elementi[i] = new Audio(titolo, durata, volume);
            } else {
                System.out.println("Tipo non valido. Riprova.");
                i--;
            }
        }

        while (true) {
            System.out.println("\nScegli un elemento da eseguire (1-5) o 0 per terminare:");
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + ". " + elementi[i].getTitolo());
            }
            int scelta = scanner.nextInt();

            if (scelta == 0) {
                break;
            } else if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                elemento.play();

                // Gestione audio
                if (elemento instanceof Audio audio) {
                    while (true) {
                        System.out.println("\nVuoi alzare o abbassare il volume? (1- Alza, 2- Abbassa, 0- Nessuna azione)");
                        int azione = scanner.nextInt();

                        if (azione == 1) {
                            audio.alzaVolume();
                            audio.play();
                        } else if (azione == 2) {
                            audio.abbassaVolume();
                            audio.play();
                        } else if (azione == 0) {
                            break;
                        } else {
                            System.out.println("Scelta non valida. Riprova.");
                        }
                    }
                }

                // Gestione video
                if (elemento instanceof Video video) {
                    while (true) {
                        System.out.println("\nVuoi alzare o abbassare il volume? (1- Alza, 2- Abbassa, 0- Nessuna azione)");
                        int azioneVolume = scanner.nextInt();
                        System.out.println("Vuoi alzare o abbassare la luminosità? (3- Alza, 4- Abbassa, 0- Nessuna azione)");
                        int azioneLuminosita = scanner.nextInt();

                        if (azioneVolume == 1) {
                            video.alzaVolume();
                        } else if (azioneVolume == 2) {
                            video.abbassaVolume();
                        }

                        if (azioneLuminosita == 3) {
                            video.aumentaLuminosita();
                        } else if (azioneLuminosita == 4) {
                            video.diminuisciLuminosita();
                        }

                        video.play();

                        if (azioneVolume == 0 && azioneLuminosita == 0) {
                            break;
                        }
                    }
                }

            } else {
                System.out.println("Scelta non valida. Riprovare.");
            }
        }

        scanner.close();
    }
}
