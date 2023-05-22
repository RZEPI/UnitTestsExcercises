//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Optional;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepoTests {
    private Repository repository;

    public RepoTests() {
    }

    @BeforeEach
    public void initRepository() {
        this.repository = new Repository();
        this.repository.addElement((Integer)null, new Entity("Saruman", 89));
        this.repository.addElement((Integer)null, new Entity("Hudinni", 50));
        this.repository.addElement((Integer)null, new Entity("Copperfield", 39));
        this.repository.addElement((Integer)null, new Entity("Phil Dunphy", 5));
    }

    private void assertElementNotFound(int id) {
        Optional<Entity> removedElement = this.repository.findElement(id);
        Assertions.assertThat(removedElement.isPresent()).isFalse();
    }

    private void assertElementsEqual(Entity expectedElement, Optional<Entity> gottenElement) {
        Assertions.assertThat(gottenElement).isPresent();
        Assertions.assertThat(gottenElement).get().isEqualTo(expectedElement);
    }

    @Test
    public void testInvalidRemoval() {
        ((AbstractThrowableAssert)Assertions.assertThatThrownBy(() -> {
            this.repository.removeElement(100);
        }).isInstanceOf(IllegalArgumentException.class)).hasMessageContaining("Element with this id isn't in repository");
    }

    @Test
    public void testValidRemoval() {
        this.repository.removeElement(2);
        this.assertElementNotFound(2);
    }

    @Test
    public void testNotFoundElement() {
        this.assertElementNotFound(100);
    }

    @Test
    public void testElementFound() {
        Optional<Entity> foundElement = this.repository.findElement(2);
        Entity expectedElement = new Entity("Copperfield", 39);
        this.assertElementsEqual(expectedElement, foundElement);
    }

    @Test
    public void testValidAddingElementNull() {
        Entity addedEntity = new Entity("Gandalf", 99);
        this.repository.addElement((Integer)null, addedEntity);
        Optional<Entity> foundElement = this.repository.findElement(4);
        this.assertElementsEqual(addedEntity, foundElement);
    }

    @Test
    public void testValidAddingElementWithKey() {
        Entity addedEntity = new Entity("Gandalf", 99);
        this.repository.addElement(100, addedEntity);
        Optional<Entity> foundElement = this.repository.findElement(100);
        this.assertElementsEqual(addedEntity, foundElement);
    }

    @Test
    public void testInvalidAddingElement() {
        Entity addedEntity = new Entity("Gandalf", 99);
        ((AbstractThrowableAssert)Assertions.assertThatThrownBy(() -> {
            this.repository.addElement(3, addedEntity);
        }).isInstanceOf(IllegalArgumentException.class)).hasMessageContaining("Element with this id is already in repository");
    }
}
