
public class Beyblade {
	 
	double xSpeed=0, spdX;
	double ySpeed=0, spdY;
	double power;
	int xPos, prevX;
	int yPos, prevY;
	
	public Beyblade(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSpeed = 0;
		this.ySpeed = 0;
	}
	public void fight(){
	//	this.power = Math.sqrt((xSpeed*xSpeed)+(ySpeed*ySpeed)); // pagaidam unused
			if (this.xPos<300) this.xSpeed = this.xSpeed+.35;
			if (this.xPos>300) this.xSpeed = this.xSpeed-.35;
			if (this.yPos<200) this.ySpeed = this.ySpeed+.35;
			if (this.yPos>200) this.ySpeed = this.ySpeed-.35;
			if (this.xSpeed>0) this.xSpeed = this.xSpeed-.05;
			if (this.xSpeed<0) this.xSpeed = this.xSpeed+.05;
			if (this.ySpeed>0) this.ySpeed = this.ySpeed-.05;
			if (this.ySpeed<0) this.ySpeed = this.ySpeed+.05;
	}
}
