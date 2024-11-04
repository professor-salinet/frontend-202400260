// importação de todos os componentes da biblioteca gráfica javax, do módulo swing
import javax.swing.*;

// declaração da classe
public class GridBagDemo 
// início do bloco de código da classe
{
    // declaração do método executor principal
    public static void main(String[] args) 
    // início do bloco de código do método
    {
        // declaração da variável para inicialização do construtor da classe GridBagFrame
        GridBagFrame gridBagFrame = new GridBagFrame();
        // definição da operação padrão de fechamento: sair ao fechar
        gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // definição do tamanho da tela
        gridBagFrame.setSize(300, 150);
        // definição da visualização da janela (frame)
        gridBagFrame.setVisible(true);
    // fim do bloco de código do método
    }
// fim do bloco de código da classe
}