package bdbt_bada_project.SpringApplication;

public class Domy {
    private int id_domu;
    private String nazwa;
    private String data_zalozenia;
    private String wlasciciel;
    private int id_adresu;


    public Domy() {
    }

    public Domy(int id_domu, String nazwa, String data_zalozenia, String wlasciciel, int id_adresu) {
        this.id_domu = id_domu;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.wlasciciel = wlasciciel;
        this.id_adresu = id_adresu;
    }

    public int getId_domu() {
        return id_domu;
    }

    public void setId_domu(int id_domu) {
        this.id_domu = id_domu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(String data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Domy{" +
                "id_domu=" + id_domu +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia='" + data_zalozenia + '\'' +
                ", wlasciciel='" + wlasciciel + '\'' +
                ", id_adresu=" + id_adresu +
                '}';
    }
}