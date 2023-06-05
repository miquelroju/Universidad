package Sessio1;

import javax.swing.*;

public class JButtonMemory extends JButton {

	private ImageIcon img;
	private boolean estat;
	private static final ImageIcon imatgeDarrera = new ImageIcon(JButtonMemory.class.getResource("darrera.png"));

	public JButtonMemory(ImageIcon quina) {
		super(quina);
		this.img = quina;
		setEstat(false);
	}

	/*
	public void setEstat() {
		this.estat = !this.estat;
		if (this.estat) {
			setIcon(img);
		} else {
			setIcon(imatgeDarrera);
		}
	}
	
	public void setFinalitzar() {
		this.estat = true;
	}
	*/
	
	public void setEstat(boolean estat) {
		if (this.estat) {
			setIcon(img);
		} else {
			setIcon(imatgeDarrera);
		}
	}

	@Override
	public boolean equals(Object c) {
		if (c instanceof JButtonMemory) {
			return this.img.equals(((JButtonMemory) c).img);
		}
		return false;
	}

}
