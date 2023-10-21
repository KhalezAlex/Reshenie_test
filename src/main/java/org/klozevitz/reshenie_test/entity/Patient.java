import java.time.LocalDate;

public class Patient {
    private Integer id;
    private String fio;
    private LocalDate birthDate;
    private Integer sex;
    private Integer num;
    private String smo;
    private String snils;
    private String policy;
    private Integer fin_source;

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getNum() {
        return num;
    }

    public String getSmo() {
        return smo;
    }

    public String getSnils() {
        return snils;
    }

    public String getPolicy() {
        return policy;
    }

    public Integer getFin_source() {
        return fin_source;
    }

    public Patient() {
    }

    public Patient(Integer id, String fio, Integer num) {
        this.id = id;
        this.fio = fio;
        this.num = num;
    }

    public Patient(Integer id, String fio, LocalDate birthDate, Integer sex,
                   Integer num, String smo, String snils, String policy, Integer fin_source) {
        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
        this.sex = sex;
        this.num = num;
        this.smo = smo;
        this.snils = snils;
        this.policy = policy;
        this.fin_source = fin_source;
    }
}
