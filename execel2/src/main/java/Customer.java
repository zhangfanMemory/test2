
public class Customer {
    private String gonghao;
    private String name;
    private String bumen;
    private String data;
    private String week;
    private String normalGoWorkData;
    private String noramlOutWorkData;

    public String getExtrnWorkTime() {
        return extrnWorkTime;
    }

    public void setExtrnWorkTime(String extrnWorkTime) {
        this.extrnWorkTime = extrnWorkTime;
    }

    public String getAbnoramlGoWork() {
        return abnoramlGoWork;
    }

    public void setAbnoramlGoWork(String abnoramlGoWork) {
        this.abnoramlGoWork = abnoramlGoWork;
    }

    public String getAbnormalOutWork() {
        return abnormalOutWork;
    }

    public void setAbnormalOutWork(String abnormalOutWork) {
        this.abnormalOutWork = abnormalOutWork;
    }

    private String personalGoWorkData;
    private String personalOutWorkData;
    private String extrnWorkTime;
    private String abnoramlGoWork;
    private String abnormalOutWork;

    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNormalGoWorkData() {
        return normalGoWorkData;
    }

    public void setNormalGoWorkData(String normalGoWorkData) {
        this.normalGoWorkData = normalGoWorkData;
    }

    public String getNoramlOutWorkData() {
        return noramlOutWorkData;
    }

    public void setNoramlOutWorkData(String noramlOutWorkData) {
        this.noramlOutWorkData = noramlOutWorkData;
    }

    public String getPersonalGoWorkData() {
        return personalGoWorkData;
    }

    public void setPersonalGoWorkData(String personalGoWorkData) {
        this.personalGoWorkData = personalGoWorkData;
    }

    public String getPersonalOutWorkData() {
        return personalOutWorkData;
    }

    public void setPersonalOutWorkData(String personalOutWorkData) {
        this.personalOutWorkData = personalOutWorkData;
    }
//这里get/set方法省略不贴

    public String getGonghao() {
        return gonghao;
    }

    public void setGonghao(String gonghao) {
        this.gonghao = gonghao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "gonghao='" + gonghao + '\'' +
                ", name='" + name + '\'' +
                ", bumen='" + bumen + '\'' +
                ", data='" + data + '\'' +
                ", week='" + week + '\'' +
                ", normalGoWorkData='" + normalGoWorkData + '\'' +
                ", noramlOutWorkData='" + noramlOutWorkData + '\'' +
                ", personalGoWorkData='" + personalGoWorkData + '\'' +
                ", personalOutWorkData='" + personalOutWorkData + '\'' +
                ", extrnWorkTime='" + extrnWorkTime + '\'' +
                ", abnoramlGoWork='" + abnoramlGoWork + '\'' +
                ", abnormalOutWork='" + abnormalOutWork + '\'' +
                '}';
    }
}
