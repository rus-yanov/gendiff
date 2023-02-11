package hexlet.code;

// class for containing differences between old and new values
public class Item {

    public static final String ADDED = "added";
    public static final String DELETED = "deleted";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private Object oldValue;
    private Object newValue;
    private String status;

    public Item(Object oldValue, Object newValue, String status) {

        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;

    }

    public Item(Object oldValue, String status) {

        this.oldValue = oldValue;
        this.status = status;
        this.newValue = null;

    }


    public Object getNewValue() {

        return this.newValue;

    }

    public Object getOldValue() {

        return this.oldValue;

    }

    public String getStatus() {

        return this.status;

    }
}
