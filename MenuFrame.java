import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.font.*;

import javax.swing.*;

public class MenuFrame extends JFrame 
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};   
   private final JRadioButtonMenuItem[] colorItems;
   private final JRadioButtonMenuItem[] fonts;
   private final JRadioButtonMenuItem[] tamanhos;
   private final JCheckBoxMenuItem[] styleItems;
   private final JLabel displayJLabel;
   private final ButtonGroup fontButtonGroup;
   private final ButtonGroup colorButtonGroup;
   private final ButtonGroup tamanhoButtonGroup;
   private int style;
   private int tamanhoAtual = 72;

   public MenuFrame()
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F');

      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A');
      fileMenu.add(aboutItem);
      aboutItem.addActionListener(
         new ActionListener()
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\\n\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x');
      fileMenu.add(exitItem);
      exitItem.addActionListener(
         new ActionListener()
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      bar.add(fileMenu);

      JMenu formatMenu = new JMenu("Format");
      formatMenu.setMnemonic('r');

      String[] colors = {"Black", "Blue", "Red", "Green", "Yellow"};

      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C');

      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup();
      ItemHandler itemHandler = new ItemHandler();

      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]);
         colorMenu.add(colorItems[count]);
         colorButtonGroup.add(colorItems[count]);
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true);

      formatMenu.add(colorMenu);
      formatMenu.addSeparator();

      String[] fontNames = {"Serif", "Monospaced", "SansSerif", "Arial"};
      // GraphicsEnvironment local_env; 
      // local_env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//Get available font names
		// String allfonts[] = local_env.getAvailableFontFamilyNames();
      // String[] fontNames = local_env.getAvailableFontFamilyNames();
      // String[] fontItems = local_env.getAvailableFontFamilyNames();
      JMenu fontMenu = new JMenu("Font");
      fontMenu.setMnemonic('n');

      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup();

      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]);
         fontButtonGroup.add(fonts[count]);
         fonts[count].addActionListener(itemHandler);
      } 

      fonts[0].setSelected(true);
      fontMenu.addSeparator();

      String[] styleNames = {"Bold", "Italic", "Underline"};
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler();

      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]);
         fontMenu.add(styleItems[count]);
         styleItems[count].addItemListener(styleHandler);
      }

      formatMenu.add(fontMenu);
      // menuOne.add(new JMenuItem("1") {
   //       @Override
   //       public Dimension getPreferredSize() {
   //           Dimension d = super.getPreferredSize();
   //           d.width = Math.max(d.width, 400); // set minimums
   //           d.height = Math.max(d.height, 300);
   //           return d;
   //       }
   //   });
      bar.add(formatMenu);
     
      formatMenu.addSeparator();

      int[] tamanhoint = {72, 52, 22}; 
      JMenu tamanhoMenu = new JMenu("Tamanho"); 
      tamanhoMenu.setMnemonic('T'); 

      tamanhos = new JRadioButtonMenuItem[tamanhoint.length]; 
      tamanhoButtonGroup = new ButtonGroup(); 


      for (int count = 0; count < tamanhos.length; count++) 
      {
         tamanhos[count] = new JRadioButtonMenuItem(String.valueOf(tamanhoint[count])); 
         tamanhoMenu.add(tamanhos[count]); 
         tamanhoButtonGroup.add(tamanhos[count]); 
         tamanhos[count].addActionListener(itemHandler); 
      }

      tamanhos[0].setSelected(true);
      formatMenu.add(tamanhoMenu);

      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, tamanhoAtual));

      getContentPane().setBackground(Color.CYAN);
      add(displayJLabel, BorderLayout.CENTER);
   }

   private class ItemHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, tamanhoAtual));
            }
         }

         negritoItalico();
         sublinharTexto();
         tamanhoTexto();
         repaint();
      } 
   }

   private class StyleHandler implements ItemListener 
   {
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         negritoItalico();
         sublinharTexto();
         tamanhoTexto();
         repaint();
      }
   }

   public void negritoItalico() {
      String name = displayJLabel.getFont().getName();
      Font font;

      if (styleItems[0].isSelected() && 
           styleItems[1].isSelected())
         font = new Font(name, Font.BOLD + Font.ITALIC, tamanhoAtual);
      else if (styleItems[0].isSelected())
         font = new Font(name, Font.BOLD, tamanhoAtual);
      else if (styleItems[1].isSelected())
         font = new Font(name, Font.ITALIC, tamanhoAtual);
      else
         font = new Font(name, Font.PLAIN, tamanhoAtual);

      displayJLabel.setFont(font);
   }

   public void sublinharTexto() {
      // Font font;
      if (styleItems[2].isSelected()) {
         displayJLabel.setText("<html><u>" + displayJLabel.getText() + "</u></html>");
      //    font = displayJLabel.getFont();
      //    Map attributes = font.getAttributes();
      //    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
      //    displayJLabel.setFont(font.deriveFont(attributes));
      //    font = new Font(attributes);
      }
   }

   public void tamanhoTexto() {
      for (int count = 0; count < tamanhos.length; count++) 
      {
         if (tamanhos[count].isSelected())
         {
            int size = Integer.parseInt(tamanhos[count].getText());
            displayJLabel.setFont(displayJLabel.getFont().deriveFont((float) size));
            tamanhoAtual = size;
         }
      }
   }
}
