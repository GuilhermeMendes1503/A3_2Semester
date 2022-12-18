import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.imageio.ImageIO;

import com.google.gson.JsonObject;

import java.io.IOException;
import CustomComponents.WindowBar;


public class MainInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1894128975666209249L;
	private JPanel contentPane;
	private JTextField textField;
	private static JTable table;
	private JPopupMenu popupMenu_1;
	private JScrollPane scrollPane;
	private JFrame parent = this;
	EditTB dialog = new EditTB("asdf");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setTitle("Projeto A3 - Guilherme Mendes");
					frame.setVisible(true);
					loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//
	public static void loadData() {
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nome Fantasia", "Raz\u00E3o Social", "CNPJ", "CNAE", "N\u00BA CNAE", "CEP", "Abertura", "Telefone", "Email", "Endere\u00E7o", "Status"}));
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		Crud cd = new Crud();
		
		for(Atributos at: cd.read()) {
			modelo.addRow(new Object[] {
					at.getNomeFantasia(),
					at.getRazaoSocial(),
					at.getCNPJ(),
					at.getCNAE(),
					at.getCNAECodigo(),
					at.getCEP(),
					at.getAbertura(),
					at.getTelefone(),
					at.getEmail(),
					at.getLogradouro(),
					at.getstatus()
			});
		}
	}
	
	public MainInterface() {
		setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(Color.BLACK));

		setContentPane(contentPane);
		
		WindowBar windowBar = new WindowBar(parent,null);
		windowBar.setBackground(new Color(192, 192, 192));
		GroupLayout groupLayout = (GroupLayout) windowBar.getLayout();
		groupLayout.setHonorsVisibility(false);

		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new LineBorder(Color.BLACK));
		ImageIcon imageIcon = new ImageIcon();
		try {
			imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("CustomComponents/Search.png"))).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnNewButton_1.setIcon(imageIcon);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JsonObject atributos = new Consulta().consulta(textField.getText().replaceAll("[^0-9]+", ""));
				System.out.println(atributos);
				String Telefone = "(" + atributos.get("DDD").getAsString() + ") " + atributos.get("TELEFONE").getAsString();
				String Logradouro = atributos.get("TIPO LOGRADOURO").getAsString() + " " + atributos.get("LOGRADOURO").getAsString() +
						" " + atributos.get("NUMERO").getAsString() + " | " + atributos.get("BAIRRO").getAsString() + 
						" " + atributos.get("MUNICIPIO").getAsString() + " - " + atributos.get("UF").getAsString();
				Crud.insert(atributos.get("NOME FANTASIA").getAsString(),
						atributos.get("RAZAO SOCIAL").getAsString(),
						atributos.get("CNPJ").getAsString(),
						atributos.get("CNAE PRINCIPAL DESCRICAO").getAsString(),
						atributos.get("CNAE PRINCIPAL CODIGO").getAsString(),
						atributos.get("CEP").getAsString(),
						atributos.get("DATA ABERTURA").getAsString(),
						Telefone,
						atributos.get("EMAIL").getAsString(),
						Logradouro,
						atributos.get("STATUS").getAsString());
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{atributos.get("NOME FANTASIA").getAsString(), atributos.get("RAZAO SOCIAL").getAsString(), atributos.get("CNPJ").getAsString(),
						atributos.get("CNAE PRINCIPAL DESCRICAO").getAsString(), atributos.get("CNAE PRINCIPAL CODIGO").getAsString(), atributos.get("CEP").getAsString(),
						atributos.get("DATA ABERTURA").getAsString(), Telefone, atributos.get("EMAIL").getAsString(), Logradouro, atributos.get("STATUS").getAsString()
				});
		        table.scrollRectToVisible(table.getCellRect(table.getRowCount()-1, 0, true));
			}
		});
		
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < table.getRowCount()) {
		            table.setRowSelectionInterval(r, r);
		        } else {
		            table.clearSelection();
		        }

		        int rowindex = table.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popupMenu_1;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
			}
		});
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Fantasia", "Raz\u00E3o Social", "CNPJ", "CNAE", "N\u00BA CNAE", "CEP", "Abertura", "Telefone", "Email", "Endere\u00E7o", "Status"
			}
		));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(windowBar, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(362, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(windowBar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		popupMenu_1 = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
		popupMenu_1.add(deleteItem);
		
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String id = table.getValueAt(table.getSelectedRow(), 2).toString();
            	DefaultTableModel model = (DefaultTableModel) table.getModel();
            	model.removeRow(table.getSelectedRow());
            	Crud.delete(id);
            }
        });
        JMenuItem editItem = new JMenuItem("Edit");
		popupMenu_1.add(editItem);
		
		editItem.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                String cnpj= table.getValueAt(table.getSelectedRow(), 2).toString();
    			try {
    				dialog = new EditTB(cnpj);
    				dialog.setTitle("Editando o CNPJ: " + cnpj);
    				dialog.setVisible(true);
    		        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		        dialog.addWindowListener(new WindowAdapter() {
    		            @Override
    		            public void windowClosing(WindowEvent e) {
    		                super.windowClosing(e); 
    		                loadData();
    		            }
    		        });
    			} catch (Exception error) {
    				error.printStackTrace();
    			}
            }
        });
	}
}
