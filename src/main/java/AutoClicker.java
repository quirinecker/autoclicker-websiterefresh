import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class AutoClicker {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            delay(1);
        }

        while (true) {
            leftClick();
            delay(3700);
        }
    }

    protected static void delay(double seconds) {
        createMacro();
        macro.delay((int)(seconds*1000.0));
    }

    protected static void leftClick() {
        System.out.println("Click");
        createMacro();;
        macro.keyPress(KeyEvent.VK_CONTROL);
        macro.keyPress(KeyEvent.VK_R);
        macro.keyRelease(KeyEvent.VK_R);
        macro.keyRelease(KeyEvent.VK_CONTROL);
        delay(5);
        macro.mousePress(MouseEvent.BUTTON1_MASK);
        macro.mouseRelease(MouseEvent.BUTTON1_MASK);
    }

    private static Robot macro = null;

    private static void createMacro() {
        try {
            macro = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
