/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersimulacion;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class InvUniforme extends JFrame {

	private JPanel contentPane;
	private JTextField a;
	private JTextField b;
	private JTextField aleatorio;
	private JTextField AleatorioUnif;

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
					InvUniforme frame = new InvUniforme();
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
	public InvUniforme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMetodoDeTransformacion = new JLabel("Distribucion Uniforme");
		lblMetodoDeTransformacion.setBounds(181, 5, 164, 22);
		lblMetodoDeTransformacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblFuncionAcumulada = new JLabel("Funcion Acumulada:");
		lblFuncionAcumulada.setBounds(27, 46, 116, 16);
		lblFuncionAcumulada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel FormulaUnif = new JLabel("x=a+(b-a)R");
		FormulaUnif.setBounds(161, 38, 123, 29);
		FormulaUnif.setForeground(Color.BLACK);
		FormulaUnif.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblValorA = new JLabel("Valor a = ");
		lblValorA.setBounds(15, 79, 58, 16);
		lblValorA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		a = new JTextField();
		a.setBounds(77, 78, 88, 20);
		a.setColumns(10);
		
		JLabel lblValorB = new JLabel("Valor b =");
		lblValorB.setBounds(15, 117, 54, 16);
		lblValorB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		b = new JTextField();
		b.setBounds(79, 116, 86, 20);
		b.setColumns(10);
		
		JLabel lblNumeroPseudoalea = new JLabel("Numero Pseudoaleatorio=");
		lblNumeroPseudoalea.setBounds(16, 156, 149, 16);
		lblNumeroPseudoalea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		aleatorio = new JTextField();
		aleatorio.setBounds(181, 155, 86, 20);
		aleatorio.setColumns(10);
		
		JButton btnGenrarNumero = new JButton("Generar Numero");
		btnGenrarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double random=formatearDecimales((double)Math.random(),2);
				
				aleatorio.setText(Double.toString(random));
				
			}
			
		});
		btnGenrarNumero.setBounds(319, 154, 111, 23);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a1,b1;
				double r1,numAl;
				a1=Integer.parseInt(a.getText());
				b1=Integer.parseInt(b.getText());
				r1=Double.parseDouble(aleatorio.getText());
				numAl=formatearDecimales((a1+(b1-a1)*r1),2);
				AleatorioUnif.setText(Double.toString(numAl));
			}
		});
		btnCalcular.setBounds(27, 219, 89, 23);
		
		AleatorioUnif = new JTextField();
		AleatorioUnif.setBounds(229, 215, 86, 31);
		AleatorioUnif.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado=");
		lblResultado.setBounds(144, 221, 65, 16);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setLayout(null);
		contentPane.add(lblMetodoDeTransformacion);
		contentPane.add(lblFuncionAcumulada);
		contentPane.add(FormulaUnif);
		contentPane.add(lblValorB);
		contentPane.add(b);
		contentPane.add(lblValorA);
		contentPane.add(a);
		contentPane.add(lblNumeroPseudoalea);
		contentPane.add(btnCalcular);
		contentPane.add(lblResultado);
		contentPane.add(aleatorio);
		contentPane.add(btnGenrarNumero);
		contentPane.add(AleatorioUnif);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			a.setText(null);
			b.setText(null);
			aleatorio.setText(null);
			AleatorioUnif.setText(null);
			}
		});
		btnLimpiar.setBounds(97, 281, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(279, 281, 89, 23);
		contentPane.add(btnSalir);
	}
}
