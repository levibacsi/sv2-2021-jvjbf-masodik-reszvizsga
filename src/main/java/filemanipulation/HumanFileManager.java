package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            List <String> humansData = Files.readAllLines(path);
            stringToHuman(humansData);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public List<Human> findMales(){
        List<Human> males = new ArrayList<>();
        for (Human h: humans){
            if (h.getIdentityNumber().startsWith("1") || h.getIdentityNumber().startsWith("3")){
                males.add(h);
            }
        }
        return males;
    }

  public void writeMaleHumansToFile(Path path) {
        List<String> males = malesToString(findMales());
      try {
          Files.write(path, males);
      } catch (IOException ioe) {
          ioe.printStackTrace();
      }
    }

    public void stringToHuman(List<String> data){
        for (String s: data){
            String[] part = s.split(";");
            humans.add(new Human(part[0], part[1]));
        }
    }

    public List<String> malesToString (List<Human> humans){
        List<String> malesToWrite = new ArrayList<>();
        for (Human h: humans){
            malesToWrite.add(h.toString());
        }
        return malesToWrite;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
