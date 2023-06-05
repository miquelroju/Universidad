package Sessio1;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource.LineBorderUIResource;
import java.awt.*;

public class casella extends JPanel {

	public casella() {
		super();
		this.setMort();
	}

	public void setViu() {
		this.setBackground(Color.green);
		this.setBorder(new LineBorderUIResource(Color.gray));
	}

	public void setMort() {
		this.setBackground(Color.black);
		this.setBorder(new LineBorderUIResource(Color.gray));
	}

	public boolean getEstat() {
		if (this.getBackground() == Color.green) {
			return true; // si el color es verd dons esta viva
		} else
			return false; // qualsevol altre color esta morta
	}

}