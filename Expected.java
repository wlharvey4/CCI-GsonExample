import com.google.gson.*;

public class Expected extends AExpected {
    private static String expected;
    Gson gson = new Gson();

    /* no args constructor */
    public Expected() {}

    /* expected: JSON Element
       fromJson method can accept a JsonElement as well as a String
    */
    public Expected(JsonElement expected) {
	this.expected = gson.fromJson(expected, String.class);
    }

    public String getExpected() {
	return this.expected;
    }

    public String toString() {
	return "Expected expected: " + this.expected;
    }
}
