package windowBuilder.views;

import javax.swing.*;
import java.awt.*;


public class BorderedLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	
	// Default color, changed only by WN8 labels.
	private Color textColor = Color.white;
	
	public BorderedLabel(String text) {
		super(text);
	}
	
	// Used only for Wn8 Labels.
    public BorderedLabel(String text, Color textColor) {
        super(text);
        this.textColor = textColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(getText());
        int height = fm.getHeight();

        g.setColor(Color.BLACK);
        g.drawString(getText(), 0, fm.getAscent());
        g.drawString(getText(), 2, fm.getAscent());
        g.drawString(getText(), 0, fm.getAscent() + 2);
        g.drawString(getText(), 2, fm.getAscent() + 2);

        g.setColor(textColor);
        g.drawString(getText(), 1, fm.getAscent() + 1);

        setSize(new Dimension(width + 2, height + 2));
    }
}
