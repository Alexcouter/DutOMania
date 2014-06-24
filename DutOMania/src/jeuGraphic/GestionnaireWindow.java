package jeuGraphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import JeuCode.ListeQuestions;
import JeuCode.Question;

public class GestionnaireWindow extends JFrame {
	// private MainPanelGestionnaire ecranPrincipal;
	private JButton boutonAjouter;
	private JButton boutonEnregistrer;
	private JButton boutonSupprimer;
	private JPanel panelBoutons;
	private JTable listeQuestions;
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane panelTableau;
	private ListeQuestions questions;

	public GestionnaireWindow() {
		super("Gestionnaire de questions");
		setSize(1500, 800);

		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setLocationRelativeTo(null);
		setResizable(true);
		
		questions = new ListeQuestions();
		String[] nomsColonnes = {"Intitulé", "Proposition 1",
				"Proposition 2", "Proposition 3", "Proposition 4", "Réponse",
				"Thème" };
		model.setColumnIdentifiers(nomsColonnes);
		listeQuestions = new JTable();
		listeQuestions.setModel(model);
		
		for(int i = 0; i < questions.getNombreQuestions(); i++){
			Question q = questions.getQuestion(i);
			Object[] o = new Object[7];
			o[0] = q.getIntituleQuestion();
			o[1] = q.getProposition(1);
			o[2] = q.getProposition(2);
			o[3] = q.getProposition(3);
			o[4] = q.getProposition(4);
			o[5] = q.getReponse();
			o[6] = q.getTheme();
			model.addRow(o);
		}
		
		panelTableau = new JScrollPane(listeQuestions);
		listeQuestions.setFillsViewportHeight(true);

		add(panelTableau, BorderLayout.CENTER);

		panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout());

		boutonAjouter = new JButton("Ajouter une question");
		boutonAjouter.setBackground(Color.LIGHT_GRAY);
		
		boutonEnregistrer = new JButton("Enregistrer");
		boutonEnregistrer.setBackground(Color.LIGHT_GRAY);
		
		boutonSupprimer = new JButton("Supprimer");
		boutonSupprimer.setBackground(Color.LIGHT_GRAY);
		
		boutonAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] o = new Object[7];
				model.addRow(o);				
			}
		});
		
		boutonSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] tab = listeQuestions.getSelectedRows();
				System.out.println(tab[0]+" "+tab[tab.length-1]);
				listeQuestions.removeRowSelectionInterval(tab[0], tab[tab.length-1]);
				
				for(int i=0;i<tab.length;i++){
				     model.removeRow(tab[i]-i);
				   }
				
			}
		});
		
		boutonEnregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][] tab = new String[listeQuestions.getRowCount()][7];
				for (int ligne = 0; ligne < model.getRowCount(); ligne++){
					for (int colonne = 0; colonne < 7; colonne++){
						tab[ligne][colonne] = listeQuestions.getModel().getValueAt(ligne, colonne).toString();
					}
				}
				
				final DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				try {
					final DocumentBuilder builder = factory.newDocumentBuilder();
				    final Document document= builder.newDocument();
				    final Element racine = document.createElement("racine");
				    document.appendChild(racine);
					for (int ligne = 0; ligne < model.getRowCount(); ligne++){
					    final Element question = document.createElement("question");
					    racine.appendChild(question);
					    question.setAttribute("id", Integer.toString(ligne+1));
					    question.setAttribute("theme", tab[ligne][6]);
					    final Element intitule = (Element) document.createElement("intitule");
					    intitule.appendChild(document.createTextNode(tab[ligne][0]));
					    question.appendChild(intitule);
					    final Element proposition1 = document.createElement("proposition");
					    proposition1.appendChild(document.createTextNode(tab[ligne][1]));
					    question.appendChild(proposition1);
					    final Element proposition2 = document.createElement("proposition");
					    proposition2.appendChild(document.createTextNode(tab[ligne][2]));
					    question.appendChild(proposition2);
					    final Element proposition3 = document.createElement("proposition");
					    proposition3.appendChild(document.createTextNode(tab[ligne][3]));
					    question.appendChild(proposition3);
					    final Element proposition4 = document.createElement("proposition");
					    proposition4.appendChild(document.createTextNode(tab[ligne][4]));
					    question.appendChild(proposition4);
					    final Element reponse = document.createElement("reponse");
					    reponse.appendChild(document.createTextNode(tab[ligne][5]));
					    question.appendChild(reponse);
					}
					
					final TransformerFactory transformerFactory = TransformerFactory.newInstance();
				    final Transformer transformer = transformerFactory.newTransformer();
				    final DOMSource source = new DOMSource(document);
				    final StreamResult sortie = new StreamResult(new File("questions.xml"));
				    //final StreamResult result = new StreamResult(System.out);
						
				    //prologue
				    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
				    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
				    		
				    //formatage
				    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
						
				    //sortie
				    transformer.transform(source, sortie);
				}
				catch (final ParserConfigurationException | TransformerException e) {
				    e.printStackTrace();
				}
			}
		});

		panelBoutons.add(boutonAjouter);
		panelBoutons.add(boutonEnregistrer);
		panelBoutons.add(boutonSupprimer);

		add(panelBoutons, BorderLayout.SOUTH);

		setVisible(true);
	}

}
