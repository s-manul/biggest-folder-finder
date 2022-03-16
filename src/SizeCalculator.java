public class SizeCalculator {
    public static final String[] lettersSize = {"B", "KB", "MB", "GB", "TB"};

    public static String getHumanReadableSize(long size) {
        String result = "";
        for (int i = 0; i < lettersSize.length; i++) {
            if (size < Math.pow(2, (i + 1) * 10)) {
                result = Math.round(size / Math.pow(2, i * 10) * 100) / 100. + " " + lettersSize[i];
                break;
            }
        }
        return result;
    }

    public static long getSizeFromHumanReadable(String size) {
        long result = 0;
        for (int i = lettersSize.length - 1; i >= 0; i--) {
            if (size.contains(lettersSize[i])) {
                int number = Integer.parseInt(size.substring(0, size.indexOf(lettersSize[i])));
                result = number * (long) Math.pow(2, i * 10);
                break;
            }
        }
        return result;
    }
}
