package practice.interview.sina;

import java.util.Arrays;

public class MinVersion {
    public String getMinVersion(String[] list) {
        Version[] versions = new Version[list.length];
        for (int i = 0; i < list.length; i++)
            versions[i] = new Version(list[i]);
        Arrays.sort(versions);
        return versions[0].toString();
    }

    private static class Version implements Comparable<Version> {
        private int[] v;
        private String version;

        Version(String version) {
            this.version = version;
            String[] versions = version.split("\\.");
            v = new int[versions.length];
            for (int i = 0; i < versions.length; i++)
                v[i] = Integer.parseInt(versions[i]);
        }

        @Override
        public int compareTo(Version o) {
            int min = Math.min(v.length, o.v.length);
            for (int i = 0; i < min; i++) {
                int sub = v[i] - o.v[i];
                if (sub != 0) return sub;
            }
            return v.length - o.v.length;
        }

        @Override
        public String toString() {
            return version;
        }
    }
}