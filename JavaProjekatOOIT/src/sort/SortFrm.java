package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

public class SortFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Rectangle> arrayRect = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortFrm() {
		setTitle("Milan Brndusic II 72/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);
		
		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortDlg sortdlg = new SortDlg();
				sortdlg.setVisible(true);
				
				if(sortdlg.isOk == true) {
					Rectangle rec = new Rectangle(new Point
					(Integer.parseInt(sortdlg.getTxtXCoord().getText()),
					(Integer.parseInt(sortdlg.getTxtYCoord().getText()))),
					(Integer.parseInt(sortdlg.getTxtWidth().getText())),
					(Integer.parseInt(sortdlg.getTxtLength().getText())));
					arrayRect.add(rec);
					Collections.sort(arrayRect);
					dlm.add(arrayRect.indexOf(rec),"X: " + rec.getUpperLeftPoint().getX() + " , Y: " +
							rec.getUpperLeftPoint().getY() + " , Width: " + rec.getWidth() + " ,"
									+ "Length: " + rec.getLength());
					}
					
			}
			
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Ništa za ukloniti","Error",
					JOptionPane.ERROR_MESSAGE);
					getToolkit().beep();
				}
				else {
					SortDlg sortdlgdelete = new SortDlg();
					String[] split = dlm.firstElement().toString().split(" ");
					sortdlgdelete.getTxtXCoord().setText(split[1]);
					sortdlgdelete.getTxtYCoord().setText(split[4]);
					sortdlgdelete.getTxtWidth().setText(split[7]);
					sortdlgdelete.getTxtLength().setText(split[9]);
					sortdlgdelete.getTxtXCoord().setEditable(false);
					sortdlgdelete.getTxtYCoord().setEditable(false);
					sortdlgdelete.getTxtWidth().setEditable(false);
					sortdlgdelete.getTxtLength().setEditable(false);
					sortdlgdelete.setVisible(true);
					if(sortdlgdelete.isDelete() == true) {
						arrayRect.remove(0);
						dlm.removeElementAt(0);
					}
					
				} 
			}
		});
		
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlDown.createSequentialGroup()
					.addGap(56)
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addGap(64))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnAdd))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlDown.setLayout(gl_pnlDown);
	
	}
	
}
