import javax.swing.JOptionPane; 

public class Addition 
{
   public static void main(String[] args)
   {
      String firstNumber =
         JOptionPane.showInputDialog("Digite o primeiro número");
      String secondNumber =
         JOptionPane.showInputDialog("Digite o segundo número");
      String thirdNumber =
         JOptionPane.showInputDialog("Digite o terceiro número");

      int number1 = Integer.parseInt(firstNumber); 
      int number2 = Integer.parseInt(secondNumber);
      int number3 = Integer.parseInt(thirdNumber);

      int sum = number1 + number2 + number3;

      JOptionPane.showMessageDialog(null, "A soma dos números é: " + sum, 
         "Soma de três inteiros", JOptionPane.PLAIN_MESSAGE);
   } 
}