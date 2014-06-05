package JeuCode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	protected Score score;
	
	public Jeu() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Méthode retournant une question indentifiée par son id
	public Question recupererQuestion(int id) {
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
			String themeStr = question.getAttribute("theme");

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

	// Méthode retournant une question aléatoire
	public Question recupererQuestionAleatoire() {
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

			// Génération d'un nombre entier aléatoire compris entre 1 et le
			// nombre de noeuds fils dans le XML
			Random r = new Random();
			int nbr = 1 + r.nextInt(questionNoeuds.getLength() - 1);
			res = recupererQuestion(nbr);

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return res;
	}

	// Méthode retournant une question aléatoire d'un thème précis
	public Question recupererQuestionAleatoire(String theme) {
		// Initialisation de la variable contenant le résultat
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

			// On récupère tout les numéros de question correspondant au thème
			// dans une liste
			ArrayList<Integer> questionsTheme = new ArrayList<Integer>();

			for (int i = 0; i < questionNoeuds.getLength(); i++) {
				Element question = (Element) questionNoeuds.item(i);

				if (question.getAttribute("theme").equals(theme)) {
					questionsTheme.add(Integer.parseInt(question
							.getAttribute("id")));
				}
			}

			// On récupère un numéro de question aléatoire dans la liste
			Random r = new Random();
			int nbr = 1 + r.nextInt(questionsTheme.size() - 1);
			res = recupererQuestion(questionsTheme.get(nbr));

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public int getScore(){
		return score.getScore();
	}

}