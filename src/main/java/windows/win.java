package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class win extends JFrame {
    JLabel label1, label2, label3, label4;
    JButton button1, button2, button3;
    JTextField text1, text2;
    float weight, height;
    String answer1, answer2;
    eHandler handler = new eHandler();

    public win(String s) {
        super(s);
        setLayout(new FlowLayout());
        label1 = new JLabel ("Если числа дробные, используйте точку!");
        label2 = new JLabel ("Укажите Ваш вес в килограммах:");
        label3 = new JLabel ("Укажите Ваш рост в метрах:");
        button1 = new JButton ("Рассчитать");
        button2 = new JButton ("Очистить");
        button3 = new JButton ("Закрыть");
        label4 = new JLabel ("");
        text1 = new JTextField (10);
        text2 = new JTextField (10);

        add(label1);
        add(label2);
        add(text1);
        add(label3);
        add(text2);
        add(button1);
        add(button2);
        add(button3);
        add(label4);

        button1.addActionListener(handler);
        button2.addActionListener(handler);
        button3.addActionListener(handler);
    }

    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==button1){
                    imtService service = new imtService();
                    weight = Float.parseFloat(text1.getText());
                    height = Float.parseFloat(text2.getText());
                    int indmt = (int) service.getImt(weight, height);
                    answer1 = ("Ваш индекс массы тела = ") + indmt;
                    answer2 = service.getComm(indmt);
                    label4.setText(answer1 + ". " + answer2);
                }

                if (e.getSource()==button2){
                    text1.setText(null);
                    text2.setText(null);
                    label4.setText("");
                }

                if (e.getSource()==button3){
                    System.exit(0);
                }
            }

            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, new String[] {
                        "Все поля должны быть заполнены!",
                        "Если числа дробные, используйте точку!"
                        },
                        "Будьте внимательнее!",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }
}