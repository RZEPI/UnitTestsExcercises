//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Repository {
    private Map<Integer, Entity> database = new HashMap();
    private int key = 0;

    public Repository() {
    }

    public Optional<Entity> findElement(int id) {
        return Optional.ofNullable((Entity)this.database.get(id));
    }

    private boolean isSameId(int id) {
        Optional<Entity> foundElement = this.findElement(id);
        return foundElement.isPresent();
    }

    public void addElement(Integer id, Entity newField) throws IllegalArgumentException {
        if (id != null) {
            if (this.isSameId(id)) {
                throw new IllegalArgumentException("Element with this id is already in repository");
            }

            this.database.put(id, newField);
        } else {
            while(true) {
                if (this.database.get(this.key) == null) {
                    this.database.put(this.key, newField);
                    ++this.key;
                    break;
                }

                ++this.key;
            }
        }

    }

    public void removeElement(int id) {
        Optional<Entity> elementToRemoval = this.findElement(id);
        if (elementToRemoval.isPresent()) {
            this.database.remove(id);
        } else {
            throw new IllegalArgumentException("Element with this id isn't in repository");
        }
    }
}
