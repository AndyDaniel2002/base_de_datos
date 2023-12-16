package Interface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Auxiliar.Auxiliar;
import componentesVisuales.BotonAnimacion;


public class AnyadirConductor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrimerApellido;
	private JTextField textSegundoApellido;
	private JTextField textPasaporte;
	private JTextField textDireccion;

	/**
	 * Launch the application.
	 */


	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AnyadirConductor(final Principal p) throws ParseException {
		setFont(new Font("Arial Black", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setTitle("Agregar nuevo paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 341);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		p.setEnabled(false);
		this.setAlwaysOnTop(true);
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
            
        };
		};
		setBackground(new Color(0, 0, 0, 0));
		contentPane.setForeground(Color.decode("#85B7E3"));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(57, 70, 59, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNombre.setBounds(128, 68, 252, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textPrimerApellido = new JTextField();
		textPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPrimerApellido.setBounds(128, 103, 252, 22);
		contentPane.add(textPrimerApellido);
		textPrimerApellido.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("1er Apellido");
		lblNewLabel_2.setBounds(26, 105, 97, 16);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);

		JLabel lblPasaporte = new JLabel("CI");
		lblPasaporte.setBounds(94, 196, 22, 16);
		lblPasaporte.setForeground(Color.BLACK);
		lblPasaporte.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblPasaporte);

		JLabel lblRegistroDePacientes = new JLabel("A\u00F1adir Nuevo Chofer");
		lblRegistroDePacientes.setBounds(40, 13, 340, 39);
		lblRegistroDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDePacientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblRegistroDePacientes);
		
		final JTextField txtNumeroMovil = new JTextField();
		txtNumeroMovil.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNumeroMovil.setBounds(128, 165, 252, 22);
		contentPane.add(txtNumeroMovil);
		
		JLabel lbldoApellido = new JLabel("2do Apellido");
		lbldoApellido.setForeground(Color.BLACK);
		lbldoApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldoApellido.setBounds(26, 138, 97, 16);
		contentPane.add(lbldoApellido);
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSegundoApellido.setColumns(10);
		textSegundoApellido.setBounds(128, 136, 252, 22);
		contentPane.add(textSegundoApellido);
		
		JLabel lblIngreseContraseaNuevamente = new JLabel("Categor\u00EDa");
		lblIngreseContraseaNuevamente.setForeground(Color.BLACK);
		lblIngreseContraseaNuevamente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIngreseContraseaNuevamente.setBounds(40, 167, 76, 16);
		contentPane.add(lblIngreseContraseaNuevamente);
		
		textPasaporte = new JTextField();
		textPasaporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		((AbstractDocument) textPasaporte.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

                if (newText.matches("\\d{0,11}")) {
                    super.replace(fb, offset, length, text, attrs);
                    if (newText.length() == 11) {
                        Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
                }
            }
        });
		textPasaporte.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				  String currentText = textPasaporte.getText();
	                if (currentText.length() >= 11) {
	                    Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
	                }
			}
		});
		textPasaporte.setBounds(128, 194, 252, 22);
		contentPane.add(textPasaporte);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccin.setBounds(40, 227, 76, 16);
		contentPane.add(lblDireccin);
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		textDireccion.setColumns(10);
		textDireccion.setBounds(128, 225, 252, 22);
		contentPane.add(textDireccion);
		
		BotonAnimacion btnmcnCancelar = new BotonAnimacion();
		btnmcnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Auxiliar.reproducirSonidoBoton();
				p.setEnabled(true);
				dispose();
			}
		});
		btnmcnCancelar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmcnCancelar.setText("Cancelar");
		btnmcnCancelar.setBounds(292, 278, 87, 39);
		contentPane.add(btnmcnCancelar);
		
		BotonAnimacion btnmcnGuardar = new BotonAnimacion();
		btnmcnGuardar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnGuardar.setText("Guardar");
		btnmcnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmcnGuardar.setBounds(26, 278, 87, 39);
		contentPane.add(btnmcnGuardar);
		
		
		
		
	}
}
