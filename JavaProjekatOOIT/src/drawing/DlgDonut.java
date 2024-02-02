package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtFldXCoord;
	private JTextField txtFldYCoord;
	private JTextField txtFldOuterRadius;
	private JTextField txtFldInnerRadius;
	public boolean isOk;
	private Color outline = Color.black;
	private Color fill = Color.white;
	private boolean outlineBool;
	private boolean fillBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblXCoord = new JLabel("X Coordinate: ");
		lblXCoord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblYCoord = new JLabel("Y Coordinate: ");
		lblYCoord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblOuterRadius = new JLabel("Outer Radius: ");
		lblOuterRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblInnerRadius = new JLabel("Inner Radius: ");
		lblInnerRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtFldXCoord = new JTextField();
		txtFldXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldXCoord.setColumns(10);
		
		txtFldYCoord = new JTextField();
		txtFldYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		txtFldYCoord.setColumns(10);
		
		txtFldOuterRadius = new JTextField();
		txtFldOuterRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldOuterRadius.setColumns(10);
		
		txtFldInnerRadius = new JTextField();
		txtFldInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtFldInnerRadius.setColumns(10);
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null,"Izaberite boju",
						Color.black);
				outlineBool = true;
			}
		});
		
		JButton btnAreaColor = new JButton("Area Color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null,"Izaberite boju",
						Color.black);
				fillBool = true;
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addComponent(btnAreaColor)
							.addContainerGap())
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlCenter.createSequentialGroup()
								.addComponent(btnOutlineColor)
								.addContainerGap())
							.addGroup(gl_pnlCenter.createSequentialGroup()
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnlCenter.createSequentialGroup()
										.addComponent(lblInnerRadius, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_pnlCenter.createSequentialGroup()
										.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblXCoord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblYCoord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(58))
									.addGroup(gl_pnlCenter.createSequentialGroup()
										.addComponent(lblOuterRadius, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
									.addComponent(txtFldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtFldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtFldOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtFldInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(139, Short.MAX_VALUE)))))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXCoord))
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblYCoord)
						.addComponent(txtFldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOuterRadius))
					.addGap(27)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFldInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInnerRadius))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOutlineColor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAreaColor)
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
						if(txtFldXCoord.getText().trim().isEmpty() || 
							txtFldYCoord.getText().trim().isEmpty() ||
							txtFldOuterRadius.getText().trim().isEmpty() || 
							txtFldInnerRadius.getText().trim().isEmpty()) 
						{
									isOk= false;
									
						JOptionPane.showMessageDialog(null,"Molim Vas popunite sva polja.","Error",
								JOptionPane.ERROR_MESSAGE);
						getToolkit().beep();
								} else {
									if(Integer.parseInt(txtFldOuterRadius.getText()) >
									Integer.parseInt(txtFldInnerRadius.getText())) {
										for(Shape shape : PnlDrawing.shapesArrList) {
											if(shape.isSelected()) {
												shape.move(Integer.parseInt(txtFldXCoord.getText()),
														   Integer.parseInt(txtFldYCoord.getText()));
												((Donut)shape).setRadius(Integer.parseInt(txtFldOuterRadius.getText()));
												((Donut)shape).setInnerRadius(Integer.parseInt(txtFldInnerRadius.getText()));
												
												if(isOutlineBool() == true) {
													shape.setOutline(outline);
													setOutlineBool(false);
												}
												if(isFillBool() == true) {
													shape.setFill(fill);
													setFillBool(false);
												}
											}
										}
									isOk = true;
									dispose();
									} else {
										isOk = false;
										JOptionPane.showMessageDialog(null, "Unutrasnji precnik mora imati manju vrednost od spoljnjeg precnika","Error",
												JOptionPane.ERROR_MESSAGE);
									}
							}
								
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

	public JTextField getTxtFldXCoord() {
		return txtFldXCoord;
	}

	public void setTxtFldXCoord(JTextField txtFldXCoord) {
		this.txtFldXCoord = txtFldXCoord;
	}

	public JTextField getTxtFldYCoord() {
		return txtFldYCoord;
	}

	public void setTxtFldYCoord(JTextField txtFldYCoord) {
		this.txtFldYCoord = txtFldYCoord;
	}

	public JTextField getTxtFldOuterRadius() {
		return txtFldOuterRadius;
	}

	public void setTxtFldOuterRadius(JTextField txtFldOuterRadius) {
		this.txtFldOuterRadius = txtFldOuterRadius;
	}

	public JTextField getTxtFldInnerRadius() {
		return txtFldInnerRadius;
	}

	public void setTxtFldInnerRadius(JTextField txtFldInnerRadius) {
		this.txtFldInnerRadius = txtFldInnerRadius;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public boolean isOutlineBool() {
		return outlineBool;
	}

	public void setOutlineBool(boolean outlineBool) {
		this.outlineBool = outlineBool;
	}

	public boolean isFillBool() {
		return fillBool;
	}

	public void setFillBool(boolean fillBool) {
		this.fillBool = fillBool;
	}
	

}
