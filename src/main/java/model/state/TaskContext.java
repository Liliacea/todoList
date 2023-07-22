package model.state;

public class TaskContext {
    private IState iState;
    public TaskContext() {
        this.setiState(new NewState());
    }

    private String getStateName(){
        return iState.getStatusName();
    }
    public void wip(){
       iState.takeToWork(this);
    };
    public void  Done(){
        iState.getDone(this);
    };
    public void closeTask(){
        iState.closeTask(this);
    };
    public void backToNew(){
        iState.backToNew(this);
    };


    public void setiState(IState iState) {
        this.iState = iState;
    }
    public IState getiState() {
        return iState;
    }
    public String getStatusName(){
        return iState.getStatusName();
    }
}
