package JeuCode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.Random;

public class Jeu {

	// M�thode retournant une question indentifi�e par son id
	public static Question recupererQuestion(int id) {
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
			Element theme = (Element) question.getElementsByTagName("theme")
					.item(0);

			String themeStr = theme.getTextContent();

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

	// M�thode g�n�rant un entier al�atoire inf�rieur ou �gal au nombre de
	// questions dans le XML
	public static int numeroQuestionAleatoire() {
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		int nbr = 0;
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

			// G�n�ration d'un nombre entier al�atoire compris entre 1 et le
			// nombre de noeuds fils dans le XML
			Random r = new Random();
			nbr = 1 + r.nextInt(questionNoeuds.getLength() - 1);

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return nbr;
	}

	// M�thode retournant une question al�atoire
	public static Question recupererQuestionAleatoire() {
		return recupererQuestion(numeroQuestionAleatoire());
	}

	// M�thode retournant une question al�atoire d'un th�me pr�cis
	public static Question recupererQuestionAleatoire(String theme) {
		// Initialisation de la variable contenant le r�sultat
		Question res;

		// On boucle tant que le th�me de la question ne correspond pas au th�me
		// pass� en param�tre
		do {
			res = recupererQuestionAleatoire();
		} while (!res.getTheme().equals(theme));

		return res;
	}

	public static void main(String[] args) {
		System.out.println(recupererQuestionAleatoire("Vie �tudiante"));
	}

}