package hexlet.code;
// class for containing differences between old and new values
public final class Item {

    public static final String ADDED = "added";
    public static final String DELETED = "deleted";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private Object oldValue;
    private Object newValue;
    private String status;

    public Item(Object value1, Object value2, String status1) {

        this.oldValue = value1;
        this.newValue = value2;
        this.status = status1;

    }

    public Item(Object value1, String status1) {

        this.oldValue = value1;
        this.status = status1;
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
