package Thread.Detyra.detyrai;

public class VeturaGaruese extends MjetiGaruese {

    private boolean perfundimiGares = false;


    public VeturaGaruese(String prodhuesi, int vitiProdhimit, double volumiMotorit, int pozitaStartuese, int gjatesiaPistes) throws GaraException {
        super(prodhuesi, vitiProdhimit, volumiMotorit, pozitaStartuese, gjatesiaPistes);
        if (volumiMotorit < 2.0) {
            throw new GaraException("Nje veture garuese nuk mund te kete volumin e motorit me te vogel se 2.0 kubik");
        }

    }

    // Garon interface
    @Override
    public String getLloji() {
        return "Vetura";
    }

    public void garo() throws GaraException{

    }

    public void run() {

    }

}
