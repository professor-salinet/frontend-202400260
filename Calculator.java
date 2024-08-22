import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Calculator extends JFrame {
    private final JTextField textField1;
    private final JTextField textField2;

    private final JLabel label1;
    private final JLabel label2;

    private final JButton btnCalcular;
    private final JLabel lblNotificacao;

    private final String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};
 
    public Calculator()
    {
        super("Calculadora de soma");
        setLayout(new GridLayout(3,2,5,5)); // (3,2,5,5)

        label1 = new JLabel("Digite o número 1:", SwingConstants.RIGHT);
        add(label1);
        textField1 = new JTextField(10); 
        add(textField1);

        label2 = new JLabel("Digite o número 2:", SwingConstants.RIGHT);
        add(label2);
        textField2 = new JTextField(10);
        add(textField2);

        btnCalcular = new JButton("Calcular");
        add(btnCalcular);
        lblNotificacao = new JLabel("Resultado: ?");
        add(lblNotificacao);

        TextFieldHandler handler = new TextFieldHandler();
        btnCalcular.addActionListener(handler);
    }

    private class TextFieldHandler implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (textField1.getText().trim().length() == 0) {
                // notificar usuário que o campo 1 está vazio
                lblNotificacao.setText("O campo 1 está vazio!");
                textField1.requestFocus();
            } else {
                if (textField2.getText().trim().length() == 0) {
                    // notificar usuário que o campo 2 está vazio
                    lblNotificacao.setText("O campo 2 está vazio!");
                    textField2.requestFocus();
                } else {
                    // aqui será feita a soma
                    try {
                        textField1.setText(somenteNumeros(textField1.getText()));
                        textField2.setText(somenteNumeros(textField2.getText()));
                        int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
                        lblNotificacao.setText(String.format("Resultado: %s", soma));
                    } catch (Exception e) {
                        lblNotificacao.setText("<html><body>Ops! Parece que foi digitado alguma coisa errada, favor revisar a digitação, pois podem ser digitados apenas números inteiros.</body></html>");
                    }
                }
            }
        }

        public String somenteNumeros(String strTexto) {
            boolean achouNumero;
            ArrayList<String> caracteresEncontrados = new ArrayList<String>();
            for (int c = 0; c < strTexto.length(); c++) {
                String caracterTemp = strTexto.substring(c,c+1);
                achouNumero = false;
                for (int n = 0; n < numeros.length; n++) {
                    if (caracterTemp.equals(numeros[n])) {
                        achouNumero = true;
                        break;
                    }
                }
                if (achouNumero) {
                    continue;
                } else {
                    caracteresEncontrados.add(caracterTemp);
                }
            }
            for (int c = 0; c < caracteresEncontrados.size(); c++) {
                strTexto = strTexto.replace(caracteresEncontrados.get(c), "");
            }
            return strTexto;
        }
    }
    public static void main(String[] args)
    { 
        Calculator calculator = new Calculator(); 
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(450, 400); 
        calculator.setVisible(true); 
    } 
}
