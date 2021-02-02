package by.epam.maven.task4.entity.imp;

public class TypeOfPartOfText {

	public final static String WORD = "\\w+?";
	public final static String PUNCTUATION_MARK = "[,:;!?'\")(]";
	public final static String SENTENCE = "([A-Z|А-Я]).+?(\\.|\\!|\\?)$"; // "([A-Z|А-Я]).+?(\\.|\\!|\\?)";
	public final static String CODE_BLOCK_OPEN = "[\\/\\*|\\*\\/]";
	public final static String CODE_BLOCK = "(\\/\\*)|(\\*\\/)";
	public final static String CODE_BLOCK_CLOSE = "*/";
	public final static String END_STRING = "[\\.|!|?]";
}
