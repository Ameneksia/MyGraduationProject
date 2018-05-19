package travkina.vv.mygraduationproject;



public class MyFile {

    private String nameFile;
    private boolean flag;

    MyFile(String name){
        this.nameFile = name;
        this.flag = false;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
