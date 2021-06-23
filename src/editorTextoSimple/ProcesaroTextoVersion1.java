package editorTextoSimple;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProcesaroTextoVersion1 {

	public static void main(String[] args) {
		new Frame();

	}

}

class Frame extends JFrame {
	public Frame() {
		this.setBounds(100, 100, 550, 400);
		this.add(new Lamina());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class Lamina extends JPanel {
	private JTextPane texto;
	private JPanel LaminaMenu;
	private JMenu fuente, estilo, tamano;
	private Font letras;

	public Lamina() {
		this.setLayout(new BorderLayout());
		LaminaMenu = new JPanel();

		JMenuBar barraMenu = new JMenuBar();

		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilos");
		tamano = new JMenu("Tamaño");

		this.configuraMenu("Arial", "fuente", "Arial", 9, 10);
		this.configuraMenu("Courier", "fuente", "Courier", 9, 10);
		this.configuraMenu("Verdana", "fuente", "Verdana", 9, 10);

		this.configuraMenu("Negrita", "estilo", "", Font.BOLD, 0);
		this.configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 0);

		this.configuraMenu("10", "tamano", "", 9, 10);
		this.configuraMenu("14", "tamano", "", 9, 14);
		this.configuraMenu("18", "tamano", "", 9, 18);
		this.configuraMenu("22", "tamano", "", 9, 22);

		barraMenu.add(fuente);
		barraMenu.add(estilo);
		barraMenu.add(tamano);

		LaminaMenu.add(barraMenu);

		this.add(LaminaMenu, BorderLayout.NORTH);

		texto = new JTextPane();
		this.add(texto, BorderLayout.CENTER);
	}

	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estiloLetra, int tamanoLetra) {

		JMenuItem elemento = new JMenuItem(rotulo);

		if (menu.equals("fuente")) {
			fuente.add(elemento);
		} else if (menu.equals("estilo")) {
			estilo.add(elemento);

		} else if (menu.equals("tamano")) {
			tamano.add(elemento);
		}

		elemento.addActionListener(new GestionaEventos(rotulo, tipoLetra, estiloLetra, tamanoLetra));
	}

	private class GestionaEventos implements ActionListener {
		String tipoTexto, menu;
		int tamanoLetra, estiloLetra;

		public GestionaEventos(String elemnto, String texto2, int estilo, int tamano) {
			this.tipoTexto = texto2;
			this.tamanoLetra = tamano;
			this.estiloLetra = estilo;
			this.menu = elemnto;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			letras = texto.getFont();
			if (menu.equals("Arial") || menu.equals("Courier") || menu.equals("Verdana")) {
				estiloLetra = letras.getStyle();
				tamanoLetra = letras.getSize();

			} else if (menu.equals("Negrita") || menu.equals("Cursiva")) {
				if (letras.getStyle() == 1 || letras.getStyle() == 2) {
					estiloLetra = 3;
				}
				tipoTexto = letras.getFontName();
				tamanoLetra = letras.getSize();

			} else if (menu.equals("10") || menu.equals("14") || menu.equals("18") || menu.equals("22")) {
				estiloLetra = letras.getStyle();
				tipoTexto = letras.getFontName();
			}
			texto.setFont(new Font(tipoTexto, estiloLetra, tamanoLetra));

		}

	}

}
