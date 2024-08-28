import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonFrame extends JFrame
{
    private JTextField textField;

    private Font plainFont;
    private Font boldFont;
    private Font italicFont;
    private Font boldItalicFont;

    private Color blueColor;
    private Color redColor;
    private Color yellowColor;
    private Color blackColor;

    private JRadioButton plainJRadioButton;
    private JRadioButton boldJRadioButton;
    private JRadioButton italicJRadioButton;
    private JRadioButton boldItalicJRadioButton;
    private ButtonGroup radioGroup;

    private JRadioButton blueJRadioButton;
    private JRadioButton redJRadioButton;
    private JRadioButton yellowJRadioButton;
    private JRadioButton blackJRadioButton;
    private ButtonGroup colorRadioGroup;

    public RadioButtonFrame()
    {
        super("RadioButton Test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 25);
        add(textField);

        plainJRadioButton = new JRadioButton("Plain", true);
        boldJRadioButton = new JRadioButton("Bold", false);
        italicJRadioButton = new JRadioButton("Italic", false);
        boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
        add(plainJRadioButton);
        add(boldJRadioButton);
        add(italicJRadioButton);
        add(boldItalicJRadioButton);

        radioGroup = new ButtonGroup();
        radioGroup.add(plainJRadioButton);
        radioGroup.add(boldJRadioButton);
        radioGroup.add(italicJRadioButton);
        radioGroup.add(boldItalicJRadioButton);

        blueJRadioButton = new JRadioButton("Blue", false);
        redJRadioButton = new JRadioButton("Red", false);
        yellowJRadioButton = new JRadioButton("Yellow", false);
        blackJRadioButton = new JRadioButton("Black", true);
        add(blueJRadioButton);
        add(redJRadioButton);
        add(yellowJRadioButton);
        add(blackJRadioButton);

        colorRadioGroup = new ButtonGroup();
        colorRadioGroup.add(blueJRadioButton);
        colorRadioGroup.add(redJRadioButton);
        colorRadioGroup.add(yellowJRadioButton);
        colorRadioGroup.add(blackJRadioButton);

        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        textField.setFont(plainFont);

        blueColor = new Color(0, 0, 255);
        redColor = new Color(255, 0, 0);
        yellowColor = new Color(255, 255, 0);
        blackColor = new Color(0, 0, 0);

        plainJRadioButton.addItemListener(
                new RadioButtonHandler(plainFont));
        boldJRadioButton.addItemListener(
                new RadioButtonHandler(boldFont));
        italicJRadioButton.addItemListener(
                new RadioButtonHandler(italicFont));
        boldItalicJRadioButton.addItemListener(
                new RadioButtonHandler(boldItalicFont));

        blueJRadioButton.addItemListener(
                new ColorRadioButtonHandler(blueColor));
        redJRadioButton.addItemListener(
                new ColorRadioButtonHandler(redColor));
        yellowJRadioButton.addItemListener(
                new ColorRadioButtonHandler(yellowColor));
        blackJRadioButton.addItemListener(
                new ColorRadioButtonHandler(blackColor));
    }

    private class RadioButtonHandler implements ItemListener
    {
        private Font font;

        public RadioButtonHandler(Font f) {
            font = f;
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setFont(font);
        }
    }

    private class ColorRadioButtonHandler implements ItemListener
    {
        private Color color;

        public ColorRadioButtonHandler(Color c) {
            color = c;
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setForeground(color);
        }
    }
}