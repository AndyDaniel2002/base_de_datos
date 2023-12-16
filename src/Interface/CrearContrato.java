package Interface;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;

import Auxiliar.Auxiliar;

import com.toedter.calendar.JDateChooser;

import componentesVisuales.BotonAnimacion;



public class CrearContrato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrimerApellido;
	private JTable table;

	DefaultTableModel model=new DefaultTableModel();
	private JTextField textSegundoApellido;
	private JTextField textPasaporte;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textKM;
	private JTextField textChoferNombre;
	private JTextField textChoferCI;
	private JTextField textImporteTotal;
	private JTextField textPlaca;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CrearContrato(final Principal p) throws ParseException {
		setFont(new Font("Arial Black", Font.BOLD, 12));
		setForeground(Color.BLACK);
		setTitle("Agregar nuevo paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 908);
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
		lblNewLabel.setBounds(156, 89, 59, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if((int)arg0.getKeyChar()>=48 && (int)arg0.getKeyChar()<=57){
					JOptionPane.showMessageDialog(contentPane, "El nombre no puede contener números");
					arg0.consume();
					textNombre.setText("");
				}
			}
		});
		textNombre.setBounds(227, 87, 252, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textPrimerApellido = new JTextField();
		textPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPrimerApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if((int)arg0.getKeyChar()>=48 && (int)arg0.getKeyChar()<=57){
					JOptionPane.showMessageDialog(contentPane, "El primer apellido no puede contener números");
					arg0.consume();
					textPrimerApellido.setText("");
				}
			}
		});
		textPrimerApellido.setBounds(227, 122, 252, 22);
		contentPane.add(textPrimerApellido);
		textPrimerApellido.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("1er Apellido");
		lblNewLabel_2.setBounds(125, 124, 97, 16);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("Auto");
		lblNewLabel_5.setBounds(231, 330, 59, 16);
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Sexo");
		lblNewLabel_7.setBounds(180, 219, 45, 16);
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_7);

		

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(180, 254, 36, 16);
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblEdad);

		JLabel lblCrearContrato = new JLabel("Crear Contrato");
		lblCrearContrato.setBounds(180, 13, 158, 39);
		lblCrearContrato.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrearContrato.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblCrearContrato);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(506, 72, 703, 724);
		contentPane.add(scrollPane);
		
		table = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int getX,int getY){
				return false;
			}
		};
		model.addColumn("Placa");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Cant km");
		table.setModel(model);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer t= new DefaultTableCellRenderer();
		t.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i=0; i<table.getColumnModel().getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(t);
		}
		
		
		final JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		comboBoxSexo.setBounds(227, 217, 252, 22);
		contentPane.add(comboBoxSexo);
		
		JLabel lbldoApellido = new JLabel("2do Apellido");
		lbldoApellido.setForeground(Color.BLACK);
		lbldoApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldoApellido.setBounds(125, 157, 97, 16);
		contentPane.add(lbldoApellido);
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		textSegundoApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if((int)arg0.getKeyChar()>=48 && (int)arg0.getKeyChar()<=57){
					JOptionPane.showMessageDialog(contentPane, "El segundo apellido no puede contener números");
					arg0.consume();
					textPrimerApellido.setText("");
				}
			}
		});
		textSegundoApellido.setColumns(10);
		textSegundoApellido.setBounds(227, 155, 252, 22);
		contentPane.add(textSegundoApellido);
		
		JLabel lblDireccin = new JLabel("Pasaporte");
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccin.setBounds(146, 190, 76, 16);
		contentPane.add(lblDireccin);
		
		textPasaporte = new JTextField();
		textPasaporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPasaporte.setColumns(10);
		((AbstractDocument) textPasaporte.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                int futureLength = currentText.length() - length + text.length();
                if (futureLength <= 10) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
                }
            }
        });
		textPasaporte.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				  String currentText = textPasaporte.getText();
	                if (currentText.length() >= 10) {
	                    Toolkit.getDefaultToolkit().beep(); // Reproducir el sonido de Windows
	                }
			}
		});
		textPasaporte.setBounds(227, 188, 252, 22);
		contentPane.add(textPasaporte);
		
		JLabel lblAutosDisponibles = new JLabel("Autos Disponibles");
		lblAutosDisponibles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutosDisponibles.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAutosDisponibles.setBounds(763, 13, 190, 39);
		contentPane.add(lblAutosDisponibles);
		
		JLabel lblTurista = new JLabel("Turista");
		lblTurista.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTurista.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTurista.setBounds(231, 49, 59, 39);
		contentPane.add(lblTurista);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(169, 351, 46, 16);
		contentPane.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		textMarca.setColumns(10);
		textMarca.setBounds(227, 349, 252, 22);
		contentPane.add(textMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModelo.setBounds(156, 382, 59, 16);
		contentPane.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		textModelo.setColumns(10);
		textModelo.setBounds(227, 380, 252, 22);
		contentPane.add(textModelo);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setForeground(Color.BLACK);
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKm.setBounds(186, 413, 29, 16);
		contentPane.add(lblKm);
		
		textKM = new JTextField();
		textKM.setEditable(false);
		textKM.setFont(new Font("Tahoma", Font.BOLD, 13));
		textKM.setColumns(10);
		textKM.setBounds(227, 411, 252, 22);
		contentPane.add(textKM);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setModel(new SpinnerNumberModel(18, 18, 65, 1));
		spinnerEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		spinnerEdad.setBounds(227, 252, 255, 22);
		contentPane.add(spinnerEdad);
		
		JLabel lblChofer = new JLabel("Chofer");
		lblChofer.setForeground(Color.BLACK);
		lblChofer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChofer.setBounds(209, 477, 59, 16);
		contentPane.add(lblChofer);
		
		JLabel label = new JLabel("Nombre");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(156, 519, 59, 16);
		contentPane.add(label);
		
		textChoferNombre = new JTextField();
		textChoferNombre.setEnabled(false);
		textChoferNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		textChoferNombre.setColumns(10);
		textChoferNombre.setBounds(227, 517, 252, 22);
		contentPane.add(textChoferNombre);
		
		JButton btnAsignarChofer = new JButton("Asignar Chofer");
		btnAsignarChofer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAsignarChofer.setBounds(156, 587, 129, 39);
		contentPane.add(btnAsignarChofer);
		
		JLabel lblPago = new JLabel("Pago");
		lblPago.setForeground(Color.BLACK);
		lblPago.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPago.setBounds(197, 712, 59, 20);
		contentPane.add(lblPago);
		
		JLabel lblCi = new JLabel("CI");
		lblCi.setForeground(Color.BLACK);
		lblCi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCi.setBounds(186, 558, 29, 16);
		contentPane.add(lblCi);
		
		textChoferCI = new JTextField();
		textChoferCI.setFont(new Font("Tahoma", Font.BOLD, 13));
		textChoferCI.setEnabled(false);
		textChoferCI.setColumns(10);
		textChoferCI.setBounds(227, 556, 252, 22);
		contentPane.add(textChoferCI);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago");
		lblTipoDePago.setForeground(Color.BLACK);
		lblTipoDePago.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipoDePago.setBounds(118, 745, 97, 16);
		contentPane.add(lblTipoDePago);
		
		JComboBox comboBoxTipoPago = new JComboBox();
		comboBoxTipoPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Cr\u00E9dito", "Cheque", "Efectivo"}));
		comboBoxTipoPago.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxTipoPago.setBounds(227, 743, 252, 22);
		contentPane.add(comboBoxTipoPago);
		
		JLabel lblImporteTotal = new JLabel("Importe total");
		lblImporteTotal.setForeground(Color.BLACK);
		lblImporteTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImporteTotal.setBounds(116, 776, 99, 16);
		contentPane.add(lblImporteTotal);
		
		textImporteTotal = new JTextField();
		textImporteTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		textImporteTotal.setEnabled(false);
		textImporteTotal.setColumns(10);
		textImporteTotal.setBounds(227, 774, 252, 22);
		contentPane.add(textImporteTotal);
		
		JLabel lblFechaFinal = new JLabel("Fecha final");
		lblFechaFinal.setForeground(Color.BLACK);
		lblFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechaFinal.setBounds(128, 664, 87, 16);
		contentPane.add(lblFechaFinal);
		
		JDateChooser dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####",'_');
		dateChooser.setBounds(227, 658, 252, 22);
		LocalDate local = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = local.format(format);
		Date fecha1 = null;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	    formatoFecha.setLenient(false);
	    try{
	    	fecha1=(Date) formatoFecha.parse(fechaFormateada);
	    }
	    catch(ParseException e) {
	        
	    }
	    dateChooser.setMinSelectableDate(fecha1);
		contentPane.add(dateChooser);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setForeground(Color.BLACK);
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlaca.setBounds(170, 444, 45, 16);
		contentPane.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setEditable(false);
		textPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPlaca.setColumns(10);
		textPlaca.setBounds(227, 442, 252, 22);
		contentPane.add(textPlaca);
		
		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setForeground(Color.BLACK);
		lblPas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPas.setBounds(179, 285, 36, 16);
		contentPane.add(lblPas);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBounds(227, 283, 252, 22);
		contentPane.add(textField);
		
		BotonAnimacion btnmcnCrear = new BotonAnimacion();
		btnmcnCrear.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnCrear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmcnCrear.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnCrear.setText("Crear");
		btnmcnCrear.setBounds(118, 809, 90, 53);
		btnmcnCrear.setEnabled(false);
		contentPane.add(btnmcnCrear);
		
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
		btnmcnCancelar.setText("Cancelar");
		btnmcnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmcnCancelar.setBounds(1119, 809, 90, 53);
		contentPane.add(btnmcnCancelar);
		
		
	}
}
