import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Conversor {

	private JFrame frame;
	private JButton btn;
	private JComboBox cmb1;
	private JComboBox<Moneda>cmb;
	private JLabel lbl;
	
	
	public enum Moneda{
		pesos_dolar,
		pesos_euro,
		pesos_libra,
		dolar_pesos,
		euro_pesos,
		libra_pesos
		
	}

	public double dolar = 17.06;
	public double euro = 18.71;
	public double libra = 21.70;
	
	public double valorinput = 0.00;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Conversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField txt = new JTextField();
		txt.setBounds(10, 11, 178, 32);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb1 = new JComboBox<Moneda>();
		cmb1.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb1.setBounds(10, 54, 86, 22);
		frame.getContentPane().add(cmb1);
		
		
		// Seccion del evento del Boton
		
		btn = new JButton("Convertir");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(267, 54, 89, 23);
		frame.getContentPane().add(btn);
		
		JLabel lbl = new JLabel("0.00");
		lbl.setBounds(241, 11, 104, 20);
		frame.getContentPane().add(lbl);
	}
	
	public void Convertir() {
		Moneda moneda = (Moneda)cmb1.getSelectedItem();
		
		switch (moneda) { 
		
		case pesos_dolar :
			PesosAMoneda(dolar);
			break;
			
		case pesos_euro :
			PesosAMoneda(euro);
			break;
		case pesos_libra :
			PesosAMoneda(libra);
			break;
		case dolar_pesos :
			MonedaAPesos(dolar);
			break;
		
			default:
				throw new IllegalArgumentException("Unexpected value: " +  moneda);
				
		
		
		     }
		}
	
	

		public void PesosAMoneda(double moneda) {
			double res = valorinput / moneda;
			lbl.setText(Redondear(res) ); 
			
		}
	
				
		public void MonedaAPesos(double moneda) {
			double res = valorinput * moneda;
			lbl.setText(Redondear(res));
					
				}
		
		
		public String Redondear(double valor) {
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.HALF_UP);
			return df.format(valor);
		}
		
		public boolean Validar(String texto) {
			try {
				double x = Double.parseDouble(texto);
				if (x> 0);
				valorinput = x;
				return true;
			} catch (NumberFormatException e) {
				lbl.setText("Solamente puedes ingresar números !!");
				return false; 
			}
		}
		
		
		
		
		
		
		
		
		
}
