/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class InvExponencial extends JFrame {

	private JPanel contentPane;
	private JTextField lambda;
	private JTextField aleatorio;
	private JTextField aleatExp;

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
					InvExponencial frame = new InvExponencial();
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
	public InvExponencial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDistribucionExponencial = new JLabel("Distribucion Exponencial");
		lblDistribucionExponencial.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDistribucionExponencial.setBounds(114, 11, 226, 14);
		contentPane.add(lblDistribucionExponencial);
		
		JLabel lblFuncionAcumulada = new JLabel("Funcion Acumulada :");
		lblFuncionAcumulada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFuncionAcumulada.setBounds(23, 51, 128, 20);
		contentPane.add(lblFuncionAcumulada);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Carlos\\Pictures\\webcast\\exp.PNG"));
		lblNewLabel.setBounds(161, 36, 128, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblLambda = new JLabel("Lambda =");
		lblLambda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLambda.setBounds(23, 116, 58, 20);
		contentPane.add(lblLambda);
		
		lambda = new JTextField();
		lambda.setBounds(130, 114, 99, 23);
		contentPane.add(lambda);
		lambda.setColumns(10);
		
		JLabel lblNmeroPseudoaleatorio = new JLabel("Pseudoaleatorio =");
		lblNmeroPseudoaleatorio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmeroPseudoaleatorio.setBounds(23, 164, 112, 20);
		contentPane.add(lblNmeroPseudoaleatorio);
		
		aleatorio = new JTextField();
		aleatorio.setBounds(130, 162, 99, 23);
		contentPane.add(aleatorio);
		aleatorio.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double random=formatearDecimales((double)Math.random(),2);	
				aleatorio.setText(Double.toString(random)); 
			}
		});
		btnGenerar.setBounds(265, 164, 99, 23);
		contentPane.add(btnGenerar);
		
		JLabel lblResultado = new JLabel("Resultado =");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResultado.setBounds(23, 211, 74, 20);
		contentPane.add(lblResultado);
		
		aleatExp = new JTextField();
		aleatExp.setBounds(130, 211, 99, 21);
		contentPane.add(aleatExp);
		aleatExp.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lambda1;
				double r1,numAl;
				lambda1=Integer.parseInt(lambda.getText());
				r1=Double.parseDouble(aleatorio.getText());
				numAl=formatearDecimales(((Math.log(r1)/lambda1) * (-1)), 3);
				aleatExp.setText(Double.toString(numAl));
				
			}
		});
		btnCalcular.setBounds(265, 211, 99, 23);
		contentPane.add(btnCalcular);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lambda.setText(null);
				aleatorio.setText(null);
				aleatExp.setText(null);
			}
		});
		btnLimpiar.setBounds(77, 267, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(230, 267, 89, 23);
		contentPane.add(btnSalir);
	}

}
