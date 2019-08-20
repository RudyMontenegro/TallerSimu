
package tallersimulacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvEmpirica extends JFrame {

	private JPanel contentPane;
	private JTextField ctteadi;
	private JTextField mod;
	private JTextField sem;
	private JTextField cttemulti;
	private JTextField aleatorio;
	private JTextField numAlet;

	/**
	 * Launch the application.
	 */
	
	public  Double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvEmpirica frame = new InvEmpirica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InvEmpirica() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDistribucionEmpirica = new JLabel("Distribucion Empirica");
		lblDistribucionEmpirica.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDistribucionEmpirica.setBounds(132, 11, 173, 19);
		contentPane.add(lblDistribucionEmpirica);
		
		JLabel lblFuncionAcumulada = new JLabel("Funcion acumulada:");
		lblFuncionAcumulada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFuncionAcumulada.setBounds(23, 60, 115, 14);
		contentPane.add(lblFuncionAcumulada);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/tallersimulacion/empirico.png")));
		lblNewLabel.setBounds(142, 41, 134, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblGeneradorCongruencalMixto = new JLabel("Generador Congruencal Mixto");
		lblGeneradorCongruencalMixto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGeneradorCongruencalMixto.setBounds(27, 111, 197, 14);
		contentPane.add(lblGeneradorCongruencalMixto);
		
		JLabel a = new JLabel("a =");
		a.setFont(new Font("Tahoma", Font.PLAIN, 13));
		a.setBounds(49, 138, 46, 14);
		contentPane.add(a);
		
		ctteadi = new JTextField();
		ctteadi.setBounds(79, 136, 34, 30);
		contentPane.add(ctteadi);
		ctteadi.setColumns(10);
		
		JLabel c = new JLabel("c =");
		c.setFont(new Font("Tahoma", Font.PLAIN, 13));
		c.setBounds(208, 139, 46, 14);
		contentPane.add(c);
		
		JLabel m = new JLabel("m =");
		m.setFont(new Font("Tahoma", Font.PLAIN, 13));
		m.setBounds(49, 166, 46, 14);
		contentPane.add(m);
		
		mod = new JTextField();
		mod.setBounds(79, 163, 34, 30);
		contentPane.add(mod);
		mod.setColumns(10);
		
		JLabel lblX = new JLabel("x =");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblX.setBounds(208, 166, 46, 14);
		contentPane.add(lblX);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(237, 164, 34, 30);
		contentPane.add(sem);
		
		cttemulti = new JTextField();
		cttemulti.setColumns(10);
		cttemulti.setBounds(237, 136, 34, 30);
		contentPane.add(cttemulti);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a1,c1,x1,m1;
				double aleatorio1;
				a1=Integer.parseInt(ctteadi.getText());
				c1=Integer.parseInt(cttemulti.getText());
				x1=Integer.parseInt(sem.getText());
				m1=Integer.parseInt(mod.getText());
				double aux= (((a1 * x1) + c1) %m1);
				aleatorio1=formatearDecimales(aux/m1,3);
				aleatorio.setText(Double.toString(aleatorio1));
				
			}
		});
		btnGenerar.setBounds(60, 210, 89, 23);
		contentPane.add(btnGenerar);
		
		aleatorio = new JTextField();
		aleatorio.setBounds(168, 207, 108, 29);
		contentPane.add(aleatorio);
		aleatorio.setColumns(10);
		
		JLabel lblDistribucionEmpirica_1 = new JLabel("Distribucion Empirica");
		lblDistribucionEmpirica_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDistribucionEmpirica_1.setBounds(23, 243, 140, 19);
		contentPane.add(lblDistribucionEmpirica_1);
		
		numAlet = new JTextField();
		numAlet.setBounds(168, 264, 108, 29);
		contentPane.add(numAlet);
		numAlet.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Double r1,numAl;
				r1=Double.parseDouble(aleatorio.getText());
				if(r1<5) {
		    		numAl=formatearDecimales(Math.sqrt(2*r1),3);
		    		}else {
		    		numAl=formatearDecimales(2*r1,3);
		    		}
				numAlet.setText(Double.toString(numAl));
			}
		});
		btnCalcular.setBounds(60, 267, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctteadi.setText(null);
				cttemulti.setText(null);
				mod.setText(null);
				sem.setText(null);
				aleatorio.setText(null);
				numAlet.setText(null);
			}
		});
		btnLimpiar.setBounds(180, 316, 89, 23);
		contentPane.add(btnLimpiar);
		
		/*JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(208, 316, 89, 23);
		contentPane.add(btnSalir);*/
	}

}
