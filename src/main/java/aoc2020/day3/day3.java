package aoc2020.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class day3 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/java/codeadvent/day3/dayThreeInput.txt");

        List<String> lines = Files.lines(path).collect(Collectors.toList());

        int numberOfLines = lines.size();
        System.out.println("numberOfLines = " + numberOfLines);

        int numberOfEncounteredTrees = lines.stream()
                .collect(TreesCollector1::new,
                        TreesCollector1::reduction,
                        TreesCollector1::join).getNumberOfEncounteredTrees();

        System.out.println("numberOfEncounteredTrees = " + numberOfEncounteredTrees);

        System.out.println("========================================");

        int result1 = collectFromCollector1(lines);
        System.out.println("result1 = " + result1);

        int result2 = collectFromCollector2(lines);
        System.out.println("result2 = " + result2);

        int result3 = collectFromCollector3(lines);
        System.out.println("result3 = " + result3);

        int result4 = collectFromCollector4(lines);
        System.out.println("result4 = " + result4);

        int result5 = collectFromCollector5(lines);
        System.out.println("result5 = " + result5);

        long product = (long) result1 * result2 * result3 * result4 * result5;
        System.out.println("product = " + product);
    }

    public static int collectFromCollector1(List<String> lines) {
        return lines.stream()
                .collect(TreesCollector1::new,
                        TreesCollector1::reduction,
                        TreesCollector1::join).getNumberOfEncounteredTrees();
    }

    public static int collectFromCollector2(List<String> lines) {
        return lines.stream()
                .collect(TreesCollector2::new,
                        TreesCollector2::reduction,
                        TreesCollector2::join).getNumberOfEncounteredTrees();
    }

    public static int collectFromCollector3(List<String> lines) {
        return lines.stream()
                .collect(TreesCollector3::new,
                        TreesCollector3::reduction,
                        TreesCollector3::join).getNumberOfEncounteredTrees();
    }

    public static int collectFromCollector4(List<String> lines) {
        return lines.stream()
                .collect(TreesCollector4::new,
                        TreesCollector4::reduction,
                        TreesCollector4::join).getNumberOfEncounteredTrees();
    }

    public static int collectFromCollector5(List<String> lines) {
        return lines.stream()
                .collect(TreesCollector5::new,
                        TreesCollector5::reduction,
                        TreesCollector5::join).getNumberOfEncounteredTrees();
    }
}
