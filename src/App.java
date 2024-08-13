/**
 * App
 */
public class App {

    public static void main(String[] args) {
        // buat object
        OVO user = new OVO("Jamesdry", 811605081, 0, 0, "Vito Louis", 12345, 3211, 0);

        OVO ovo = new OVO("Jamesdry", 811605081, user.securityCodeUser1, user.saldoUser1,"Vito Louis", 12345, 3211, user.saldoUser2);
        ovo.tampilkanHomepage();

        
    }
}