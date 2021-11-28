package io.github.divios.utils;

public class Utils {

    public static boolean testThrow(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
