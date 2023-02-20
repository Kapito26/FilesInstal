import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String CurrentDir = "D:/Games";
        StringBuilder log = new StringBuilder("");
        log.append(CreateDir(CurrentDir));
        log.append(CreateDir(CurrentDir + "/src"));
        log.append(CreateDir(CurrentDir + "/res"));
        log.append(CreateDir(CurrentDir + "/savegames"));
        log.append(CreateDir(CurrentDir + "/temp"));
        log.append(CreateDir(CurrentDir + "/src/main"));
        log.append(CreateDir(CurrentDir + "/src/test"));
        log.append(CreateFile(CurrentDir + "/src/main", "Main.java"));
        log.append(CreateFile(CurrentDir + "/src/main", "Utils.java"));
        log.append(CreateDir(CurrentDir + "/res/drawables"));
        log.append(CreateDir(CurrentDir + "/res/vectors"));
        log.append(CreateDir(CurrentDir + "/res/icons"));
        log.append(CreateFile(CurrentDir + "/temp", "temp.txt"));

        try (FileWriter writer = new FileWriter("D:/Games/temp/temp.txt")) {
            writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String CreateDir(String d) {
        File newS = new File(d);
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        if (newS.mkdir())
            return (localDateTime + " Cоздание УСПЕШНО " + d + " \n");
        else
            return (localDateTime + " Создание НЕ УСПЕШНО " + d + " \n");
    }

    public static String CreateFile(String d, String f) {
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