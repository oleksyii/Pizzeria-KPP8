package code.example.demo2.CooksManagement;

public class FullCook extends Cook{

    FullCook(){
        this.id++;
    }

    @Override
    public String takeTask() {
        return null;
    }

    @Override
    public void processPizza() {

    }

    @Override
    public int stopCook() {
        return 0;
    }
}
