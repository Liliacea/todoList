package model;

public enum TaskState {
    NEW("Новая"),
    WIP ("в процессе"),
    DONE ("Выполнено"),


    CLOSED ("Закрыта");

    private  String name;

    TaskState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
