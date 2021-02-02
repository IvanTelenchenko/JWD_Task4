package by.epam.maven.task4.editor.imp;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/*Рассортировать слова текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове).*/

public class Task7 implements Task {

	@Override
	public String run(Text text) {

		String result = "";

		HashMap<Double, String> map = new HashMap<Double, String>();

		String buffer;
		int i = 0;
		Character ch;
		double percent;

		TreeSet<String> listWords = new TreeSet<String>();

		for (Sentence sent : text.getSentences()) {
			for (PartOfSentence part : sent.getSentence()) {
				if (part instanceof Word) {
					listWords.add(((Word) part).getWord().trim());
				}
			}
		}

		for (String word : listWords) {
			i = 0;
			for (int n = 0; n < word.length(); n++) {
				ch = word.charAt(n);
				if (ch.toString().matches("[ауоыиэяюёе]")) {
					i++;
				}
			}

			int d = word.length();

			percent = ((double) i / d) * 100;

			if (!map.containsKey(percent)) {
				map.put(percent, word);
			} else {
				buffer = map.get(percent) + ", ";
				buffer += word;
				map.put(percent, buffer);
			}
		}

		StringBuilder buffer1 = new StringBuilder();

		Map<Double, String> treeMap = new TreeMap<Double, String>(map);

		for (Map.Entry<Double, String> entry : treeMap.entrySet()) {
			buffer1.append(String.format("%2.2f", entry.getKey().doubleValue())).append("%").append("\n")
					.append(entry.getValue()).append("\n");
		}

		result = buffer1.toString();

		return result;
	}
}