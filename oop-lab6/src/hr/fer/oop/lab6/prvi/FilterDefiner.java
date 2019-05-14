package hr.fer.oop.lab6.prvi;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

/**
 * The class FilterDefiner
 * @author Luka
 *
 */

public class FilterDefiner extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox skip, leave, filter, limit, totalMiles;
	private JLabel txtSkipped, txtLeave;
	private JTextArea recordsToSkip, recordsToLeave, distance, miles;
	private JRadioButton cash, card, unknown;
	@SuppressWarnings("rawtypes")
	private JComboBox relation;
	
	/**
	 * Instantiates new filter definer
	 */
	
	public FilterDefiner() {
		this.setLocation(20, 20);
		this.setSize(300, 120);
		this.setVisible(false);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setTitle("Define filter");
		initGUI();
		this.pack();
		
	}
	
	/**
	 * Initializes elements of graphical user interface
	 */
	
	private void initGUI() {
		Vector<String> vector=new Vector<String>();
		ArrayList<String> relations=new ArrayList<String>();
		relations.add("<");
		relations.add(">");
		relations.add("=");
		vector.addAll(relations);
		
		Container c=getContentPane();
		c.setLayout(new MigLayout());
		
		totalMiles=new JCheckBox("Count total miles?");
		skip=new JCheckBox("Skip records?");
		leave=new JCheckBox("Leave records?");
		filter=new JCheckBox("Filter by payment types?");
		limit=new JCheckBox("Limit distance?");
		
		txtSkipped=new JLabel("Number of records to skip: ");
		txtLeave=new JLabel("Number of records to leave: ");
		
		miles=new JTextArea(1,20);
		miles.setVisible(true);
		recordsToSkip=new JTextArea(1,20);
		recordsToSkip.setVisible(true);
		recordsToLeave=new JTextArea(1,20);
		recordsToLeave.setVisible(true);
		
		ButtonGroup paymentType=new ButtonGroup();
		
		cash=new JRadioButton("Cash (CSH)");
		card=new JRadioButton("Card (CRD)");
		unknown=new JRadioButton("Unknown (UNK)");
		paymentType.add(cash);
		paymentType.add(card);
		paymentType.add(unknown);
		
		relation=new JComboBox<>(vector);
		distance=new JTextArea(1,20);
		distance.setVisible(true);
		
		c.add(skip, "cell 0 0");
		c.add(leave, "cell 0 1");
		c.add(filter, "cell 0 4");
		c.add(limit, "cell 0 6");
		c.add(totalMiles, "cell 0 7");
		
		c.add(txtSkipped, "cell 1 0");
		c.add(txtLeave, "cell 1 1");
		c.add(recordsToSkip, "cell 2 0");
		c.add(recordsToLeave, "cell 2 1");
		
		c.add(cash, "cell 2 2");
		c.add(card, "cell 2 3");
		c.add(unknown, "cell 2 4");
		
		c.add(relation, "cell 1 6");
		c.add(distance, "cell 2 6");
		c.add(miles, "cell 2 7");
		
	}
	
	/**
	 * Gets the filter data
	 * @return the filter data
	 */
	
	public FilterData getFilterData() {
		FilterData data=new FilterData();
		
		if(skip.isSelected()) {
			data.setSkipRecords(true);
			data.setSkip(Integer.parseInt(recordsToSkip.getText()));
		}
		
		if(leave.isSelected()) {
			data.setLeaveRecords(true);
			data.setLeave(Integer.parseInt(recordsToLeave.getText()));	
		}
		
		if(filter.isSelected()) {
			data.setFilterByType(true);
			if(cash.isSelected()) {
				data.setPaymentType(PaymentType.CSH);
			} else if(card.isSelected()) {
				data.setPaymentType(PaymentType.CRD);
			} else if(unknown.isSelected()) {
				data.setPaymentType(PaymentType.UNK);
			}
		}
		
		if(limit.isSelected()) {
			data.setLimitDistance(true);
			data.setOperator((String) relation.getSelectedItem());
			data.setDistance(Double.parseDouble(distance.getText()));
		}
		
		if(totalMiles.isSelected()) {
			data.setTotalMiles(true);
			data.setMiles(Double.parseDouble(miles.getText()));
		}
		
		return data;
	}
}
