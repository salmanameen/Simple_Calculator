import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Main extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField textField;
    String s0, s1, s2;

    Main() {
        s0 = s1 = s2 = "";
    }

    public static void main(String[] args) {
        // create a frame
        f = new JFrame("Calculator");

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // creating a calculator object
        Main calculator = new Main();

        // creating a textField
        textField = new JTextField(16);

        // set textField to non-editable
        textField.setEditable(false);

        // creating buttons
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        beq1 = new JButton("=");

        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");

        // create clear button
        beq = new JButton("C");

        // create decimal button
        be = new JButton(".");

        // create panel
        JPanel p = new JPanel();

        // add action listeners
        bm.addActionListener(calculator);
        bs.addActionListener(calculator);
        ba.addActionListener(calculator);
        bd.addActionListener(calculator);
        be.addActionListener(calculator);
        beq.addActionListener(calculator);
        beq1.addActionListener(calculator);
        b0.addActionListener(calculator);
        b1.addActionListener(calculator);
        b2.addActionListener(calculator);
        b3.addActionListener(calculator);
        b4.addActionListener(calculator);
        b5.addActionListener(calculator);
        b6.addActionListener(calculator);
        b7.addActionListener(calculator);
        b8.addActionListener(calculator);
        b9.addActionListener(calculator);

        // add elements to panel
        p.add(textField);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(ba);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bs);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bm);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(bd);
        p.add(beq1);

        // set background of panel
        p.setBackground(Color.BLUE);

        // add panel to frame
        f.add(p);
        f.setSize(200, 220);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // if the value is a number or a decimal point
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals("")) {
                s2 = s2 + s;
            } else {
                s0 = s0 + s;
            }
            textField.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            // clear the textField
            s0 = s1 = s2 = "";
            textField.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {
            // store the value in 1st
            double result;

            if (s1.equals("+")) {
                result = (Double.parseDouble(s0) + Double.parseDouble(s2));
            } else if (s1.equals("-")) {
                result = (Double.parseDouble(s0) - Double.parseDouble(s2));
            } else if (s1.equals("/")) {
                result = (Double.parseDouble(s0) / Double.parseDouble(s2));
            } else {
                result = (Double.parseDouble(s0) * Double.parseDouble(s2));
            }

            // set the value of text
            textField.setText(s0 + s1 + s2 + "=" + result);

            // convert it to string
            s0 = Double.toString(result);

            // place the operator
            s1 = s2 = "";
        } else {
            // if there was no operand
            if (s1.equals("") || s2.equals("")) {
                s1 = s;
            } else {
                double result;

                if (s1.equals("+")) {
                    result = (Double.parseDouble(s0) + Double.parseDouble(s2));
                } else if (s1.equals("-")) {
                    result = (Double.parseDouble(s0) - Double.parseDouble(s2));
                } else if (s1.equals("/")) {
                    result = (Double.parseDouble(s0) / Double.parseDouble(s2));
                } else {
                    result = (Double.parseDouble(s0) * Double.parseDouble(s2));
                }

                // convert it to string
                s0 = Double.toString(result);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            textField.setText(s0 + s1 + s2);
        }
    }
}
