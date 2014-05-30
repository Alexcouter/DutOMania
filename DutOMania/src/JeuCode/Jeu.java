package JeuCode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.IOException;
import org.xml.sax.SAXException;

public class Jeu {

	private static Question recupererQuestion(int id) {
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

			// R�cup�ration de la liste des noeuds fils (depuis l'�l�ment
			// racine)
			NodeList racineNoeuds = racine.getChildNodes();

			// Recup�ration de la question situ�e au noeud pass� en param�tre
			Element question = (Element) racineNoeuds.item(id);

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
			Element reponse = (Element) question.getElementsByTagName(
					"reponse").item(0);
					
			int reponseInt = Integer.parseInt(reponse.getTextContent());

			// R�cup�ration du th�me de la question
			Element theme = (Element) question.getElementsByTagName("theme")
					.item(0);

			String themeStr = theme.getTextContent();

			// Cr�ation d'un objet Question avec les attributs de la question
			// d'id choisi
			res = new Question(id, intituleStr, propositionsTab, reponseInt, themeStr);

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