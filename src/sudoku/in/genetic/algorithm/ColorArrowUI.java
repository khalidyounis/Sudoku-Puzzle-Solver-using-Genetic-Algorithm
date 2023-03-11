/*

Sudoku Puzzle Solver using Genetic Algorithm
Developed by Group A
University of Liverpool
Master of Computer Science
CSCK502 Reasoning and Intelligent Systems October 2022

MIT License

Copyright (c) 2022 Khalid Younis
Copyright (c) 2022 Jose Roberto Mora Martinez
Copyright (c) 2022 Ghafer Khan

 */
package sudoku.in.genetic.algorithm;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author khalid.kareem
 */
class ColorArrowUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
                    UIManager.put("ComboBox.background", new ColorUIResource(new Color(255, 255, 255)));
                UIManager.put("ComboBox.foreground", new ColorUIResource(Color.black));
                UIManager.put("JTextField.background", new ColorUIResource(new Color(255, 255, 255)));
                UIManager.put("ComboBox.selectionBackground", new ColorUIResource(new Color(15,82,186)));
                UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.WHITE));
                UIManager.put("ComboBox.border", new LineBorder(new Color(240,168,59)));
                UIManager.put("ComboBox.control", Color.white);
                UIManager.put("ComboBox.controlForeground", Color.GRAY);
                UIManager.put("ComboBox.buttonBackground", Color.white);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColorArrowUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ColorArrowUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ColorArrowUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ColorArrowUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ColorArrowUI();
    }

    @Override
    protected JButton createArrowButton() {
        
        return new BasicArrowButton(
                
                BasicArrowButton.SOUTH,
                new Color(240,168,59), new Color(240,168,59),
                Color.white, new Color(240,168,59));
    }

}
