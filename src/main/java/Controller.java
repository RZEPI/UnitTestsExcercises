//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Optional;

public class Controller {
    private Repository repository;

    Controller(Repository repository) {
        this.repository = repository;
    }

    public String removeElement(int id) {
        try {
            this.repository.removeElement(id);
            return "done";
        } catch (IllegalArgumentException var3) {
            return "not found";
        }
    }

    public String findElement(int id) {
        Optional<Entity> foundElement = this.repository.findElement(id);
        return foundElement.isPresent() ? ((Entity)foundElement.get()).toString() : "not found";
    }

    public String addElement(Integer id, String name, int level) {
        Entity newElement = new Entity(name, level);

        try {
            this.repository.addElement(id, newElement);
            return "done";
        } catch (IllegalArgumentException var8) {
            return "bad request";
        }
    }
}
