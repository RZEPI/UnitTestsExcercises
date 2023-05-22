public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        Controller controller = new Controller(repository);
        controller.addElement(1,"Gandalf", 99);
        System.out.println(controller.findElement(1));
    }
}
