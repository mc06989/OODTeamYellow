package edu.georgiasouthern.dsteamyellow.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.georgiasouthern.dsteamyellow.db.DBConnection;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import edu.georgiasouthern.dsteamyellow.ui.OrderDetailPanel;
public class DesktopApp implements OrderPanel.OnOrderListener,OrderDetailPanel.OnOrderPanelRefreshListener{
	
	public static DesktopApp _desktopapp;
	private String urlString;
	public static DesktopApp getDesktop() {
		if(_desktopapp!=null) {
			return _desktopapp;
		}
		else {
			_desktopapp = new DesktopApp();
			return _desktopapp;
		}
	}
	
	public static DesktopApp getDesktop(String urlString) {
		if(_desktopapp!=null) {
			return _desktopapp;
		}
		else {
			_desktopapp = new DesktopApp(urlString);
			return _desktopapp;
		}
	}
	
	public JFrame frame;
	public JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesktopApp window = new DesktopApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesktopApp() {
		_desktopapp=this;
		initialize();
	}
	
	public DesktopApp(String urlString) {
		_desktopapp=this;
		initialize();
		this.urlString = urlString;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame =  new JFrame();
		frame.setBounds(100, 100, 956, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setDragMode(desktopPane.OUTLINE_DRAG_MODE);
		
		OrderPanel orderPanel = new OrderPanel();
		orderPanel.setBounds(10, 28, 600, 305);
		desktopPane.add(orderPanel);
		
		System.err.println(orderPanel.getLocation());
		desktopPane.setVisible(true);
		
	}

	public void orderDetail(OrderDetailPanel nof) {
		nof.setBounds(462, 68, 468, 359);
		nof.setVisible(true);
		desktopPane.add(nof);
		nof.toFront();
	}

	public void OrderPanelRefresh(int oid) {
		orderDetail(new OrderDetailPanel(oid));
		
	}

	public void orderRefresh() {
		OrderPanel orderPanel = new OrderPanel();
		orderPanel.setBounds(10, 28, 600, 305);
		desktopPane.add(orderPanel);
	}
	

}
