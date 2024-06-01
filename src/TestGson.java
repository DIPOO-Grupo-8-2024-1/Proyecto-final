import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        MyObject obj = new MyObject();
        obj.setName("Test");
        obj.setValue(123);
        String json = gson.toJson(obj); // Serializa el objeto a JSON
        System.out.println("JSON output: " + json);
    }
}

class MyObject {
    private String name;
    private int value;

    // Getters y setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}
