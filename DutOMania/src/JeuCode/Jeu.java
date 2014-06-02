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

	// Méthode retournant une question indentifiée par son id
	public static Question recupererQuestion(int id) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		Question res = null;
		try {
			// Création d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Création d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/questions.xml"));

			// Récupération de l'élément racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// Récupération de la liste des noeuds fils de questions (depuis
			// l'élément
			// racine);
			NodeList questionNoeuds = racine.getElementsByTagName("question");

			// Recupération de la question située au noeud passé en paramètre

			Element question = (Element) questionNoeuds.item(id);

			// Récupération de l'intitule de la question
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

			// Récuperation de l'id de la réponse
			Element reponse = (Element) question
					.getElementsByTagName("reponse").item(0);

			int reponseInt = Integer.parseInt(reponse.getTextContent());

			// Récupération du thème de la question
			Element theme = (Element) question.getElementsByTagName("theme")
					.item(0);

			String themeStr = theme.getTextContent();

			// Création d'un objet Question avec les attributs de la question
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

	// Méthode générant un entier aléatoire inférieur ou égal au nombre de
	// questions dans le XML
	public static int numeroQuestionAleatoire() {
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		int nbr = 0;
		try {
			// Création d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Création d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/questions.xml"));

			// Récupération de l'élément racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// Récupération de la liste des noeuds fils de questions (depuis
			// l'élément
			// racine);
			NodeList questionNoeuds = racine.getElementsByTagName("question");

			// Génération d'un nombre entier aléatoire compris entre 1 et le
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

	// Méthode retournant une question aléatoire
	public static Question recupererQuestionAleatoire() {
		return recupererQuestion(numeroQuestionAleatoire());
	}

	// Méthode retournant une question aléatoire d'un thème précis
	public static Question recupererQuestionAleatoire(String theme) {
		// Initialisation de la variable contenant le résultat
		Question res;

		// On boucle tant que le thème de la question ne correspond pas au thème
		// passé en paramètre
		do {
			res = recupererQuestionAleatoire();
		} while (!res.getTheme().equals(theme));

		return res;
	}

	public static void main(String[] args) {
		System.out.println(recupererQuestionAleatoire("Vie étudiante"));
	}

}