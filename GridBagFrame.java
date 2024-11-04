// importação dos componentes/classes
import java.awt.*;
import javax.swing.*;

// declaração da classe e herança
public class GridBagFrame extends JFrame {

    // declaração da variável de classe do layout
    private final GridBagLayout layout;
    // declaração da variável de classe das restrições / regras do componente
    private final GridBagConstraints constraints;

    // declaração do construtor
    public GridBagFrame() {
        super("GridBagLayout");
        // atribuição/instanciamento do objeto/layout GridBagLayout
        layout = new GridBagLayout();
        // definição do layout, conforme objeto atribuído acima
        setLayout(layout); // set frame layout
        // atribuição/instanciamento do objeto/restrições GridBagConstraints
        constraints = new GridBagConstraints();

        // atribuição/instanciamento dos elementos visuais

        JTextArea textArea1 = new JTextArea("TextArea1", 5, 10);
        JTextArea textArea2 = new JTextArea("TextArea2", 2, 2);

        String[] names = { "Iron", "Steel", "Brass" };
        JComboBox<String> comboBox = new JComboBox<String>(names);

        JTextField textField = new JTextField("TextField");
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // definição da restrição/regra de layout (BOTH = ambas, significa que será "mesclada" em ambas direções, coluna e linha)
        constraints.fill = GridBagConstraints.BOTH;
        /**
         * Adicionamento do elemento visual textArea1 e configurações do mesmo, onde:
         * o primeiro parâmetro é o objeto que será adicionado/renderizado ao frame
         * o segundo parâmetro é a definição de qual linha será renderizado na grade
         * o terceiro parâmetro é a definição de qual coluna será renderizado na grade
         * o quarto parâmetro é o tamanho da largura
         * o quinto parâmetro é o tamanho da altura
         */
        addComponent(textArea1, 0, 0, 1, 3);

        // definição da restrição/regra de layout (HORIZONTAL = lateral, significa que será "mesclada" apenas na direção lateral, coluna)
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(button1, 0, 1, 2, 1);

        addComponent(comboBox, 2, 1, 2, 1);

        // definição do tamanho da largura do próximo elemento gráfico a ser renderizado no frame
        constraints.weightx = 1000;
        // definição do tamanho da altura do próximo elemento gráfico a ser renderizado no frame
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        addComponent(button2, 1, 1, 1, 1);

        constraints.weightx = 0;
        constraints.weighty = 0;
        addComponent(button3, 1, 2, 1, 1);

        addComponent(textField, 3, 0, 2, 1);

        addComponent(textArea2, 3, 2, 1, 1);
    }

    // declaração do método addComponent, de uso exclusivo da classe GridBagFrame, sem retorno, apenas para adicionamento ao frame
    private void addComponent(Component component, int row, int column, int width, int height) {
        // definição da localização vertical do elemento na grade
        constraints.gridy = row;
        // definição da localização horizontal do elemento na grade
        constraints.gridx = column;
        // definição do tamanho da largura do elemento na grade
        constraints.gridwidth = width;
        // definição do tamanho da altura do elemento na grade
        constraints.gridheight = height;
        // definição da restrição/regra do componente/elemento gráfico
        layout.setConstraints(component, constraints);
        // adicionamento do componente já completo e pronto para renderização
        add(component);
    }
}