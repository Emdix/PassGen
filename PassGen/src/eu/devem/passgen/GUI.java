package eu.devem.passgen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame implements MouseListener, ChangeListener, ItemListener, ActionListener {
	private static final long serialVersionUID = 5171539746112047596L;

	private Controller controller;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel labelPasswordLength, labelPassword;
	private JSlider sliderPasswordLength;
	private JCheckBox checkBoxUppercaseLetters, checkBoxLowercaseLetters, checkBoxSpecialCharacters, checkBoxNumbers;
	private JTextField textFieldPassword;
	private JButton buttonRegenerate;

	public GUI(Controller controller) {
		this.controller = controller;
	}

	public void initGUI() {
		initFrame();
	}
	
	private void initFrame() {
		frame = new JFrame("PassGen");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		initPanel();
	}
	
	private void initPanel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 500, 300);
		panel.setOpaque(true);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.addMouseListener(this);
		frame.add(panel);
		
		labelPasswordLength = new JLabel("Password length:");
		labelPasswordLength.setBounds(0, 0, 100, 15);
		panel.add(labelPasswordLength);
		
		sliderPasswordLength = new JSlider(JSlider.HORIZONTAL,0,40,0);
		sliderPasswordLength.setBounds(0, 15, 490, 45);
		sliderPasswordLength.setMajorTickSpacing(10);
		sliderPasswordLength.setMinorTickSpacing(1);
		sliderPasswordLength.setPaintTicks(true);
		sliderPasswordLength.setPaintLabels(true);
		sliderPasswordLength.setBackground(Color.WHITE);
		sliderPasswordLength.addChangeListener(this);
		panel.add(sliderPasswordLength);
		
		checkBoxUppercaseLetters = new JCheckBox("Uppercase letters");
		checkBoxUppercaseLetters.setBounds(0, 65, 150, 15);
		checkBoxUppercaseLetters.setBackground(Color.WHITE);
		checkBoxUppercaseLetters.addItemListener(this);
		panel.add(checkBoxUppercaseLetters);
		
		checkBoxLowercaseLetters = new JCheckBox("Lowercase letters");
		checkBoxLowercaseLetters.setBounds(0, 80, 150, 15);
		checkBoxLowercaseLetters.setBackground(Color.WHITE);
		checkBoxLowercaseLetters.addItemListener(this);
		panel.add(checkBoxLowercaseLetters);
		
		checkBoxSpecialCharacters = new JCheckBox("Special characters");
		checkBoxSpecialCharacters.setBounds(0, 95, 150, 15);
		checkBoxSpecialCharacters.setBackground(Color.WHITE);
		checkBoxSpecialCharacters.addItemListener(this);
		panel.add(checkBoxSpecialCharacters);
		
		checkBoxNumbers = new JCheckBox("Numbers");
		checkBoxNumbers.setBounds(0, 110, 150, 15);
		checkBoxNumbers.setBackground(Color.WHITE);
		checkBoxNumbers.addItemListener(this);
		panel.add(checkBoxNumbers);
		
		labelPassword = new JLabel("Password:");
		labelPassword.setBounds(0, 150, 100, 15);
		panel.add(labelPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(0, 165, 500, 20);
		textFieldPassword.setEditable(false);
		panel.add(textFieldPassword);
		
		buttonRegenerate = new JButton("Regenerate");
		buttonRegenerate.setBounds(0, 190, 150, 20);
		buttonRegenerate.addActionListener(this);
		panel.add(buttonRegenerate);
		
		panel.repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void stateChanged(ChangeEvent e) {
//		if(e.getSource().equals(sliderPasswordLength)) {
//			JSlider slider = (JSlider) e.getSource();
//			if(!slider.getValueIsAdjusting()) {
//				controller.generatePassword();
//			}
//		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 if(e.getSource().equals(checkBoxUppercaseLetters)) {
			// controller.generatePassword();
		 }
		 
		 if(e.getSource().equals(checkBoxLowercaseLetters)) {
			// controller.generatePassword();
		 }
		 
		 if(e.getSource().equals(checkBoxSpecialCharacters)) {
			// controller.generatePassword();
		 }
		 
		 if(e.getSource().equals(checkBoxNumbers)) {
			// controller.generatePassword();
		 }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Regenerate")) {
			if(checkBoxUppercaseLetters.isSelected() || checkBoxLowercaseLetters.isSelected() || checkBoxSpecialCharacters.isSelected() || checkBoxNumbers.isSelected()) {
				if(sliderPasswordLength.getValue()>0) {
					controller.generatePassword();
				}
			}
		}
	}

	public int getSliderPasswordLength() {
		return sliderPasswordLength.getValue();
	}

	public boolean getCheckBoxUppercaseLetters() {
		return checkBoxUppercaseLetters.isSelected();
	}

	public boolean getCheckBoxLowercaseLetters() {
		return checkBoxLowercaseLetters.isSelected();
	}

	public boolean getCheckBoxSpecialCharacters() {
		return checkBoxSpecialCharacters.isSelected();
	}

	public boolean getCheckBoxNumbers() {
		return checkBoxNumbers.isSelected();
	}

	public void setTextFieldPassword(String s) {
		textFieldPassword.setText(s);
	}

}
