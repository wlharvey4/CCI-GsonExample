import com.google.gson.*;

public class Params extends AParams {
    private static int n;
    private static int m;

    public Params() {}

    Gson gson = new Gson();

    /* params := JSON string */
    public Params(JsonElement params) {
	/* this code interprets JSON based upon needs of code challenge */
	ccParams ccp = gson.fromJson(params, ccParams.class);
	n = ccp.getN();
	m = ccp.getM();
    }

    public static int[] getParams() {
	return new int[]{n,m};
    }

    public String toString() {
	int[] ps = getParams();
	return "Params\tn: " + ps[0] + ", m: " + ps[1];
    }

    private class ccParams {
	private int n;
	private int m;

	public int getN() {
	    return n;
	}
	public int getM() {
	    return m;
	}
    }
}
