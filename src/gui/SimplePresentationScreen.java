package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import java.time.*;
import java.time.format.*; 

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblLU;
	private JTextField textField_LU;
	private JTextField textField_Apellido;
	private JTextField textField_Nombre;
	private JTextField textField_Mail;
	private JTextField textField_URL;
	private JLabel lblFecha;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		//Labels
		lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLU.setBounds(8, 10, 58, 21);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(8, 41, 58, 21);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(8, 72, 58, 21);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(8, 103, 58, 21);
		tabInformation.add(lblEmail);
		
		JLabel lblGithub = new JLabel("GitHub URL");
		lblGithub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGithub.setBounds(8, 134, 68, 21);
		tabInformation.add(lblGithub);
		//Cuadros de texto
		textField_LU = new JTextField();
		textField_LU.setBounds(84, 12, 333, 19);
		textField_LU.setText(String.valueOf(studentData.getId()));
		tabInformation.add(textField_LU);
		textField_LU.setColumns(10);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setBounds(84, 43, 333, 19);
		textField_Apellido.setText(studentData.getLastName());
		tabInformation.add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(84, 74, 333, 19);
		textField_Nombre.setText(studentData.getFirstName());
		tabInformation.add(textField_Nombre);
		
		textField_Mail = new JTextField();
		textField_Mail.setColumns(10);
		textField_Mail.setBounds(84, 105, 333, 19);
		textField_Mail.setText(studentData.getMail());
		tabInformation.add(textField_Mail);
		
		textField_URL = new JTextField();
		textField_URL.setColumns(10);
		textField_URL.setBounds(84, 136, 333, 19);
		textField_URL.setText(studentData.getGithubURL());
		tabInformation.add(textField_URL);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		//Label de la foto
		JLabel lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(studentData.getPathPhoto())).getImage().getScaledInstance(155, 140, Image.SCALE_SMOOTH)));
		contentPane.add(lblFoto, BorderLayout.EAST);
		//Label de la fecha
		lblFecha = new JLabel("");
		DateTimeFormatter fTime = DateTimeFormatter.ofPattern("h':'mm':'s");
		DateTimeFormatter fDate = DateTimeFormatter.ofPattern("d'/'MM'/'YY");
		lblFecha.setText("Esta ventana fue generada el "+String.valueOf(LocalDate.now().format(fDate))+" a las: "+String.valueOf(LocalTime.now().format(fTime)));
		contentPane.add(lblFecha, BorderLayout.SOUTH);
	}
}
