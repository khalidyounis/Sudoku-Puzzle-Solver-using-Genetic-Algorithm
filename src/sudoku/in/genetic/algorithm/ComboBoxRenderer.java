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

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;


public class ComboBoxRenderer extends BasicComboBoxRenderer {
    private Color background;
    private Color selectionBackground;

    public ComboBoxRenderer() {
        super();

        background = UIManager.getColor("ComboBox.background");
        selectionBackground = UIManager.getColor("ComboBox.selectionBackground");
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText((String) value);

        if (isSelected) setBackground(selectionBackground);
        else setBackground(background);

        return this;
    }
}