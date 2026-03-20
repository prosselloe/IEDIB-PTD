public class Album {
    private final Cromo[] album = new Cromo[864];
    private int nombreCromos = 0;

    public Album() {
        // nombreCromos = 0;
    }

    private boolean aferrarCromo(Cromo cromo) {
        // System.out.println("getposicioAlbum: " + cromo.getposicioAlbum());
        if (album[cromo.getposicioAlbum()] == null) {
            album[cromo.getposicioAlbum()] = cromo;
            nombreCromos++;
            return true;
        } else {
            return false;
        }
    }

    public int getnombreCromos() {
        return nombreCromos;
    }

    public void aferrarPaquet(Paquet paquet) {
        // System.out.println("getCromos().Size: " + paquet.getCromos().size());
        for (int i = 0; i < paquet.getCromos().size(); i++) {
            aferrarCromo(paquet.getCromos().get(i));
        }
    }

    public static void main(String args[]) {
        Album album1 = new Album();
        Album album2 = new Album();
        Paquet paquet = new Paquet();
        album1.aferrarPaquet(paquet);
        System.out.println("Album 1: " + album1.getnombreCromos());
        album2.aferrarPaquet(paquet);
        System.out.println("Album 2: " + album2.getnombreCromos());
    }
}
