package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Auxiliar.Auxiliar;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import componentesVisuales.BotonAnimacion;


public class ListaContratosYMarcas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	private JTextField textedad;

	DefaultTableModel model=new DefaultTableModel();
	private JTable table;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public ListaContratosYMarcas(final Principal p) throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1273, 539);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Lista de Contratos por Marca y Modelo");
		lblNewLabel.setBounds(392, 13, 386, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		textedad = new JTextField();
		textedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		scrollPane.setBounds(22, 50, 1239, 437);
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
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});

	
		scrollPane.setViewportView(table);
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Cantidad de carros");
		model.addColumn("Días totales alquilados");
		model.addColumn("Ingresos por tarjeta de crédito");
		model.addColumn("Ingresos por cheque");
		model.addColumn("Ingresos por efectivo");
		model.addColumn("Total de ingresos por marca");
		model.addColumn("Total de ingresos");
		table.setModel(model);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFecha.setBounds(859, 13, 216, 35);
		contentPane.add(lblFecha);
		
		LocalDate local = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = local.format(format);
		JLabel label = new JLabel(fechaFormateada);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(1045, 13, 216, 35);
		contentPane.add(label);
		
		BotonAnimacion btnmcnSalir = new BotonAnimacion();
		btnmcnSalir.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 setCursor(Cursor.getDefaultCursor());
			}
		});
		btnmcnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Auxiliar.reproducirSonidoBoton();
				p.setEnabled(true);
				dispose();
		}
		});
		btnmcnSalir.setText("Salir");
		btnmcnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmcnSalir.setBounds(1158, 490, 103, 36);
		contentPane.add(btnmcnSalir);
		
		
		DefaultTableCellRenderer t= new DefaultTableCellRenderer();
		t.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i=0; i<table.getColumnModel().getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(t);
		}


	}
}
