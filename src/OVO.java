import java.util.Random;
import java.util.Scanner;

public class OVO {
    // user pertama
    public float saldoUser1;
    public float historiTransaksiUser1;
    public int nomorHPUser1;
    public int angkaOTPRandom;
    public String namaUser1;
    public int securityCodeUser1;
    public float angkaNominalTransferUser1;
    
    // user kedua
    public float saldoUser2;
    public float historiTransaksiUser2;
    public int nomorHPUser2;
    public int angkaOTPRandomUserDua;
    public String namaUser2;
    public int securityCodeUser2;
    public float angkaNominalTransferUser2;

    // function method
    // buat object 
    OVO(String username, int nomorHandphone, int pinUserKesatu, float balanceUserPertama, String usernameUserDua, int nomorHandphoneUserDua, int pinUserKedua, float balanceUserKedua) {
        // user pertama
        namaUser1 = username;
        nomorHPUser1 = nomorHandphone;
        securityCodeUser1 = pinUserKesatu;
        saldoUser1 = balanceUserPertama;
        

        // user kedua
        namaUser2 = usernameUserDua;
        nomorHPUser2 = nomorHandphoneUserDua;
        securityCodeUser2 = pinUserKedua;
        saldoUser2 = balanceUserKedua;
    }

    public void cekNomorHP(int inNomorHP) {
        if (inNomorHP == nomorHPUser1) {
            tampilkanHalamanVerifikasiNomorHP();
        } else {
            System.out.println();
            System.out.println("Nomor HP Tidak Ditemukan !");
            tampilkanHalamanDaftarNomorHP();
        }
    }

    public void cekNomorHPSetelahSignOut(int inNomorHP) {
        if (inNomorHP == nomorHPUser1 || inNomorHP == nomorHPUser2) {
            tampilkanHalamanMasukinSecurityCode();
        } else {
            System.out.println();
            System.out.println("Nomor HP Tidak Ditemukan !");
            tampilkanHalamanDaftarNomorHPSetelahSignOut();
        }
    }

    public void tampilkanKodeOTPRandom() {
        Random random = new Random();
        int generateRandomNumber = 5000; // randomize angka dari 0 - 4999
        int randomizeAngka = random.nextInt(generateRandomNumber);
        System.out.println(randomizeAngka);
        angkaOTPRandom = randomizeAngka;
    }

    public void cekKodeOTP(int inKodeOTP) {
        if (inKodeOTP == angkaOTPRandom) {
            tampilkanHalamanBikinSecurityCode();
        } else {
            System.out.println();
            System.out.println("Kode OTP Tidak Sesuai !");
            tampilkanHalamanVerifikasiNomorHP();
        }
    }

    public void cekSecurityCode(int codeYangDiinput) {
        securityCodeUser1 = codeYangDiinput;
        tampilkanHalamanVerifikasiSecurityCode();
    }

    public void cekVerifikasiSecurityCode(int verifikasiCodeYangDiinput) {
        if (verifikasiCodeYangDiinput == securityCodeUser1) {
            System.out.println();
            System.out.println("Verifikasi Berhasil !");
            tampilkanMainMenuOVOUser1();
        } else {
            System.out.println();
            System.out.println("Security Code Tidak Sesuai !");
            tampilkanHalamanBikinSecurityCode();
        }
    }

    public void topUpUang(float inputNominalTopUp) {
        saldoUser1 = saldoUser1 + inputNominalTopUp;
        historiTransaksiUser1 = inputNominalTopUp;
    }

    public void tarikUang(float inputNominalTarikUang) {
        if (inputNominalTarikUang > saldoUser1) {
            System.out.println();
            System.out.println("Saldo Tidak Mencukupi Untuk Melakukan Penarikan Uang !");
        } else {
            saldoUser1 = saldoUser1 - inputNominalTarikUang;
            historiTransaksiUser1 = -inputNominalTarikUang;    
        }

    }

    public void historiTransaksi() {
        if (historiTransaksiUser1 > 0) {
            System.out.println("Kamu Baru Saja Mendeposit Uang Sebanyak Rp. " + historiTransaksiUser1);
        } else if (historiTransaksiUser1 < 0) {
            System.out.println("Kamu Baru Saja Menarik Uang Sebanyak Rp. " + Math.abs(historiTransaksiUser1));
        }
    }

    public void cekMasukkinSecurityCode(int inputSecurityCode) {
        if (inputSecurityCode == securityCodeUser1) {
            tampilkanMainMenuOVOUser1();
        } else if (inputSecurityCode == securityCodeUser2) {
            OVOUserDua ovoUserDua = new OVOUserDua("Jamesdry", 811605081, securityCodeUser1, saldoUser1,"Vito Louis", 12345, 3211, saldoUser2);
            ovoUserDua.tampilkanMainMenuOVOUser2();
        } else {
            System.out.println();
            System.out.println("Security Code Salah !");
            tampilkanHalamanDaftarNomorHPSetelahSignOut();
        }
    }

    public void cekNomorPonselPadaHalamanTransfer(int inputNomorPonsel) {
        if (inputNomorPonsel == nomorHPUser2) {
            System.out.println("Kamu Ingin Mentransfer Ke Nomor : " + nomorHPUser2);
            System.out.println("Nama Pengguna OVO : " + namaUser2);
        } else {
            System.out.println();
            System.out.println("Nomor Ponsel Tidak Dapat Ditemukan !");
            tampilkanMenuTransfer();
        }
    }

    public void cekInputNominalTransfer(float nominalTransfer) {
        if (nominalTransfer > saldoUser1) {
            System.out.println();
            System.out.println("Saldo Tidak Mencukupi Untuk Melakukan Transfer !");
            tampilkanMenuTransfer();
        } else if (nominalTransfer < saldoUser1) {
            saldoUser1 = saldoUser1 - nominalTransfer;
        }
    }

    public void cekAngkaTransfer(int inputAngkaTransfer) {
        if (inputAngkaTransfer == 1) {
            System.out.println();
            System.out.println("Lagi Diproses......");
            System.out.println("Kamu Berhasil Mentransfer Uang Sebanyak " + angkaNominalTransferUser1 + " ke " + namaUser2);
            saldoUser2 = saldoUser2 + angkaNominalTransferUser1;
            tampilkanMainMenuOVOUser1();
        } else if (inputAngkaTransfer == 2) {
            saldoUser1 = saldoUser1 + angkaNominalTransferUser1;
            tampilkanMainMenuOVOUser1();
        }
    }


    // main method
    public void tampilkanHomepage() {
        System.out.println("OVO");
        System.out.println("Solusi Cerdas Finansial");
        System.out.println("Nikmati berbagai layanan finansial dan kemudahan pembayaran dalam genggaman.");
        tampilkanHalamanDaftarNomorHP();
    }

    public void tampilkanHomepageSetelahSignOut() {
        System.out.println("OVO");
        System.out.println("Solusi Cerdas Finansial");
        System.out.println("Nikmati berbagai layanan finansial dan kemudahan pembayaran dalam genggaman.");
        tampilkanHalamanDaftarNomorHPSetelahSignOut();
    }

    public void tampilkanHalamanDaftarNomorHP() {
        System.out.println();
        System.out.println("Masuk atau Daftar");
        System.out.println("Masuk atau daftar cuma butuh nomor HP aja.");

        Scanner inputNomorHP = new Scanner(System.in);
        System.out.print("Masukkan Nomor HP +62 ");
        int nomorHP = inputNomorHP.nextInt();
        cekNomorHP(nomorHP);

        inputNomorHP.close();
    }

    public void tampilkanHalamanDaftarNomorHPSetelahSignOut() {
        System.out.println();
        System.out.println("Masuk atau Daftar");
        System.out.println("Masuk atau daftar cuma butuh nomor HP aja.");

        Scanner inputNomorHP = new Scanner(System.in);
        System.out.print("Masukkan Nomor HP +62 ");
        int nomorHP = inputNomorHP.nextInt();
        cekNomorHPSetelahSignOut(nomorHP);

        inputNomorHP.close();
    }

    public void tampilkanHalamanMasukinSecurityCode() {
        System.out.println();
        System.out.println("Masukkin Security Code");
        
        Scanner masukkanSecurityCode = new Scanner(System.in);
        System.out.print("Masukkin Security Code Yang Telah Dibuat: ");
        int securityCode = masukkanSecurityCode.nextInt();
        cekMasukkinSecurityCode(securityCode);

        masukkanSecurityCode.close();
    }

    public void tampilkanHalamanVerifikasiNomorHP() {
        System.out.println();
        System.out.println("Verifikasi Nomor HP");
        System.out.println("Masukkin kode verifikasi yang dikirim ke +62 " + nomorHPUser1);

        tampilkanKodeOTPRandom();

        Scanner inputKodeOTP = new Scanner(System.in);
        System.out.print("Masukkan Kode OTP : ");
        int kodeOTP = inputKodeOTP.nextInt();
        cekKodeOTP(kodeOTP);

        inputKodeOTP.close();

    }
    
    public void tampilkanHalamanBikinSecurityCode() {
        System.out.println();
        System.out.println("Bikin Security Code");
        System.out.println("Buat keamanan bertransaksi dan akun kamu.");

        Scanner inputSecurityCode = new Scanner(System.in);
        System.out.print("Input Security Code Yang Ingin Dibuat: ");
        int code = inputSecurityCode.nextInt();
        cekSecurityCode(code);

        inputSecurityCode.close();
    }

    public void tampilkanHalamanVerifikasiSecurityCode() {
        System.out.println();
        System.out.println("Verifikasi Security Code");
        System.out.println("Masukkin kembali Security Code sebelumnya.");
        
        Scanner verifikasiSecurityCode = new Scanner(System.in);
        System.out.print("Input Security Code Yang Telah Diinput Sebelumnya: ");
        int verifikasiCode = verifikasiSecurityCode.nextInt();
        cekVerifikasiSecurityCode(verifikasiCode);

        verifikasiSecurityCode.close();

    }

    public void tampilkanMainMenuOVOUser1() {
        
        Scanner input = new Scanner(System.in);
        int opsiUser;
        
        do {
            System.out.println();
            System.out.println("Hello, " + namaUser1);
            System.out.println("OVO");
            System.out.println("OVO Cash");
            System.out.println("Total Saldo");
            System.out.println("Rp " + saldoUser1);

            // tampilkan menu
            System.out.println();
            System.out.println("[1] Top Up");
            System.out.println("[2] Tarik Tunai");
            System.out.println("[3] History");
            System.out.println("[4] Transfer");
            System.out.println("[5] Sign Out");

            System.out.println();
            System.out.print("Pilih Angka Dari Menu: ");
            opsiUser = input.nextInt();

            switch(opsiUser) {
                case 1 :
                    System.out.println();
                    System.out.print("Kamu Mau Top Up Berapa ? Rp. ");
                    float nominalTopUp = input.nextFloat();
                    topUpUang(nominalTopUp);
                    break;
                case 2 :
                    System.out.println();
                    System.out.print("Kamu Mau Tarik Berapa ? Rp. ");
                    float nominalTarikUang = input.nextFloat();
                    tarikUang(nominalTarikUang);
                    break;
                case 3 :
                    System.out.println();
                    historiTransaksi();
                    System.out.println();
                    break;
                case 4 :
                    tampilkanMenuTransfer();
                    break;
                case 5 :
                    tampilkanHomepageSetelahSignOut();
            }


        } while(opsiUser != 5);

        input.close();
    }

    public void tampilkanMenuTransfer() {
        System.out.println();
        System.out.println("[1] Ke Sesama OVO");
        System.out.println("[2] Back");

        Scanner inputAngkaMenu = new Scanner(System.in);
        System.out.print("Pilih Angka Dari Menu: ");
        int angkaMenu = inputAngkaMenu.nextInt();

        switch(angkaMenu) {
            case 1 :
                System.out.println();
                System.out.println("Sumber Dana");
                System.out.println("OVO Cash");
                System.out.println("Saldo Rp. " + saldoUser1);

                System.out.println();
                System.out.print("Masukkan nomor ponsel : ");
                int nomorPonsel = inputAngkaMenu.nextInt();
                cekNomorPonselPadaHalamanTransfer(nomorPonsel);

                System.out.println();
                System.out.println("Nominal Transfer");
                System.out.print("Rp. ");
                float inputNominalTransfer = inputAngkaMenu.nextFloat();
                cekInputNominalTransfer(inputNominalTransfer);

                angkaNominalTransferUser1 = inputNominalTransfer;

                tampilkanKonfirmasiTransfer();

                System.out.println();
                System.out.println("[1] Transfer");
                System.out.println("[2] Batalkan");

                System.out.println();
                System.out.print("Pilih Transfer Atau Batalkan ? : ");
                int angkaTransfer = inputAngkaMenu.nextInt();
                cekAngkaTransfer(angkaTransfer);
                break;

            case 2 :
                tampilkanMainMenuOVOUser1();
                break;

            default :  
                System.out.println();
                System.out.println("Invalid Input !");
                tampilkanMenuTransfer();
                break;
                
        }

        inputAngkaMenu.close();
    }

    public void tampilkanKonfirmasiTransfer() {
        System.out.println("=======================");
        System.out.println("Penerima");
        System.out.println(namaUser2);
        System.out.println("OVO - 0" + nomorHPUser2);

        System.out.println();
        System.out.println("Sumber Dana");
        System.out.println("OVO Cash");

        System.out.println();
        System.out.println("Detail");
        System.out.println("Nominal Transfer Rp. " + angkaNominalTransferUser1);
        System.out.println("Biaya Transaksi : Rp. 0.0");
        
        System.out.println();
        System.out.println("Total Rp. " + angkaNominalTransferUser1);
        System.out.println("=======================");
    }
}
