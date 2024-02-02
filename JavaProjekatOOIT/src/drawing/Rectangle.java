package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperLeftPoint;
	private int width;
	private int length;
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int length) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.length = length;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int length, boolean selected) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.length = length;
		setSelected(selected);
	}
	
	public String toString() {
		return "Rectangle [Upper left point= " + upperLeftPoint + ", width= " + width+ ","
				+ " length= "+ length + ", selected= "+ isSelected() + "]" ;
	}
	
	public int area() {
		return width*length;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return(int)(this.area()-((Rectangle)o).area());	
			}
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawRect(this.getUpperLeftPoint().getX(),
				this.getUpperLeftPoint().getY(), this.getWidth(), this.getLength());
		
		if(isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getUpperLeftPoint().getX() - 3,
					this.getUpperLeftPoint().getY()- 3, 6, 6); //gore levo
			g.drawRect(this.getUpperLeftPoint().getX() + this.getWidth() -3,
					this.getUpperLeftPoint().getY() -3, 6, 6); //gore desno
			g.drawRect(this.getUpperLeftPoint().getX() -3,
					this.getUpperLeftPoint().getY() +this.getLength()-3, 6, 6);//dole levo
			g.drawRect(this.getUpperLeftPoint().getX()+ this.getWidth() - 3,
					this.getUpperLeftPoint().getY() + this.getLength() - 3, 6, 6);//dole desno
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		return (this.upperLeftPoint.getX() <= x &&
				x <= this.upperLeftPoint.getX() + width &&
				this.upperLeftPoint.getY() <= y &&
				y <= this.getUpperLeftPoint().getY() + length);
	}

	@Override
	public void move(int newX, int newY) {
		upperLeftPoint.move(newX, newY);

	}

	@Override
	public void DialogEdit() {
		DlgRectangle dlgRectangle = new DlgRectangle();
		for(Shape shape : PnlDrawing.shapesArrList) {
			if(shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dlgRectangle.getTxtXCoord().setText(split[4]);
				dlgRectangle.getTxtYCoord().setText(split[7]);
				dlgRectangle.getTxtWidth().setText(split[13]);
				dlgRectangle.getTxtLength().setText(split[16]);
				
			}
		}
		dlgRectangle.setVisible(true);
		

	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUpperLeftPoint().getX(),
				this.getUpperLeftPoint().getY(), this.getWidth(), this.getLength());
	}
	
}
