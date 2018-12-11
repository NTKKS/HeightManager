package cz.uhk.fim.heightmanager.model;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public FileUtil() {
    }

    private static final String CONFIG_FILE = "height.csv";

    public static String loadStringFromFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static void saveStringToFile(String filepath, byte[] data) throws IOException {
        Path path = Paths.get(filepath);
        Files.write(path, data);
    }

    public static List<HeightItem> loadSources(){
        List<HeightItem> sources = new ArrayList<>();
        try {
            new BufferedReader(new StringReader(loadStringFromFile(CONFIG_FILE)))
                    .lines().forEach(lines -> {
                String[] parts = lines.split(";");
                sources.add(new HeightItem(parts[0],parts[1],Double.valueOf(parts[2]),parts[3]));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sources;
    }

    public static void saveSources (List<HeightItem> sources){
        StringBuilder fileContent = new StringBuilder();
        for (int i = 0; i<sources.size();i++){
            fileContent.append(String.format("%s;%s;%s;%s",
                    sources.get(i).getJmeno(),
                    sources.get(i).getPrijmeni(),
                    sources.get(i).getVyska(),
                    sources.get(i).getDatumZapisu()));
            fileContent.append(i != sources.size() - 1 ? "\n" : "");
        }
        JOptionPane.showMessageDialog(null,"Uspesne ulozeno");
        try {
            saveStringToFile(CONFIG_FILE,fileContent.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Nezdarilo se");
        }
    }


}
