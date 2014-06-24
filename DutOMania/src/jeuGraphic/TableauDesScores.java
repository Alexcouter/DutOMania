package jeuGraphic;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import JeuCode.Question;

public class TableauDesScores extends JFrame{
	private JButton Envoyer = new JButton("Envoyer");
	private static JFrame tableau;
	private static String pseudoStr;
	private static String scoreStr;
	private static String newPseudo;
	private static String newScore;
	private static int lastId;
	private static JTextArea recupPseudo = new JTextArea();
	private static DefaultTableModel model = new DefaultTableModel();
	public TableauDesScores(){
		        
		tableau = new JFrame();      
		    		
		    this.setTitle("Tableau des scores");
		    this.setSize(800, 600);
		    	
		    this.setLocationRelativeTo(null);
		    
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		  // Font f = new Font("Trackmania", Font.PLAIN, 50);
		  // this.setFont(f);
			
		    add(Envoyer, BorderLayout.SOUTH);
		    add(recupPseudo, BorderLayout.NORTH);
		   // recupPseudo.setLayout(null);
		    recupPseudo.setRows(2);
		    
		    
		    
		    
		    this.setVisible(true);
		
		    Envoyer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					recupPseudo();
					recupScore();
					affichageTableauScore();
								
					MajTableau();
				}
			});
	}
	public static void recupPseudo(){
		String textEntier = recupPseudo.getText();
		newPseudo  = textEntier;
		System.out.println("newpseudo récup");
		
	}
	public static void recupScore(){
		int scoreDuJeu = DutOManiaWindow.ecranJeuNormal.getJeu().getScore().getScore();
		newScore = Integer.toString(scoreDuJeu);
		System.out.println("newscore récup");
	}
	
	

   



	public static void MajTableau(){
		 
		
	
		
		//sauvegarde dans le xml du pseudo + score de joueur
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
		    final Document document= builder.newDocument();
		    final Element racine = document.createElement("racine");
		    document.appendChild(racine);
		    
			    final Element joueur = document.createElement("joueur");
			    racine.appendChild(joueur);
			    joueur.setAttribute("id", Integer.toString(lastId+1));
			    
			    final Element pseudo = (Element) document.createElement("pseudo");
			    pseudo.appendChild(document.createTextNode(newPseudo));
			    joueur.appendChild(pseudo);
			    System.out.println("pseudo enregistré");
			    
			    final Element score = document.createElement("score");
			    score.appendChild(document.createTextNode(newScore));
			    joueur.appendChild(score);
			    System.out.println("score enregistré");
		    
			
			
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    final Transformer transformer = transformerFactory.newTransformer();
		    final DOMSource source = new DOMSource(document);
		    final StreamResult sortie = new StreamResult(new File("src/score.xml"));
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
		    System.out.println("sortie + save");
		}
		catch (final ParserConfigurationException | TransformerException e) {
		    e.printStackTrace() ;
		    System.out.println("sa fail");
		}
	}
		
	
	
	public static void affichageTableauScore() {
		
		TextArea affichagePseudo = new TextArea(pseudoStr);
		TextArea affichageScore = new TextArea(scoreStr);
		tableau.add(affichagePseudo, BorderLayout.WEST);
		tableau.add(affichageScore, BorderLayout.EAST);
		tableau.setVisible(true);
	}
	
	public static void GestionXML(int j){
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		Question res = null;
		
		try {
			// Création d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Création d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/score.xml"));

			// Récupération de l'élément racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// Récupération de la liste des noeuds fils de joueur (depuis
			// l'élément
			// racine);
			NodeList joueurNoeuds = racine.getElementsByTagName("joueur");

			
			
			int lastId = joueurNoeuds.getLength();
			
			
			
			
			for (int i = 0; i<lastId; i++) {
			   // if(joueurNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
			    final Element joueur = (Element) joueurNoeuds.item(i);
			    
			    Element pseudo = (Element) joueur.getElementsByTagName("pseudo").item(0);
			    System.out.println("retourXML : pseudo :" + pseudo.getTextContent());
			   	pseudoStr = ("pseudo :" + pseudo.getTextContent() + "\n" + pseudoStr);
				Element score = (Element) joueur.getElementsByTagName("score").item(0);
				System.out.println("retourXML : score : " + score.getTextContent() );
				scoreStr = ("score : " + score.getTextContent()+ "\n" + scoreStr);
			   // }	
				
			

			}

			

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		
	}
	
	
	public String getPseudoStr() {
		return pseudoStr;
	}

	public void setPseudoStr(String pseudo) {
		this.pseudoStr = pseudo;
	}

	public String getScoreStr() {
		return scoreStr;
	}

	public void setScoreStr(String score) {
		this.scoreStr = score;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableauDesScores();
		
		GestionXML(1);
		
		

		    
		        
		
	}

}