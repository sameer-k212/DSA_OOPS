public class LestestVersion {

    public static int findLatestVersion(String[] files, int size) {
        if (size == 0) {
            return -1;
        }

        int latestVersion = -1;

        for (String file : files) {
            if (file.startsWith("File_")) {
                String versionStr = file.substring(5); // Get the substring after "File_"
                try {
                    int version = Integer.parseInt(versionStr);
                    if (version > latestVersion) {
                        latestVersion = version;
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid version strings
                }
            }
        }

        return latestVersion == -1 ? -1 : latestVersion;
    }

    public static void main(String[] args) {
        String[] files = {"File_1", "File_3", "File_2"};
        int size = 3;

        int latestVersion = findLatestVersion(files, size);
        System.out.println(latestVersion);
    }

}
