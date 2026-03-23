package SESSION12.SESSION12_05.Entity;

public class Bneed {
    private String Bneed_id;
    private String Name;
    private Integer Age;
    private String Treatment;

    public Bneed() {}

    public Bneed(String bneed_id, String name, Integer age, String treatment) {
        Bneed_id = bneed_id;
        Name = name;
        Age = age;
        Treatment = treatment;
    }

    public String getBneed_id() {
        return Bneed_id;
    }

    public void setBneed_id(String bneed_id) {
        Bneed_id = bneed_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getTreatment() {
        return Treatment;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
               "ID        : " + Bneed_id + "\n" +
               "Name      : " + Name + "\n" +
               "Age       : " + Age + "\n" +
               "Treatment : " + Treatment + "\n" +
               "-----------------------------";
    }
}
