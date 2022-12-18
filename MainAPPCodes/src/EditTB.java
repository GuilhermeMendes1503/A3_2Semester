import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import CustomComponents.WindowBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EditTB extends JDialog {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	public JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private String[] Results;
	private JDialog parente = this;
	
	public EditTB(String CNPJ) {
		setResizable(false);
		WindowBar windowBar = new WindowBar(null,parente);
		
		setUndecorated(true);
		setBackground(Color.LIGHT_GRAY);
		Results = Crud.readcnpj(CNPJ);
		setBounds(100, 100, 470, 365);
		{

			lblNewLabel = new JLabel("Nome");

		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setText(Results[0]);
		}
		{
			lblNewLabel_1 = new JLabel("Razao Social");
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setText(Results[1]);
		}
		{
			lblNewLabel_2 = new JLabel("CNPJ");
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setText(Results[2]);
		}
		{
			lblNewLabel_3 = new JLabel("CNAE");
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setText(Results[3]);
		}
		{
			lblNewLabel_4 = new JLabel("Nº CNAE");
		}
		{
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setText(Results[4]);
		}
		{
			lblNewLabel_5 = new JLabel("CEP");
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setText(Results[5]);
		}
		{
			lblNewLabel_6 = new JLabel("Abertura");
		}
		{
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setText(Results[6]);
		}
		{
			lblNewLabel_7 = new JLabel("Telefone");
		}
		{
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setText(Results[7]);
		}
		{
			lblNewLabel_8 = new JLabel("Email");
		}
		{
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setText(Results[8]);
		}
		{
			lblNewLabel_9 = new JLabel("Logradouro");
		}
		{
			textField_10 = new JTextField();
			textField_10.setColumns(9);
			textField_10.setText(Results[9]);
		}
		{
			lblNewLabel_10 = new JLabel("Status");
		}
		{
			btnNewButton = new JButton("");
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setBorder(new EmptyBorder(10, 10, 10, 10));
			{
				{
					{
						btnNewButton_2 = new JButton("Deletar");
						btnNewButton_1 = new JButton("Salvar");
						
						GroupLayout groupLayout = new GroupLayout(getContentPane());
						groupLayout.setHorizontalGroup(
							groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
											.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_9)
											.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
											.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_10)
											.addGap(34)
											.addComponent(btnNewButton)
											.addGap(4)
											.addComponent(btnNewButton_2)
											.addGap(4)
											.addComponent(btnNewButton_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_3)
												.addComponent(lblNewLabel_4))
											.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_7)
												.addComponent(lblNewLabel_8))
											.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))))
									.addContainerGap())
								.addComponent(windowBar, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
						);
						groupLayout.setVerticalGroup(
							groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(windowBar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_2)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_5)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_6)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_7)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_8)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_9)
										.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(7)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_10)
										.addComponent(btnNewButton)
										.addComponent(btnNewButton_2)
										.addComponent(btnNewButton_1)))
						);
						getContentPane().setLayout(groupLayout);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Crud.update(textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText(), textField_8.getText(), textField_9.getText(), textField_10.getText());
							}
						});
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int reply = JOptionPane.showConfirmDialog(EditTB.this, "Realmente deseja deletar?", "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);
								if (reply == JOptionPane.YES_OPTION) {
									Crud.delete(CNPJ);
									EditTB.this.dispatchEvent (new WindowEvent (EditTB.this, WindowEvent.WINDOW_CLOSING));
								} 

							}
						});
					}
				}
			}
			try {
				if(Results[10].equals("ATIVA")) {
					btnNewButton.setBackground(Color.GREEN);
				}
				else
				{
					btnNewButton.setBackground(Color.RED);
				}
			}
			catch(Exception e){
				
			}

		}
	}
}
