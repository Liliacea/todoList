package controller;

import model.TaskContext;

public interface IState {
    void takeToWork(TaskContext taskContext);
    void getDone(TaskContext taskContext);
    void closeTask(TaskContext taskContext);
    void backToNew(TaskContext taskContext);
    String getStatusName();
}
