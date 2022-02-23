import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String folderPath = "D:\\мое";
        File file = new File(folderPath);

        long start = System.currentTimeMillis();

        FolderSizeCalculator folderSizeCalculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(folderSizeCalculator);
        System.out.println(size);

        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms");
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
}