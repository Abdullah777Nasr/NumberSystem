package numbersystem;

import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberSystem extends JFrame implements ActionListener {

    private JTextField tf;
    private JComboBox com;
    private JPanel pan;
    private JButton buttons[];
    private Font font;
    private Decimal decimal;
    private Binary binary;
    private Octal octal;
    private Hexadecimal hex;
    private long x;
    private final String number[] = {"Decimal To Decimal", "Decimal To Binary", "Decimal To Octal", "Decimal To Hexadecimal",
        "Binary To Binary", "Binary To Decimal", "Binary To Octal", "Binary To Hexadecimal",
        "Octal To Octal", "Octal To Decimal", "Octal To Binary", "Octal To Hexadecimal",
        "Hexadecimal To Hexadecimal", "Hexadecimal To Decimal", "Hexadecimal To Binary", "Hexadecimal To Octal", "Add", "Sub"};
    private String num;
    public NumberSystem() {
        uniUI();
        addIcon();
        UI();
        num = "";
        x = 0;
    }

    private void uniUI() {
        tf = new JTextField();
        buttons = new JButton[20];
        com = new JComboBox(number);
        com.setSelectedIndex(-1);
        com.setToolTipText("Type of converted");
        font = new Font("Tahoma", BOLD, 20);
        buttons[16] = new JButton(".");
        buttons[17] = new JButton("=");
        buttons[18] = new JButton("DEL");
        buttons[19] = new JButton("AC");
        char ch = 'A';
        for (int i = 0; i < 20; i++) {
            if (i >= 10 && i <= 15) {
                buttons[i] = new JButton("" + ch);
                ch++;
            } else if (i > -1 && i < 10) {
                buttons[i] = new JButton("" + i);
            }
            buttons[i].setFont(font);
        }
        decimal = new Decimal();
        binary = new Binary();
        octal = new Octal();
        hex = new Hexadecimal();
    }

    private void addIcon() {
        pan = new JPanel();
        add(pan);
        add(tf);
        add(com);
        for (byte i = 1; i < 10; i++) {
            pan.add(buttons[i]);
        }
        pan.add(buttons[16]);
        pan.add(buttons[0]);
        pan.add(buttons[17]);
        for (byte i = 10; i < 16; i++) {
            pan.add(buttons[i]);
        }
        add(buttons[18]);
        add(buttons[19]);
    }

    private void UI() {
        setTitle("Number System");
        setSize(220, 400);
        setResizable(false);
        URL url = getClass().getResource("/image/system.png");
        ImageIcon icon = new ImageIcon(url);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        tf.setFont(font);
        com.setBounds(0, 0, 215, 40);
        tf.setBounds(0, 40, 215, 30);
        pan.setBounds(0, 66, 215, 314);
        buttons[18].setBounds(0, 333, 110, 40);
        buttons[19].setBounds(110, 333, 110, 40);
        pan.setLayout(new GridLayout(7, 3));
        for (byte i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        NumberSystem number = new NumberSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != buttons[17] && e.getSource() != buttons[18] && e.getSource() != buttons[19]) {
            tf.setText(num += e.getActionCommand());
        } else if ("DEL".equals(e.getActionCommand()) && !num.isEmpty()) {
            num = num.substring(0,num.length()-1);
            tf.setText(num);
        } else if ("AC".equals(e.getActionCommand()) && !num.isEmpty()) {
            tf.setText("");
            num = "";
        } else if (e.getSource() == buttons[17] && !"".equals(num)) {
            if (Check.checkNumber(tf.getText()) && (com.getSelectedIndex() != 12 && com.getSelectedIndex() != 13
                    && com.getSelectedIndex() != 14 && com.getSelectedIndex() != 15)) {
                JOptionPane.showMessageDialog(this, "Error Number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (Check.checkBinaryNumber(tf.getText()) && (com.getSelectedIndex() == 4 || com.getSelectedIndex() == 5
                    || com.getSelectedIndex() == 6 || com.getSelectedIndex() == 7)) {
                JOptionPane.showMessageDialog(this, "You must enter 1 or 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (com.getSelectedIndex() < 11) {
                x = Long.valueOf(tf.getText());
            }
            comb();
        }
    }

    private void comb() {
        switch (com.getSelectedIndex()) {
            case 0:
                tf.setText(tf.getText());
                num = tf.getText().trim();
                break;
            case 1:
                tf.setText(decimal.binaryNumber(x));
                num = decimal.binaryNumber(x).trim();
                break;
            case 2:
                tf.setText(decimal.octalNumber(x));
                num = decimal.octalNumber(x).trim();
                break;
            case 3:
                tf.setText(decimal.hexadecimalNumber(x));
                num = decimal.hexadecimalNumber(x).trim();
                break;
            case 4:
                tf.setText(tf.getText());
                num = tf.getText().trim();
                break;
            case 5:
                tf.setText(binary.decimalNumberBin(x));
                num = binary.decimalNumberBin(x).trim();
                break;
            case 6:
                tf.setText(binary.octalNumber(x));
                num = binary.octalNumber(x).trim();
                break;
            case 7:
                tf.setText(binary.hexadecimalNumber(x));
                num = binary.hexadecimalNumber(x).trim();
                break;
            case 8:
                tf.setText(tf.getText());
                num = tf.getText().trim();
                break;
            case 9:
                tf.setText(octal.decimalNumberOct(x));
                num = octal.decimalNumberOct(x).trim();
                break;
            case 10:
                tf.setText(octal.binaryNumber(x));
                num = octal.binaryNumber(x).trim();
                break;
            case 11:
                tf.setText(octal.hexadecimalNumber(x));
                num = octal.hexadecimalNumber(x).trim();
                break;
            case 12:
                tf.setText(tf.getText().trim());
                num = tf.getText().trim();
                break;
            case 13:
                tf.setText(hex.decimalNumberHex(tf.getText()));
                num = hex.decimalNumberHex(tf.getText()).trim();
                break;
            case 14:
                tf.setText(hex.binaryNumber(tf.getText()));
                num = hex.binaryNumber(tf.getText()).trim();
                break;
            case 15:
                tf.setText(hex.octalNumber(tf.getText()));
                num = hex.octalNumber(tf.getText()).trim();
                break;
        }
    }
}
