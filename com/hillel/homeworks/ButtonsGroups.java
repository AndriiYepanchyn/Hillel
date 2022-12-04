package com.hillel.homeworks;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ButtonsGroups extends JFrame{
	private static String[] ids = {"june", "july", "may", "april", "march"};
	public ButtonsGroups() {
		setLayout(new FlowLayout());
		add(makeBPanel(JButton.class, ids));
		add(makeBPanel(JToggleButton.class, ids));
		add(makeBPanel(JCheckBox.class, ids));
		add(makeBPanel(JRadioButton.class, ids));
	}
	
	static JPanel makeBPanel (Class <? extends AbstractButton> kind, String[] ids) {
		ButtonGroup bg = new ButtonGroup();
		JPanel jp = new JPanel();
		String title = kind.getName();
		title = title.substring(title.lastIndexOf('.')+1);
		for(String id: ids) {
			AbstractButton ab = new JButton("failed");
			try {
				Constructor con = kind.getConstructor(String.class);
				ab = (AbstractButton) con.newInstance(id);
				
			} catch(Exception e) {
				System.err.println("cant crate " + kind);
			}
		
			
		
		bg.add(ab);
		ab.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				AbstractButton ab =(AbstractButton) e.getItem();
				
				System.out.println(	ab.getText());
				
			}
		});
		
		jp.add(ab);
		
		
		jp.setBorder(new TitledBorder(title));
		}
		return jp;
		
	}
	
	public static void main(String[] args) {
		ButtonsGroups frame = new ButtonsGroups();
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}
