package fastTextContent;
import fastTextContent.Cache;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import fastTextContent.MiThread;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textBuscador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fast Text Content", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textBuscador = new JTextField();
		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				getRequest getHTML = new getRequest();
				String[] wordsList = textBuscador.getText().split(" ");
				Cache memory = Cache.getCache();
				for (int index = 0; index < wordsList.length; index++){
					if (memory.searchHTML(wordsList[index]) != null){
						//Mostrar en la pantalla
					}
					else{
						try {
							memory.insertHTML(wordsList[index], getHTML.sendGet(wordsList[index]).toString());
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						MiThread nuevoHilo = new MiThread(wordsList[index]);
						nuevoHilo.run();
					}
				}
			}
		});
		panel.add(btnSearch);
		
		JPanel panel_Pantallas = new JPanel();
		contentPane.add(panel_Pantallas, BorderLayout.CENTER);
	}

}
