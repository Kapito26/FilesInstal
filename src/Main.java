import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String currentDir = "D:/Games";
        StringBuilder log = new StringBuilder("");
        log.append(createDir(currentDir));
        log.append(createDir(currentDir + "/src"));
        log.append(createDir(currentDir + "/res"));
        log.append(createDir(currentDir + "/savegames"));
        log.append(createDir(currentDir + "/temp"));
        log.append(createDir(currentDir + "/src/main"));
        log.append(createDir(currentDir + "/src/test"));
        log.append(createFile(currentDir + "/src/main", "Main.java"));
        log.append(createFile(currentDir + "/src/main", "Utils.java"));
        log.append(createDir(currentDir + "/res/drawables"));
        log.append(createDir(currentDir + "/res/vectors"));
        log.append(createDir(currentDir + "/res/icons"));
        log.append(createFile(currentDir + "/temp", "temp.txt"));

        try (FileWriter writer = new FileWriter("D:/Games/temp/temp.txt")) {
            writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String createDir(String d) {
        File newS = new File(d);
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        if (newS.mkdir())
            return (localDateTime + " Cоздание УСПЕШНО " + d + " \n");
        else
            return (localDateTime + " Создание НЕ УСПЕШНО " + d + " \n");
    }

    public static String createFile(String d, String f) {
        File newS = new File(d, f);
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        try {
            if (newS.createNewFile())
                return (localDateTime + " Cоздание УСПЕШНО " + d + "/" + f + " \n");
            else
                return (localDateTime + " Создание НЕ УСПЕШНО " + d + "/" + f + " \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}