//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ControllerTests {
    private Controller controller;
    private Repository repository;

    public ControllerTests() {
    }

    @BeforeEach
    public void initController() {
        this.repository = (Repository)Mockito.mock(Repository.class);
        this.controller = new Controller(this.repository);
    }

    @Test
    public void testValidRemoveElement() {
        ((Repository)Mockito.doNothing().when(this.repository)).removeElement(2);
        Assertions.assertThat(this.controller.removeElement(2)).isEqualTo("done");
    }

    @Test
    public void testInvalidRemoveElement() {
        ((Repository)Mockito.doThrow(new Throwable[]{new IllegalArgumentException("Element with this id isn't in repository")}).when(this.repository)).removeElement(100);
        Assertions.assertThat(this.controller.removeElement(100)).isEqualTo("not found");
    }

    @Test
    public void testValidAddingElementNull() {
        Entity addedElement = new Entity("Gandalf", 99);
        ((Repository)Mockito.doNothing().when(this.repository)).addElement((Integer)null, addedElement);
        Assertions.assertThat(this.controller.addElement((Integer)null, "Gandalf",99)).isEqualTo("done");
    }

    @Test
    public void testValidAddingElementKey() {
        Entity addedElement = new Entity("Gandalf", 99);
        ((Repository)Mockito.doNothing().when(this.repository)).addElement(2, addedElement);
        Assertions.assertThat(this.controller.addElement(2, "Gandalf", 99)).isEqualTo("done");
    }

    @Test
    public void testInvalidAddingElement() {
        Entity addedElement = new Entity("Gandalf", 99);
        ((Repository)Mockito.doThrow(new Throwable[]{new IllegalArgumentException("Element with this id is already in repository")}).when(this.repository)).addElement(2, addedElement);
        Assertions.assertThat(this.controller.addElement(2, "Gandalf", 99)).isEqualTo("bad request");
    }

    @Test
    public void testValidElementSearch() {
        Entity foundEntityElement = new Entity("Gandalf", 99);
        Optional<Entity> foundElement = Optional.of(foundEntityElement);
        Mockito.when(this.repository.findElement(2)).thenReturn(foundElement);
        Assertions.assertThat(this.controller.findElement(2)).isEqualTo(foundEntityElement.toString());
    }

    @Test
    public void testInvalidElementSearch() {
        Optional<Entity> foundElement = Optional.empty();
        Mockito.when(this.repository.findElement(2)).thenReturn(foundElement);
        Assertions.assertThat(this.controller.findElement(2)).isEqualTo("not found");
    }
}
