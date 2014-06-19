package JeuCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListeQuestions {
	private ArrayList<Question> listeQuestions;

	public ListeQuestions() {
		super();
		listeQuestions = new ArrayList<Question>() ;
		for(int i = 1; i <= getNombreQuestionsXML(); i++){
			ajouterQuestion(getQuestionXML(i));
			
		}
	}
	
	public void ajouterQuestion(Question q){
		listeQuestions.add(q);
	}
	
	public int getNombreQuestions(){
		return listeQuestions.size();
	}
	
	public Question getQuestionAleatoire(){
		Random r = new Random();
		int id = 1 + r.nextInt(getNombreQuestions() - 1);
		return listeQuestions.get(id);
	}

	// M�thode retournant une question indentifi�e par son id
	public static Question getQuestionXML(int id) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		Question res = null;
		try {
			// Cr�ation d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Cr�ation d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/questions.xml"));

			// R�cup�ration de l'�l�ment racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// R�cup�ration de la liste des noeuds fils de questions (depuis
			// l'�l�ment
			// racine);
			NodeList questionNoeuds = racine.getElementsByTagName("question");

			// Recup�ration de la question situ�e au noeud pass� en param�tre

			Element question = (Element) questionNoeuds.item(id);

			// R�cup�ration de l'intitule de la question
			Element intitule = (Element) question.getElementsByTagName(
					"intitule").item(0);

			String intituleStr = intitule.getTextContent();

			// Recuperation des quatre propositions dans un tableau
			NodeList propositionsNoeuds = question
					.getElementsByTagName("proposition");

			String[] propositionsTab = new String[4];

			for (int i = 0; i < propositionsNoeuds.getLength(); i++) {
				Element proposition = (Element) question.getElementsByTagName(
						"proposition").item(i);
				propositionsTab[i] = proposition.getTextContent();
			}

			// R�cuperation de l'id de la r�ponse
			Element reponse = (Element) question
					.getElementsByTagName("reponse").item(0);

			int reponseInt = Integer.parseInt(reponse.getTextContent());

			// R�cup�ration du th�me de la question
			String themeStr = question.getAttribute("theme");

			// Cr�ation d'un objet Question avec les attributs de la question
			// d'id choisi
			res = new Question(id, intituleStr, propositionsTab, reponseInt,
					themeStr);

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return res;

	}
	
	public static int getNombreQuestionsXML(){
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		int res = 0;
		try {
			// Cr�ation d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Cr�ation d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/questions.xml"));

			// R�cup�ration de l'�l�ment racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// R�cup�ration de la liste des noeuds fils de questions (depuis
			// l'�l�ment
			// racine);
			NodeList questionNoeuds = racine.getElementsByTagName("question");
			
			res = questionNoeuds.getLength();
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
