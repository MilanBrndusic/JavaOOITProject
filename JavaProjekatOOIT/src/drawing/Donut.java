package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
 
	private int innerRadius;

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius=innerRadius;
		
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
		setSelected(selected);
	}
	
	public String toString() {
		return "Donut [ Inner radius="+innerRadius+", Outer[ "+ super.toString()+ "]";
	}
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getOutline());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(),
				this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius()*2, this.getInnerRadius()*2);
		
	}
	public boolean contains(int x, int y) {
		return super.contains(x, y) && this.getCenter().distance(x, y) >=
				this.getInnerRadius();
	}
	
	@Override
	public void DialogEdit() {
		DlgDonut dlgDonut = new DlgDonut();
		for(Shape shape : PnlDrawing.shapesArrList) {
			if(shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dlgDonut.getTxtFldXCoord().setText(split[11]);
				dlgDonut.getTxtFldYCoord().setText(split[14]);
				dlgDonut.getTxtFldOuterRadius().setText(split[19]);
				dlgDonut.getTxtFldInnerRadius().setText(split[3]);
				
			}
		}
		dlgDonut.setVisible(true);
	}
	
	@Override
	public void AreaPainter(Graphics g) {
		super.AreaPainter(g);
		g.setColor(getFill());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(),
				this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2,this.getInnerRadius() * 2);
		g.setColor(Color.white);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(),
				  this.getCenter().getY() - this.getInnerRadius(),
				  this.getInnerRadius() * 2, this.getInnerRadius() * 2);
	}
	
 
}
