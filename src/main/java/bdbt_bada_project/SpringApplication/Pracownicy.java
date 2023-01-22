package bdbt_bada_project.SpringApplication;

public class Pracownicy {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private String plec;
    private String stanowisko;
    private int placa;
    private String adres_email;
    private String telefon;
    private String data_zatrudnienia;
    private String data_zwolnienia;
    private int id_domu;
    private int id_adresu;

    public Pracownicy() {
    }
    public Pracownicy(int id_pracownika, String imie, String nazwisko, String data_urodzenia, String plec, String stanowisko, int placa, String adres_email, String telefon, String data_zatrudnienia, String data_zwolnienia, int id_domu, int id_adresu) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.stanowisko = stanowisko;
        this.placa = placa;
        this.adres_email = adres_email;
        this.telefon = telefon;
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zwolnienia = data_zwolnienia;
        this.id_domu = id_domu;
        this.id_adresu = id_adresu;
    }

    public int getId_pracownika() {return id_pracownika;}

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getAdres_email() {
        return adres_email;
    }

    public void setAdres_email(String adres_email) {
        this.adres_email = adres_email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getData_zwolnienia() {
        return data_zwolnienia;
    }

    public void setData_zwolnienia(String data_zwolnienia) {
        this.data_zwolnienia = data_zwolnienia;
    }

    public int getId_domu() {
        return id_domu;
    }

    public void setId_domu(int id_domu) {
        this.id_domu = id_domu;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "id=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", plec='" + plec + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                ", placa=" + placa +
                ", adres_email='" + adres_email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", data_zwolnienia='" + data_zwolnienia + '\'' +
                ", id_domu=" + id_domu +
                ", id_adresu=" + id_adresu +
                '}';
    }
}

