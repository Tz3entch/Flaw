package logic;

/**
 * Created by Сережа on 22.03.2016.
 */
public class GreenBlock {
    public boolean combine (boolean a, boolean b) {
        return a&&b;
    }

    public boolean combine (boolean a, boolean b, boolean c) {
        return a&&b&&c;
    }
}
