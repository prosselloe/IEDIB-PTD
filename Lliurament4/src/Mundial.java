public class Mundial {

    public static boolean participaAlMundial2026(String codiPais) {
        String[] paisosClassificats = {
                "USA",
                "MEX",
                "CAN",
                "JPN",
                "IRN",
                "UZB",
                "KOR",
                "JOR",
                "AUS",
                "ARG",
                "BRA",
                "ECU",
                "COL",
                "URY",
                "PAR",
                "MAR",
                "TUN",
                "EGY",
                "ALG",
                "GHA",
                "CPV",
                "ZAF",
                "SEN",
                "AUT",
                "BEL",
                "CRO",
                "ENG",
                "FRA",
                "GER",
                "NED",
                "NOR",
                "POR",
                "ESP",
                "SUI",
                "SCO"
        };

        for (String pais : paisosClassificats) {
            if (pais.equalsIgnoreCase(codiPais)) {
                return true;
            }
        }
        return false;
    }
}