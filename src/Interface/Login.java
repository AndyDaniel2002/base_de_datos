package Interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import Auxiliar.Auxiliar;
import componentesVisuales.AvatarCircular;
import componentesVisuales.BotonAnimacion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField jpassClave;
	/**
	 * Create the frame.
	 */
	public Login() {
		Auxiliar.login=false;
		setFont(new Font("Arial Black", Font.BOLD, 13));
		setForeground(Color.BLACK);
		setTitle("Loging");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 513);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		
		
		
		contentPane = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth() - 1;
                int height = getHeight() - 1;
                int cornerRadius = 20;

                // Dibujar rectángulo redondeado
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.decode("#8CB9E2"));
                g2d.fillRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
                g2d.setColor(getForeground());
                g2d.drawRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
                g2d.dispose();
            }
        };
		
		setBackground(new Color(0, 0, 0, 0));
		contentPane.setLayout(null);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(11, 11, 11, 11));
		setContentPane(contentPane);
		

		
		
		JLabel lblNewLabel = new JLabel("Ingrese nombre y contrase\u00F1a");
		lblNewLabel.setBounds(441, 34, 353, 76);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(Color.BLACK);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(441, 163, 99, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblContrasea.setBounds(441, 288, 99, 16);
		contentPane.add(lblContrasea);
		
		jpassClave = new JPasswordField();
		jpassClave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jpassClave.setBackground(Color.decode("#C2FDFF"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				jpassClave.setBackground(UIManager.getColor("TextField.background"));
			}
		});
		jpassClave.setFont(new Font("Tahoma", Font.BOLD, 13));
		jpassClave.setBounds(441, 317, 248, 22);
		contentPane.add(jpassClave);
		
		final JTextField txtNewText= new JTextField();
		txtNewText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				txtNewText.setBackground(Color.decode("#C2FDFF"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 txtNewText.setBackground(UIManager.getColor("TextField.background"));
			}
		});
		txtNewText.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNewText.setBounds(441, 201, 248, 22);
		contentPane.add(txtNewText);

		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(Login.class.getResource("/Imagenes/R (1).jpg")));
		avatarCircular.setBounds(12, 68, 408, 353);
		contentPane.add(avatarCircular);
		
		BotonAnimacion btnmcnSalir = new BotonAnimacion();
		btnmcnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Auxiliar.reproducirSonidoBoton();
				dispose();
			}
		});
		btnmcnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnSalir.setText("Salir");
		btnmcnSalir.setBounds(685, 434, 106, 48);
		contentPane.add(btnmcnSalir);
		
		BotonAnimacion btnmcnIngresar = new BotonAnimacion();
		btnmcnIngresar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					   char[] clave= jpassClave.getPassword();
					   String claveFinal=new String(clave);
						   if(txtNewText.getText().toString().equalsIgnoreCase("Carlos")&& claveFinal.equalsIgnoreCase("1234")){
						   Auxiliar.reproducirSonido();
						   JOptionPane.showMessageDialog(contentPane, "Bienvenido Admin");
						   Auxiliar.admin=true;
						   Auxiliar.login=true;
						   dispose();
						   if(Auxiliar.firstLogin==true){
							   Presentacion.run();
							   Auxiliar.firstLogin=false;
						   }
						   else{
						   Principal p= new Principal();
						   p.setVisible(rootPaneCheckingEnabled);
						   }
						   }
						   else if(txtNewText.getText().toString().equalsIgnoreCase("Pepe")&& claveFinal.equalsIgnoreCase("5678")){
						   Auxiliar.reproducirSonido();
						   JOptionPane.showMessageDialog(contentPane, "Bienvenido Funcionario");
						   Auxiliar.login=true;
						   Auxiliar.admin=false;
						   dispose();
						   if(Auxiliar.firstLogin==true){
							   Presentacion.run();
							   Auxiliar.firstLogin=false;
							   }
						   else{
						   Principal p= new Principal();
						   p.setVisible(rootPaneCheckingEnabled);
						   }
						   }
					       else{
					    	   Auxiliar.reproducirSonidoError();
							   JOptionPane.showMessageDialog(null, "Nombre o Contrasena Incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
							   jpassClave.setText("");
							   Auxiliar.login=false;
						   }
				        
				
			}
		});
		btnmcnIngresar.setText("Ingresar");
		btnmcnIngresar.setBounds(22, 434, 106, 48);
		contentPane.add(btnmcnIngresar);
		
		
		
	}
}