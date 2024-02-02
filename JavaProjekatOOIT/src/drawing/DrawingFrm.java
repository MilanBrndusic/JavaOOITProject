package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing();
	static Color outline = Color.black;
	static Color area  = Color.white;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
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
	public DrawingFrm() {
		setTitle("Milan Brndusic II 72/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setBorder(null);
		contentPane.add(pnlDrawing,BorderLayout.CENTER);
		
		JPanel pnlButton = new JPanel();
		contentPane.add(pnlButton, BorderLayout.EAST);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 1;
				for(Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 2;
				for(Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 4;
				for(Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 3;
				for(Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 5;
				for(Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ne postoji ni jedan objekat koji se moze selektovati!",
							"Information", JOptionPane.INFORMATION_MESSAGE);
						return;
				} else {
				PnlDrawing.obj = 6;
			}
		}
	});
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shape selectedShape = null;

		        for (Shape shape : PnlDrawing.shapesArrList) {
		            if (shape.isSelected()) {
		                selectedShape = shape;
		                break;
		            }
		        }

		        if (selectedShape != null) {
		            selectedShape.DialogEdit();
		        } else {
		            JOptionPane.showMessageDialog(null, "Nije selektovan nijedan oblik!", "Information", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArrList.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Ne postoji nijedan oblik koji se moze obrisati!", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        boolean objectRemoved = false;
		        java.util.Iterator<Shape> iterator = PnlDrawing.shapesArrList.iterator();
		        while (iterator.hasNext()) {
		            Shape shape = iterator.next();
		            if (shape.isSelected()) {
		                int ans = JOptionPane.showConfirmDialog(null,
		                        "Da li ste sigurni da zelite da obrisete ovaj oblik?",
		                        "Confirmation", JOptionPane.YES_NO_OPTION);
		                if (ans == 0) {
		                    iterator.remove();
		                    objectRemoved = true; 
		                    JOptionPane.showMessageDialog(null, "Oblik uspesno obrisan.", "Information", JOptionPane.INFORMATION_MESSAGE);
		                }
		            }
		        }
		        if (!objectRemoved) {
		            JOptionPane.showMessageDialog(null, "Morate imati neki oblik oznacen!", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
			
		});
		
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Izaberite boju", Color.black);
				if(outline == null) {
					outline = Color.black;
				}
			}
		});
		
		JButton btnAreaColor = new JButton("Area Color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area = JColorChooser.showDialog(null, "Izaberite boju", Color.white);
					if(area == null) {
						area = Color.white;
					}
				
			}
		});
		GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
		gl_pnlButton.setHorizontalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pnlButton.createParallelGroup(Alignment.LEADING)
							.addComponent(btnPoint, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pnlButton.createSequentialGroup()
								.addGap(1)
								.addComponent(btnLine, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnCircle, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRectangle, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDonut, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnModify, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnlButton.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnOutlineColor)
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAreaColor, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_pnlButton.setVerticalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCircle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDonut)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelect)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModify)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOutlineColor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAreaColor)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_pnlButton.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnPoint, btnLine, btnCircle, btnRectangle, btnDonut, btnSelect, btnModify, btnDelete, btnOutlineColor, btnAreaColor});
		pnlButton.setLayout(gl_pnlButton);
		
		
	}
}
