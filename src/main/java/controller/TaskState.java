package controller;

public enum TaskState  {

        NEW("new"),
        WIP("in progress"),
        DONE ("done"),
        CLOSED ("closed");

        TaskState(String name) {
            this.statusName = name;
        }

        private String statusName;


        public String getStatusName() {
            return statusName;
        }



}


