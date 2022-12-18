package CustomComponents;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseMotionAdapter;

public class WindowBar extends JPanel {

	/**
	 * Create the panel.
	 */
	int xx, yy;

	public WindowBar (JFrame parentF, JDialog parentD) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				
				if(parentF != null) {
					parentF.setExtendedState(parentF.getExtendedState() | JFrame.NORMAL);
					parentF.setBounds(x - xx , y - yy , 600, 350);
				}
				else
				parentD.setLocation(x - xx , y - yy);
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setMinimumSize(new Dimension(30, 30));
		panel_1.setSize(90, 30);
		panel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(Color.GRAY);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setSize(30, 30);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setMinimumSize(new Dimension(30, 30));
		panel.setToolTipText("");
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		panel_1.add(panel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentF.setExtendedState(JFrame.ICONIFIED);
			}
		});
		ImageIcon imageIcon = new ImageIcon();
		try {
			imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("CustomComponents/Minimize.png"))).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		lblNewLabel_1_1.setIcon(imageIcon);
		lblNewLabel_1_1.setSize(new Dimension(30, 30));
		lblNewLabel_1_1.setBounds(0, 0, 30, 30);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 0, 30, 30);
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setMinimumSize(new Dimension(30, 30));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(Color.GRAY);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(parentF.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
					parentF.setExtendedState(parentF.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				}
				else {
					parentF.setExtendedState(parentF.getExtendedState() | JFrame.NORMAL);
					parentF.setSize(600, 417);
				}
			}
		});
		

		try {
			imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("CustomComponents/Maximize.png"))).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblNewLabel_1.setIcon(imageIcon);
		lblNewLabel_1.setSize(new Dimension(30, 30));
		lblNewLabel_1.setBounds(0, 0, 30, 30);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(60, 0, 30, 30);
		panel_2_1.setLayout(null);
		panel_2_1.setToolTipText("");
		panel_2_1.setMinimumSize(new Dimension(30, 30));
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2_1.setBackground(Color.GRAY);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(parentF != null) {
					parentF.dispatchEvent (new WindowEvent (parentF, WindowEvent.WINDOW_CLOSING));
				}
				else
					parentD.dispatchEvent (new WindowEvent (parentD, WindowEvent.WINDOW_CLOSING));
			}
		});
		try {
			imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("CustomComponents/Close.png"))).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setSize(new Dimension(30, 30));
		lblNewLabel.setBounds(0, 0, 30, 30);
		panel_2_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setText("Projeto A3 - Guilherme Mendes");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(74))
		);
		setLayout(groupLayout);

		
	}

    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(getWidth(), 0, Color.decode("#13827e"), 0, 0, Color.decode("#003f3d"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

}
