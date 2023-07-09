package controller;

import model.TaskContext;


public class WorkInProgress implements IState {
   TaskContext taskContext;

    @Override
    public void takeToWork(TaskContext taskContext) {
        taskContext.setiState(new WorkInProgress());
    }

    @Override
    public void getDone(TaskContext taskContext) {
    taskContext.setiState(new Done());
    }

    @Override
    public void closeTask(TaskContext taskContext) {
    taskContext.setiState(new Closed());
    }

    @Override
    public void backToNew(TaskContext taskContext) {
    taskContext.setiState(new NewState());
    }

    @Override
    public String getStatusName() {
        return TaskState.WIP.getStatusName();
    }
}
