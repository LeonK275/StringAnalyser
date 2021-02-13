// STRING ANALYSER, VERSION 1.0
//12.02.2021 17:31 MEZ

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

public class Main{

    private static JPanel panel = new JPanel(null);
    private static JButton buttonAnalyse = new JButton("Analyse");
    private static JTextArea textField = new JTextArea();
    private static JTextArea textAreaParam = new JTextArea();
    private static JTextArea textAreaParam2 = new JTextArea();
    private static JTextArea label = new JTextArea("EMPTY");
    static Clipboard copy = Toolkit.getDefaultToolkit().getSystemClipboard();
    static JButton buttonCopyLabel = new JButton("Copy Output");
    static JButton buttonClear = new JButton("Clear All");
    static JButton buttonPasteTextField = new JButton("Paste Input");
    private static JButton buttonCopyTextField = new JButton("Copy Input");
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    private static JRadioButton RBtoLowerCase = new JRadioButton("To Lower Case");
    private static JRadioButton RBtoUpperCase = new JRadioButton("To Upper Case");
    private static JRadioButton RBlengh = new JRadioButton("Lengh");
    private static JRadioButton RBtrim = new JRadioButton("Trim");
    private static JRadioButton RBcontains = new JRadioButton("Contains?");
    private static JRadioButton RBreplace = new JRadioButton("Replace");
    private static JRadioButton RBsubstring = new JRadioButton("Substring");
    private static JRadioButton RBanalysechar = new JRadioButton("Analyse Chars");
    private static JRadioButton RBanalyseLetter = new JRadioButton("Analyse Letters");
    private static JRadioButton RBanalyseDigits = new JRadioButton("Analyse Digits");
    private static JRadioButton RBmakeHash = new JRadioButton("Make Hash");
    private static JRadioButton RBdecryptHash = new JRadioButton("Decrypt Hash");
    private static JRadioButton RBlightmode = new JRadioButton("Light Mode");
    private static JRadioButton RBdarkmode = new JRadioButton("Dark Mode");

    private static JCheckBox CBquotationmarks = new JCheckBox("Set quotation marks");
    static ButtonGroup buttonGroup = new ButtonGroup();
    static ButtonGroup buttonGroupLightDark = new ButtonGroup();
    static GroupLayout layout = new GroupLayout(panel);

    static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static int[] alphabetInt = new int[26];

    static char[] digits = "123456789".toCharArray();
    static int[] digitsInt = new int[9];

    static ImageIcon icon = new ImageIcon("U:\\SpringBootTest\\StringAnalyser\\img\\Icon.PNG");

    static Color defColor = panel.getBackground();


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("String Analyser");
        //frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        frame.setSize(1000,560);

        frame.setIconImage(icon.getImage());
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        textField.setWrapStyleWord(true);
        textField.setLineWrap(true);
        textAreaParam.setWrapStyleWord(true);
        textAreaParam.setLineWrap(true);
        textAreaParam2.setWrapStyleWord(true);
        textAreaParam2.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setLineWrap(true);
        label.setEditable(false);
        buttonAnalyse.setBackground(Color.MAGENTA);
        CBquotationmarks.setFont(CBquotationmarks.getFont().deriveFont(10.0f));
        //panel.setBackground(Color.GRAY);
        //RBanalysechar.setOpaque(false);
        //RBanalysechar.setFont(new Font("Monaco", Font.PLAIN,15));
        RBlightmode.setSelected(true);
        frame.setResizable(false);

        buttonCopyLabel.setBackground(Color.GREEN);
        buttonClear.setBackground(Color.CYAN);
        buttonCopyTextField.setBackground(Color.RED);
        buttonPasteTextField.setBackground(Color.ORANGE);

        RBlightmode.setOpaque(false);
        opaq(false);


        // LAYOUT
        buttonAnalyse.setBounds(10,10,130,50);
        textField.setBounds(150,10,400,290);
        textAreaParam.setBounds(150,310,195,150);
        textAreaParam2.setBounds(355,310,195,150);
        label.setBounds(570,10,400,450);
        CBquotationmarks.setBounds(10,435,130,20);
        buttonCopyLabel.setBounds(700,470,120,40);
        buttonClear.setBounds(190,470,120,20);
        buttonPasteTextField.setBounds(390,470,120,20);
        buttonCopyTextField.setBounds(390,495,120,20);
        // RADIO BUTTON LAYOUT
        RBlengh.setBounds(10,70,130,20);
        RBtoUpperCase.setBounds(10,100,130,20);
        RBtoLowerCase.setBounds(10,130,130,20);
        RBtrim.setBounds(10,160,130,20);
        RBcontains.setBounds(10,190,130,20);
        RBreplace.setBounds(10,220,130,20);
        RBsubstring.setBounds(10,250,130,20);
        RBanalysechar.setBounds(10,280,130,20);
        RBanalyseLetter.setBounds(10,310,130,20);
        RBanalyseDigits.setBounds(10,340,130,20);
        RBmakeHash.setBounds(10,370,130,20);
        RBdecryptHash.setBounds(10,400,130,20);
        RBlightmode.setBounds(10,470,130,20);
        RBdarkmode.setBounds(10,495,130,20);

        //PANEL ADD
        panel.add(buttonAnalyse);
        panel.add(textField);
        panel.add(textAreaParam);
        panel.add(textAreaParam2);
        panel.add(label);
        panel.add(CBquotationmarks);
        panel.add(RBlengh);
        panel.add(RBtoUpperCase);
        panel.add(RBtoLowerCase);
        panel.add(RBtrim);
        panel.add(RBcontains);
        panel.add(RBreplace);
        panel.add(RBsubstring);
        panel.add(RBanalysechar);
        panel.add(buttonCopyLabel);
        panel.add(RBanalyseLetter);
        panel.add(RBanalyseDigits);
        panel.add(RBmakeHash);
        panel.add(RBdecryptHash);
        panel.add(buttonClear);
        panel.add(buttonPasteTextField);
        panel.add(buttonCopyTextField);
        panel.add(RBlightmode);
        panel.add(RBdarkmode);

        //Progress Bar einfügen!!!!!  https://stackoverflow.com/questions/8916064/how-to-add-a-progress-bar
        //BUTTON GROUP RADIO BUTTONS
        buttonGroup.add(RBlengh);
        buttonGroup.add(RBtoUpperCase);
        buttonGroup.add(RBtoLowerCase);
        buttonGroup.add(RBtrim);
        buttonGroup.add(RBcontains);
        buttonGroup.add(RBreplace);
        buttonGroup.add(RBsubstring);
        buttonGroup.add(RBanalysechar);
        buttonGroup.add(RBanalyseLetter);
        buttonGroup.add(RBanalyseDigits);
        buttonGroup.add(RBmakeHash);
        buttonGroup.add(RBdecryptHash);

        buttonGroupLightDark.add(RBlightmode);
        buttonGroupLightDark.add(RBdarkmode);

        //ACTION LISTENERS
        ActionListener actionListenerServices = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonCopyLabel.getModel().isArmed()) {
                    StringSelection stringSelection = new StringSelection(label.getText());
                    copy.setContents(stringSelection, null);
                }
                if(buttonClear.getModel().isArmed()) {
                    textField.setText(null);
                    textAreaParam.setText(null);
                    textAreaParam2.setText(null);
                    label.setText(null);
                }
                if(buttonPasteTextField.getModel().isArmed()) {
                    textField.setText(null);
                    textField.paste();
                }
                if(buttonCopyTextField.getModel().isArmed()){
                    StringSelection stringSelection = new StringSelection(textField.getText());
                    copy.setContents(stringSelection, null);

                }
                if(RBdarkmode.getModel().isArmed()) {
                    setDarkmode();
                }
                if(RBlightmode.getModel().isArmed()) {
                    setLightmode();
                }
            }
        };

        ActionListener actionListenerWizard = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tap1 = textAreaParam.getText().trim();
                String tap2 = textAreaParam2.getText().trim();
                String string = textField.getText().trim();

                if(RBtoLowerCase.isSelected()) {

                    label.setText(string.toLowerCase());

                }
                if(RBtoUpperCase.isSelected()) {

                    label.setText(string.toUpperCase());

                }
                if(RBlengh.isSelected()) {

                    Integer length = string.length();
                    label.setText(length.toString());

                }
                if(RBtrim.isSelected()) {

                    label.setText(string.trim());

                }
                if(RBcontains.isSelected()) {

                    try {
                        Boolean contains = string.contains(tap1);
                        label.setText(contains.toString());
                    }
                    catch (Exception t) {
                        label.setText("ERROR 4: CONTAINS.OBJECT ERROR");
                    }

                }
                if(RBreplace.isSelected()) {

                    label.setText(string.replace(tap1,tap2));
                }
                if(RBsubstring.isSelected()) {
                    try {
                        if (tap2.equals("")) {
                            label.setText(string.substring(Integer.parseInt(tap1)));
                        } else {
                            label.setText(string.substring(Integer.parseInt(tap1), Integer.parseInt(tap2) + 1));
                        }
                    }
                    catch (Exception r) {
                        label.setText("ERROR 5: SUBSTRING ERROR");
                    }

                }
                if(RBanalysechar.isSelected()) {
                    label.setText(analyseChars(string));
                }
                if(RBanalyseLetter.isSelected()) {
                    label.setText(letterTypeCount(textField.getText().toUpperCase().toCharArray()));
                }
                if(RBanalyseDigits.isSelected()) {
                    label.setText(digitsTypeCount(textField.getText().toCharArray()));
                }
                if(RBmakeHash.isSelected()) {
                        label.setText(makeHash(string));
                }
                if(RBdecryptHash.isSelected()) {
                        label.setText(decryptHash(string));
                }
                if(CBquotationmarks.isSelected()) {
                    String qm = label.getText();
                    label.setText("\"" + qm + "\"");
                }

            }
        };

        //ACTION LISTENER ZUWEISUNG
        buttonAnalyse.addActionListener(actionListenerWizard);
        buttonCopyLabel.addActionListener(actionListenerServices);
        buttonClear.addActionListener(actionListenerServices);
        buttonPasteTextField.addActionListener(actionListenerServices);
        buttonCopyTextField.addActionListener(actionListenerServices);
        RBlightmode.addActionListener(actionListenerServices);
        RBdarkmode.addActionListener(actionListenerServices);

    }

    private static String analyseChars(String text) {
        char[] chars = text.toCharArray();

        int letters = 0;
        int spaces = 0;
        int digit = 0;
        int other = 0;

        for (int i = chars.length - 1; i > -1; i--) {

            if (Character.isLetter(chars[i])) {
                letters++;
            }
            else if (Character.isSpaceChar(chars[i])) {
                spaces++;
            }
            else if (Character.isDigit(chars[i])) {
                digit++;
            }
            else {
                other++;
            }
        }

        return ("Letters: " + letters + "\nSpaces: " + spaces + "\nDigits: " + digit + "\nOther: " + other);
    }

    private static String letterTypeCount(char[] characters) {

        Boolean emptyy = true;

        String s = "";

        for(int i = 0; i < characters.length; i++) {

            for(int f = 0; f < alphabet.length; f++) {
                if(alphabet[f] == characters[i]) {
                    alphabetInt[f]++;

                }

            }
        }

        for(int f = 0; f < alphabetInt.length; f++) {
            if(alphabetInt[f] > 0) {
                s = s + (alphabet[f] + ": " + alphabetInt[f] + "\n");
                emptyy = false;
            }
            else {
                continue;
            }
            alphabetInt[f] = 0;



        }

        if(emptyy) {
            return "LEER";
        }

        return s;
    }

    private static String digitsTypeCount(char[] numbers) {

        Boolean emptyy = true;

        String s = "";

        for(int i = 0; i < numbers.length; i++) {

            for(int f = 0; f < digits.length; f++) {
                if(digits[f] == numbers[i]) {
                    digitsInt[f]++;

                }
            }
        }

        for(int f = 0; f < digitsInt.length; f++) {

            if(digitsInt[f] > 0) {
                s = s + (digits[f] + ": " + digitsInt[f] + "\n");
                digitsInt[f] = 0;
                emptyy = false;
            }
            else {
                continue;
            }

        }

        if(emptyy) {
            return "LEER";
        }

        return s;
    }

    public static String makeHash(String word) {

        byte[] bytewert = word.getBytes(StandardCharsets.UTF_16);

        for(int i = 0; i < bytewert.length; i++) {
            if(i % 2 == 0) {
                bytewert[i] = (byte) (bytewert[i] + 132);
            }
            else {
                bytewert[i] = (byte) (bytewert[i] + 127);
            }

        }

        return new String(bytewert, StandardCharsets.UTF_16);

    }

    public static String decryptHash(String hashwert) {
        byte[] decryptedHash = hashwert.getBytes(StandardCharsets.UTF_16);

        for(int i = 0; i < decryptedHash.length; i++) {
            if (i % 2 == 0) {
                decryptedHash[i] = (byte) (decryptedHash[i] - 132);
            }
            else {
                decryptedHash[i] = (byte) (decryptedHash[i] - 127);
            }

        }

        return new String(decryptedHash, StandardCharsets.UTF_16).substring(2);

    }

    public static void setLightmode() {

        Color fontColor = Color.BLACK;
        Color textAreaColor = Color.WHITE;

        panel.setBackground(defColor);

        textField.setBackground(textAreaColor);
        textAreaParam.setBackground(textAreaColor);
        textAreaParam2.setBackground(textAreaColor);
        label.setBackground(textAreaColor);

        RBlengh.setForeground(fontColor);
        RBtoUpperCase.setForeground(fontColor);
        RBtoLowerCase.setForeground(fontColor);
        RBtrim.setForeground(fontColor);
        RBcontains.setForeground(fontColor);
        RBreplace.setForeground(fontColor);
        RBsubstring.setForeground(fontColor);
        RBanalysechar.setForeground(fontColor);
        RBanalyseLetter.setForeground(fontColor);
        RBanalyseDigits.setForeground(fontColor);
        RBmakeHash.setForeground(fontColor);
        RBdecryptHash.setForeground(fontColor);
        CBquotationmarks.setForeground(fontColor);
        RBlightmode.setForeground(fontColor);
        RBdarkmode.setForeground(fontColor);
    }

    public static void setDarkmode() {
        Color fontColor = Color.WHITE;
        Color textAreaColor = Color.lightGray;

        panel.setBackground(Color.DARK_GRAY);
        textField.setBackground(textAreaColor);
        textAreaParam.setBackground(textAreaColor);
        textAreaParam2.setBackground(textAreaColor);
        label.setBackground(textAreaColor);

        RBlengh.setForeground(fontColor);
        RBtoUpperCase.setForeground(fontColor);
        RBtoLowerCase.setForeground(fontColor);
        RBtrim.setForeground(fontColor);
        RBcontains.setForeground(fontColor);
        RBreplace.setForeground(fontColor);
        RBsubstring.setForeground(fontColor);
        RBanalysechar.setForeground(fontColor);
        RBanalyseLetter.setForeground(fontColor);
        RBanalyseDigits.setForeground(fontColor);
        RBmakeHash.setForeground(fontColor);
        RBdecryptHash.setForeground(fontColor);
        CBquotationmarks.setForeground(fontColor);
        RBlightmode.setForeground(fontColor);
        RBdarkmode.setForeground(fontColor);



    }

    public static void opaq(Boolean f) {

        RBlengh.setOpaque(f);
        RBtoUpperCase.setOpaque(f);
        RBtoLowerCase.setOpaque(f);
        RBtrim.setOpaque(f);
        RBcontains.setOpaque(f);
        RBreplace.setOpaque(f);
        RBsubstring.setOpaque(f);
        RBanalysechar.setOpaque(f);
        RBanalyseLetter.setOpaque(f);
        RBanalyseDigits.setOpaque(f);
        RBmakeHash.setOpaque(f);
        RBdecryptHash.setOpaque(f);
        CBquotationmarks.setOpaque(f);
        RBlightmode.setOpaque(f);
        RBdarkmode.setOpaque(f);

    }


}
