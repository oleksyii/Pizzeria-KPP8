package code.example.demo2.CooksManagement;

public abstract class Cook {
    protected int id = 0;
    private String Task;

    public int Id() {return id;}
    public abstract String takeTask();
    public abstract void processPizza();
    /**
     * Function to stop a thread of a
     * @return 1 on success 0 on fail
     * */
    public abstract int stopCook();
}
