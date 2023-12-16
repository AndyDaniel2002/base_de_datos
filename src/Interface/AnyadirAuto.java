package Interface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Auxiliar.Auxiliar;
import componentesVisuales.BotonAnimacion;


public class AnyadirAuto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textColor;

	/**
	 * Launch the application.
	 */


	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AnyadirAuto(final Principal p) throws ParseException {
		setFont(new Font("Arial Black", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setTitle("Agregar nuevo paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 293);
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
		contentPane.setForeground(Color.BLACK);
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(20, 76, 51, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel);

		textMarca = new JTextField();
		textMarca.setBounds(83, 74, 252, 22);
		contentPane.add(textMarca);
		textMarca.setColumns(10);

		textModelo = new JTextField();
		textModelo.setBounds(83, 103, 252, 22);
		contentPane.add(textModelo);
		textModelo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setBounds(17, 105, 54, 16);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);

		JLabel lblRegistroDePacientes = new JLabel("A\u00F1adir Nuevo Auto");
		lblRegistroDePacientes.setBounds(20, 13, 324, 39);
		lblRegistroDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDePacientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblRegistroDePacientes);
		
		final JTextField txtPlaca = new JTextField();
		((AbstractDocument) txtPlaca.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

                if (newText.matches("\\d{0,6}")) {
                    super.replace(fb, offset, length, text, attrs);
                    if (newText.length() == 11) {
                        Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
                }
            }
        });
		txtPlaca.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				  String currentText = txtPlaca.getText();
	                if (currentText.length() >= 6) {
	                    Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
	                }
			}
		});
		txtPlaca.setBounds(83, 161, 252, 22);
		contentPane.add(txtPlaca);
		
		JLabel lbldoApellido = new JLabel("Color");
		lbldoApellido.setForeground(Color.BLACK);
		lbldoApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldoApellido.setBounds(27, 134, 44, 16);
		contentPane.add(lbldoApellido);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(83, 132, 252, 22);
		contentPane.add(textColor);
		
		JLabel lblIngreseContraseaNuevamente = new JLabel("Placa");
		lblIngreseContraseaNuevamente.setForeground(Color.BLACK);
		lblIngreseContraseaNuevamente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIngreseContraseaNuevamente.setBounds(27, 163, 44, 16);
		contentPane.add(lblIngreseContraseaNuevamente);
		
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
		btnmcnCancelar.setBounds(254, 205, 81, 39);
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
		btnmcnGuardar.setBounds(20, 205, 81, 39);
		contentPane.add(btnmcnGuardar);
		
		
		
		
	}
}