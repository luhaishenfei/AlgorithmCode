package LC.undo;

import java.util.Arrays;

public class LC1487getFolderNames {
    public static void main(String[] args) {
        LC1487getFolderNames l = new LC1487getFolderNames();
        String[] names={"t1","t2","t1","t6","t3"};
        l.getFolderNames(names);

    }

    public String[] getFolderNames(String[] names) {
        Arrays.sort(names);
        return names;

    }
}