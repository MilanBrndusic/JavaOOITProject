package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtFldXCoordStart;
	private JTextField txtFldYCoordStart;
	private JTextField txtFldXCoordEnd;
	private JTextField txtFldYCoordEnd;
	private Color outline = Color.black;
	private boolean outlineBool;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		JLabel lblXCoordStart = new JLabel("X start: ");
		lblXCoordStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel lblYCoordStart = new JLabel("Y Start:");
		lblYCoordStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel lblXCoordEnd = new JLabel("X end:");
		lblXCoordEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel lblYCoordEnd = new JLabel("Y end:");
		lblYCoordEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFldXCoordStart = new JTextField();
		txtFldXCoordStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldXCoordStart.setColumns(10);
		
		txtFldYCoordStart = new JTextField();
		txtFldYCoordStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldYCoordStart.setColumns(10);
		
		txtFldXCoordEnd = new JTextField();
		txtFldXCoordEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldXCoordEnd.setColumns(10);
		
		txtFldYCoordEnd = new JTextField();
		txtFldYCoordEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldYCoordEnd.setColumns(10);
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null,"Izaberite boju",
						Color.black);
				outlineBool = true;
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOutlineColor)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblXCoordStart, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(lblXCoordEnd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblYCoordStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblYCoordEnd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(72)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFldYCoordEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFldXCoordEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFldYCoordStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFldXCoordStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldXCoordStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXCoordStart))
					.addGap(26)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldYCoordStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYCoordStart))
					.addGap(21)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldXCoordEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXCoordEnd))
					.addGap(27)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldYCoordEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYCoordEnd))
					.addGap(18)
					.addComponent(btnOutlineColor)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPanel, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtFldXCoordStart.getText().trim().isEmpty()
					|| txtFldYCoordStart.getText().trim().isEmpty() || 
					txtFldXCoordEnd.getText().trim().isEmpty() ||
					txtFldYCoordEnd.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Popunite sva polja!",
									"Error", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}else {
							for(Shape shape : PnlDrawing.shapesArrList) {
								if(shape.isSelected()) {
									((Line)shape).setStart(new Point 
											(Integer.parseInt(txtFldXCoordStart.getText()),
											Integer.parseInt(txtFldYCoordStart.getText())));
									
									((Line)shape).setEnd(new Point
											(Integer.parseInt(txtFldXCoordEnd.getText()),
											Integer.parseInt(txtFldYCoordEnd.getText())));
								if(outlineBool == true) {
									shape.setOutline(outline);
									outlineBool = false;
									}
								}
								
							}
						}
						dispose();
						return;
					}
				});
				okButton.setActionCommand("OK");
				btnPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				btnPanel.add(cancelButton);
			}
		}
	}

	public JTextField getTxtFldXCoordStart() {
		return txtFldXCoordStart;
	}

	public void setTxtFldXCoordStart(JTextField txtFldXCoordStart) {
		this.txtFldXCoordStart = txtFldXCoordStart;
	}

	public JTextField getTxtFldYCoordStart() {
		return txtFldYCoordStart;
	}

	public void setTxtFldYCoordStart(JTextField txtFldYCoordStart) {
		this.txtFldYCoordStart = txtFldYCoordStart;
	}

	public JTextField getTxtFldXCoordEnd() {
		return txtFldXCoordEnd;
	}

	public void setTxtFldXCoordEnd(JTextField txtFldXCoordEnd) {
		this.txtFldXCoordEnd = txtFldXCoordEnd;
	}

	public JTextField getTxtFldYCoordEnd() {
		return txtFldYCoordEnd;
	}

	public void setTxtFldYCoordEnd(JTextField txtFldYCoordEnd) {
		this.txtFldYCoordEnd = txtFldYCoordEnd;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public boolean isOutlineBool() {
		return outlineBool;
	}

	public void setOutlineBool(boolean outlineBool) {
		this.outlineBool = outlineBool;
	}
	

}
