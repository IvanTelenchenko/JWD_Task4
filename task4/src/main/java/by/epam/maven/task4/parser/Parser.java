package by.epam.maven.task4.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import by.epam.maven.task4.entity.PartOfText;
import by.epam.maven.task4.entity.imp.CodeBlock;
import by.epam.maven.task4.entity.imp.PunctuationMark;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.TypeOfPartOfText;
import by.epam.maven.task4.entity.imp.Word;

public class Parser {

	public Text parser(File file) throws FileNotFoundException, IOException {

		Text text = parserFileInObject(file);

		return text;
	}

	public static Text parserFileInObject(File file) throws FileNotFoundException, IOException {

		Text text = new Text();

		String fileInString = readfileInString(file);

		List<String> list = splitTextIntoPartsOfText(fileInString);

		for (String str : list) {
			if (!Pattern.compile(TypeOfPartOfText.SENTENCE).matcher(str).find()) {
				text.addPartOfText(new CodeBlock(str));
			} else {
				text.addPartOfText(createArrayOfSentenceFromString(str.replaceFirst(" ", "")));
			}
		}
		return text;
	}

	public static String readfileInString(File file) throws FileNotFoundException, IOException {

		StringBuilder buffer = new StringBuilder();
		String text;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line;

			while ((line = br.readLine()) != null) {
				buffer.append(line).append("\n");
			}
		}
		text = buffer.toString();
		text = text.replaceAll("\\t", " ");

		return text;
	}

	public static ArrayList<String> splitTextIntoPartsOfText(String text) {

		ArrayList<String> list = new ArrayList<String>();

		String[] arr;

		arr = text.split(TypeOfPartOfText.CODE_BLOCK);

		Collections.addAll(list, arr);

		return list;
	}

	public static ArrayList<PartOfText> createArrayOfSentenceFromString(String line) {

		ArrayList<PartOfText> sentences = new ArrayList<PartOfText>();

		String[] arr;

		arr = line.split("((?<! (т\\.е))(\\.\\s))");

		for (String str : arr) {
			sentences.add(createSentenceFromPartOfSentence(str));
		}

		return sentences;
	}

	public static Sentence createSentenceFromPartOfSentence(String line) {

		Sentence sentence = new Sentence();

		String[] arr = line.split(" ");

		for (String str : arr) {

			if (Pattern.compile(TypeOfPartOfText.PUNCTUATION_MARK).matcher(str).find()) {

				Word word;
				PunctuationMark mark;

				if (str.contains("(")) {
					word = new Word(str.substring(1, str.length()));
					mark = new PunctuationMark(str.charAt(0));
				} else {
					word = new Word(str.substring(0, str.length() - 1));
					mark = new PunctuationMark(str.charAt(str.length() - 1));
				}
				sentence.addPart(word);

				sentence.addPart(mark);
			} else {
				Word word = new Word(str);

				sentence.addPart(word);
			}
		}
		return sentence;
	}
}