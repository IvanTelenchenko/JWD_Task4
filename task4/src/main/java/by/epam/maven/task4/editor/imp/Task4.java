package by.epam.maven.task4.editor.imp;

import java.util.List;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/*В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.*/

public class Task4 implements Task {

	@Override
	public String run(Text text) {

		String result = "";

		StringBuilder buffer = new StringBuilder();

		for (Sentence sent : text.getSentences()) {

			int first = findIndexFirstWord(sent);
			int last = findIndexLastWord(sent);

			buffer.append(getNewSentence(first, last, sent)).append("\n");
		}
		result = buffer.toString();
		return result;
	}

	public static int findIndexFirstWord(Sentence sent) {

		int i = 0;

		for (PartOfSentence part : sent.getSentence()) {
			if (part instanceof Word) {
				break;
			}
			i++;
		}

		return i;
	}

	public static int findIndexLastWord(Sentence sent) {

		int i = sent.getSentence().size() - 1;

		List<PartOfSentence> arr = sent.getSentence();

		PartOfSentence next;

		for (; i > 0; i--) {
			next = arr.get(i);
			if (next instanceof Word) {
				break;
			}
		}

		return i;
	}

	public String getNewSentence(int first, int last, Sentence sent) {

		String result = "";
		StringBuilder buffer = new StringBuilder();

		List<PartOfSentence> list = sent.getSentence();

		PartOfSentence bufferWord = list.get(first);
		list.set(first, list.get(last));
		list.set(last, bufferWord);

		for (PartOfSentence part : list) {
			buffer.append(part.toString().trim()).append(" ");
		}

		result = buffer.toString();
		return result;
	}
}