package Interface;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import Auxiliar.Auxiliar;


public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private float alpha = 0.0f;
	private Image imagen1;
	private Image imagen2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Principal() {
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Software Rent-Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 614);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.requestFocus();
		
		if(Auxiliar.login==true){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.decode("#8CB9E2"));
		
		if(Auxiliar.admin==true){
		JMenu mnRegistro = new JMenu("Registro");
		mnRegistro.setForeground(new Color(0, 0, 0));
		mnRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(mnRegistro);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Auto");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnyadirAuto pa = null;
				try {
					pa = new AnyadirAuto(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pa.setVisible(true);
			}
		});
		mnRegistro.add(mntmNewMenuItem);
		
		JMenuItem mntmRegistrarConductor = new JMenuItem("Registrar Chofer");
		mntmRegistrarConductor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnyadirConductor a = null;
				try {
					a = new AnyadirConductor(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmRegistrarConductor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnRegistro.add(mntmRegistrarConductor);
		
		JMenuItem mntmEliminarAuto = new JMenuItem("Eliminar Auto");
		mntmEliminarAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarAuto a = null;
				try {
					a = new EliminarAuto(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmEliminarAuto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnRegistro.add(mntmEliminarAuto);
		
		JMenuItem mntmEliminarConductor = new JMenuItem("Eliminar Chofer");
		mntmEliminarConductor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarConductor a = null;
				try {
					a = new EliminarConductor(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmEliminarConductor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnRegistro.add(mntmEliminarConductor);
		}
		
		JMenu mnConsulta = new JMenu("Contrato");
		mnConsulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		mnConsulta.setForeground(new Color(0, 0, 0));
		menuBar.add(mnConsulta);
		
		JMenuItem mntmHojaDeCargo = new JMenuItem("Crear Contrato");
		mntmHojaDeCargo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmHojaDeCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearContrato c = null;
				try {
					c = new CrearContrato(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setVisible(true);
			}
		});
		mnConsulta.add(mntmHojaDeCargo);
		
		JMenuItem mntmEliminarContrato = new JMenuItem("Eliminar Contrato");
		mntmEliminarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarContrato e = null;
				try {
					e = new EliminarContrato(Principal.this);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.setVisible(true);
			}
		});
		mntmEliminarContrato.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnConsulta.add(mntmEliminarContrato);
		

		JMenu mnReportes = new JMenu("Consultas");
		mnReportes.setForeground(Color.BLACK);
		mnReportes.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(mnReportes);
		
		JMenuItem mntmReportes = new JMenuItem("Listado de turistas");
		mntmReportes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoDeTuristas a = null;
				try {
					a = new ListadoDeTuristas(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mnReportes.add(mntmReportes);
		
		JMenuItem mntmFuncionalidades = new JMenuItem("Listado de autos");
		mntmFuncionalidades.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoDeAutos a = null;
				try {
					a = new ListadoDeAutos(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mnReportes.add(mntmFuncionalidades);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de contratos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoDeContratos a = null;
				try {
					a = new ListadoDeContratos(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmNewMenuItem_1);
		
		JMenuItem mntmListadoDeChoferes = new JMenuItem("Listado de choferes");
		mntmListadoDeChoferes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoDeChoferes a = null;
				try {
					a = new ListadoDeChoferes(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmListadoDeChoferes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmListadoDeChoferes);
		
		JMenuItem mntmListadoDeSituacin = new JMenuItem("Listado de situaci\u00F3n de autos");
		mntmListadoDeSituacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoDeSituacionAutos a = null;
				try {
					a = new ListadoDeSituacionAutos(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmListadoDeSituacin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmListadoDeSituacin);
		
		JMenuItem mntmListadoDeTuristas = new JMenuItem("Listado de turistas incumplidores del contrato");
		mntmListadoDeTuristas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoTuristasIncumplidores a = null;
				try {
					a = new ListadoTuristasIncumplidores(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmListadoDeTuristas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmListadoDeTuristas);
		
		JMenuItem mntmListadoDeContratos = new JMenuItem("Listado de contratos por marca y modelos");
		mntmListadoDeContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaContratosYMarcas a = null;
				try {
					a = new ListaContratosYMarcas(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmListadoDeContratos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmListadoDeContratos);
		
		JMenuItem mntmListadoDeContratos_1 = new JMenuItem("Listado de contratos por pa\u00EDses");
		mntmListadoDeContratos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaContratosPorPaises a = null;
				try {
					a = new ListaContratosPorPaises(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmListadoDeContratos_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmListadoDeContratos_1);
		
		JMenuItem mntmListadoDeIngresos = new JMenuItem("Listado de ingresos del a\u00F1o");
		mntmListadoDeIngresos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaIngresosDelAno a = null;
				try {
					a = new ListaIngresosDelAno(Principal.this);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a.setVisible(true);
			}
		});
		mntmListadoDeIngresos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mntmListadoDeIngresos);
		
		JMenu mnSistema = new JMenu("Salir");
		mnSistema.setForeground(new Color(0, 0, 0));
		mnSistema.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(mnSistema);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		mntmCerrarSesin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnSistema.add(mntmCerrarSesin);
		mnSistema.add(mntmSalir);
		}
		
		imagen1 = Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/fotor-ai-20231205234311.jpg"));
        imagen2 = Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/OIG.xWwsUYnKOBJaZNj04.jpg"));
		contentPane = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g){
				super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
                g2d.drawImage(imagen1, 0, 0, getWidth(), getHeight(), this);
                g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f - alpha));
                g2d.drawImage(imagen2, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
			}

		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

        // Configura temporizador para la transición
		Timer timer = new Timer(30, new ActionListener() {
			 private int tiempoDeEspera = 150; // 150 * 30ms = 4500ms (4.5 segundos)

			    public void actionPerformed(ActionEvent e) {
			        if (tiempoDeEspera > 0) {
			            tiempoDeEspera--;
			        } else {
			            alpha += 0.02f; // Ajusta este valor para cambiar la velocidad de la transición

			            if (alpha > 1.0f) {
			                alpha = 0.0f;
			                // Cambia las imágenes cuando se alcanza el final de la transición
			                Image temp = imagen1;
			                imagen1 = imagen2;
			                imagen2 = temp;
			                tiempoDeEspera = 150; // Reinicia el tiempo de espera para la siguiente imagen
			            }
			        }

			        contentPane.repaint();
			    }
        });
        timer.start();
		
	
	}
}
