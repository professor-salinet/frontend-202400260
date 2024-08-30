import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame 
{
   private final JList<String> colorJList;
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"};
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};

   private final JList<String> sizeJList;
   private static final String[] sizeNames = {"Small", "Medium", "Big"};

   public ListFrame()
   {
      super("List Test");
      setLayout(new FlowLayout()); 

      colorJList = new JList<String>(colorNames);
      colorJList.setVisibleRowCount(5);
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      add(new JScrollPane(colorJList));

      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(5);
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      add(new JScrollPane(sizeJList));

      colorJList.addListSelectionListener(
         new ListSelectionListener()
         {   
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      ); 

      sizeJList.addListSelectionListener(
         new ListSelectionListener()
         {   
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                     setSize(350, 150);
                     break;

                  case 1:
                     setSize(550, 350);
                     break;

                  case 2:
                     setSize(750, 550);
                     break;

                  default:
                     setSize(350, 150);
                     break;
               }
            } 
         } 
      ); 

      setSize(350, 150); 
      setVisible(true);

   } 
}