package by.epam.maven.task4.editor.imp;

import java.util.TreeSet;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/*Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.*/

public class Task6 implements Task {

	@Override
	public String run(Text text) {

		String result = "";

		StringBuilder buffer = new StringBuilder();

		TreeSet<String> listWords = new TreeSet<String>();

		for (Sentence sent : text.getSentences()) {
			for (PartOfSentence part : sent.getSentence()) {
				if (part instanceof Word) {
					Character b = ((Word) part).getWord().trim().charAt(0);

					if (b.toString().matches("[ауоыиэяюеё]"))
						listWords.add(((Word) part).getWord().trim());
				}
			}
		}

		for (String str : listWords) {
			buffer.append(str).append(", ");
		}

		result = buffer.toString();
		return result;
	}
}