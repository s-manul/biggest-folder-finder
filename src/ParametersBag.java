import java.io.File;

public class ParametersBag {
    private long limit;
    private String path;

    public ParametersBag(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Неверное количество параметров");
        }
        File folder = new File(args[1]);
        if (!folder.exists()) {
            throw new IllegalArgumentException("Неверный путь");
        }
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Передан путь к файлу, а не папке");
        }

        boolean isLimitCorrect = false;
        for (int i = 0; i < SizeCalculator.lettersSize.length; i++) {
            if (args[3].endsWith(SizeCalculator.lettersSize[i])) {
                isLimitCorrect = true;
                break;
            }
        }
        
        if(!isLimitCorrect) {
            throw new IllegalArgumentException("Неверный формат лимита");
        }

        path = args[1];
        limit = SizeCalculator.getSizeFromHumanReadable(args[3]);
    }

    public long getLimit() {
        return limit;
    }

    public String getPath() {
        return path;
    }
}
