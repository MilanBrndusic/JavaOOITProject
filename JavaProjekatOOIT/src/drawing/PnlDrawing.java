package drawing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel implements MouseListener{
	static int obj = 0;
	int mx,my;
	static ArrayList<Shape> shapesArrList = new ArrayList<Shape>();
	public Point startLine = null;
	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		switch(obj) {
		case 1:
		Point p = new Point(mx,my,false);
		p.setOutline(DrawingFrm.outline);
		shapesArrList.add(p);
		System.out.println(shapesArrList);
		break;
		case 2:
			if (startLine== null) {
				startLine = new Point (mx,my,false);
			}else {
				Point endLine = new Point(mx,my);
				Line line = new Line(startLine,endLine,false);
				line.setOutline(DrawingFrm.outline);
				shapesArrList.add(line);
				System.out.println(line);
				startLine= null;
			}
			break;
		case 3:
		DlgRectangle dlgRectanlge = new DlgRectangle();
		dlgRectanlge.getTxtXCoord().setText(String.valueOf(mx));
		dlgRectanlge.getTxtXCoord().setEditable(false);
		dlgRectanlge.getTxtYCoord().setText(String.valueOf(my));
		dlgRectanlge.getTxtYCoord().setEditable(false);
		dlgRectanlge.setVisible(true);
			if(dlgRectanlge.isOk == true) {
				Rectangle r = new Rectangle(new Point(mx,my),
				Integer.parseInt(dlgRectanlge.getTxtWidth().getText()),
				Integer.parseInt(dlgRectanlge.getTxtLength().getText()),
				false);
			r.setOutline(DrawingFrm.outline);
			r.setFill(DrawingFrm.area);
			if(dlgRectanlge.isOutlineBool()) {
				r.setOutline(dlgRectanlge.getOutline());
			}
			if(dlgRectanlge.isFillBool()) {
				r.setFill(dlgRectanlge.getOutline());
			}
			System.out.println(r);
			shapesArrList.add(r);
			}
		break;
		case 4:
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.getTxtFldXCoord().setText(String.valueOf(mx));
			dlgCircle.getTxtFldYCoord().setText(String.valueOf(my));
			dlgCircle.getTxtFldXCoord().setEditable(false);
			dlgCircle.getTxtFldYCoord().setEditable(false);
			dlgCircle.setVisible(true);
			if(dlgCircle.isOk == true) {
				Circle c = new Circle(new Point(mx,my),
						Integer.parseInt(dlgCircle.getTxtFldRadius().getText()),
						false);
					c.setOutline(DrawingFrm.outline);
					c.setFill(DrawingFrm.area);
					if(dlgCircle.isOutlineBool()) {
						c.setOutline(dlgCircle.getOutline());
					}
					if(dlgCircle.isFillBool()) {
						c.setFill(dlgCircle.getOutline());
					}
					shapesArrList.add(c);
					System.out.println(c);
					}
			break;
		case 5:
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.getTxtFldXCoord().setText(String.valueOf(mx));
			dlgDonut.getTxtFldYCoord().setText(String.valueOf(my));
			dlgDonut.getTxtFldXCoord().setEditable(false);
			dlgDonut.getTxtFldYCoord().setEditable(false);
			dlgDonut.setVisible(true);
			if(dlgDonut.isOk == true) {
				Donut d = new Donut(new Point(mx,my),
						Integer.parseInt(dlgDonut.getTxtFldOuterRadius().getText()),
						Integer.parseInt(dlgDonut.getTxtFldInnerRadius().getText()),
						false);
				d.setOutline(DrawingFrm.outline);
				d.setFill(DrawingFrm.area);
				if(dlgDonut.isOutlineBool()) {
					d.setOutline(dlgDonut.getOutline());
				}
				if(dlgDonut.isFillBool()) {
					d.setFill(dlgDonut.getOutline());
				}
				shapesArrList.add(d);
				System.out.println(d);
			}
			break;
		case 6:
			boolean match = false;
			Collections.reverse(shapesArrList);
			for (Shape shape : shapesArrList) {
				shape.setSelected(false);
				if(match == false) {
					if(shape.contains(mx, my)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapesArrList);
			break;
		}
				
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : shapesArrList) {
			shape.AreaPainter(g);
			shape.draw(g);
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	public PnlDrawing() {
		addMouseListener(this);
	}

}
