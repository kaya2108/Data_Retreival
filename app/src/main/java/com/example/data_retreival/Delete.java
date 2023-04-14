package com.example.data_retreival;

public class Delete {
    private String delete;
    private String success;
    private String uniqueID;

    public Delete(String delete, String success, String uniqueID) {
        this.delete = delete;
        this.success = success;
        this.uniqueID = uniqueID;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getDelete() {
        return delete;
    }

    public String getSuccess() {
        return success;
    }

    public String getUniqueID() {
        return uniqueID;
    }
}
