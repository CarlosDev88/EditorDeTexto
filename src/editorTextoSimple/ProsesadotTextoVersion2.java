package editorTextoSimple;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class ProsesadotTextoVersion2 {

	public static void main(String[] args) {

		new Frame2();
	}

}

class Frame2 extends JFrame {
	public Frame2() {
		this.setBounds(100, 100, 550, 400);
		this.add(new Lamina2());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class Lamina2 extends JPanel {
	private JTextPane texto;
	private JPanel LaminaMenu;
	private JMenu fuente, estilo, tamano;
	private Font letras;

	public Lamina2() {
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
			if(tipoLetra.equals("Arial")) {
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("", "Arial"));
				
			}else if(tipoLetra.equals("Courier")) {
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("", "Courier"));
				
			}else if(tipoLetra.equals("Verdana")) {
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("", "Verdana"));
			}
			
		} else if (menu.equals("estilo")) {
			estilo.add(elemento);

			if (estiloLetra == Font.ITALIC) {
				elemento.addActionListener(new StyledEditorKit.ItalicAction());

			} else if (estiloLetra == Font.BOLD) {
				elemento.addActionListener(new StyledEditorKit.BoldAction());
			}

		} else if (menu.equals("tamano")) {
			tamano.add(elemento);
			elemento.addActionListener(new StyledEditorKit.FontSizeAction("", tamanoLetra));
		}

	}

}
