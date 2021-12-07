//package ir.maktab.examination_online_system.util;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class QuestionUtil {
//
//	@SuppressWarnings("unused")
//	private static final Logger logger = LoggerFactory.getLogger(QuestionUtil.class);
//
//	public static String[] getQuestionChoices() {
//		return new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };
//	}
//
//	public static String getRightQuestionAnswer(String questionTypeName, QuestionAnswer questionAnswer) {
//
//		String rightQuestionAnswer = "Unknown";
//
//		if ("SCQ".equalsIgnoreCase(questionTypeName) || "MCQ".equalsIgnoreCase(questionTypeName)) {
//			StringBuilder tempAnswer = new StringBuilder();
//			int tempValue = questionAnswer.getBinaryValue();
//			int MAX_CHOICES_NUM = 8;
//			for (int i = MAX_CHOICES_NUM - 1; i >= 0; i--) {
//				if (tempValue >= Math.pow(2, i)) {
//					tempValue -= Math.pow(2, i);
//					tempAnswer.insert(0, QuestionUtil.getQuestionChoices()[i]);
//				}
//			}
//			rightQuestionAnswer = tempAnswer.toString();
//		} else if ("TFQ".equalsIgnoreCase(questionTypeName)) {
//			if (questionAnswer.getBinaryValue() == 1) {
//				rightQuestionAnswer = "Y";
//			} else if (questionAnswer.getBinaryValue() == 2) {
//				rightQuestionAnswer = "N";
//			}
//		} else if ("BFQ".equalsIgnoreCase(questionTypeName)) {
//			rightQuestionAnswer = questionAnswer.getShortTextValue();
//		} else if ("EQ".equalsIgnoreCase(questionTypeName)) {
//			rightQuestionAnswer = questionAnswer.getLongTextValue();
//		}
//
//		return rightQuestionAnswer;
//	}
//
//	public static boolean reviewSubmitAnswer(String questionTypeName, QuestionAnswer questionAnswer,
//											 SubmitQuestionAnswer submitQuestionAnswer) {
//
//		if ("SCQ".equalsIgnoreCase(questionTypeName) || "MCQ".equalsIgnoreCase(questionTypeName)
//				|| "TFQ".equalsIgnoreCase(questionTypeName)) {
//			return questionAnswer.getBinaryValue().equals(submitQuestionAnswer.getBinaryValue());
//		} else if ("BFQ".equalsIgnoreCase(questionTypeName)) {
//			return submitQuestionAnswer.getShortTextValue() != null
//					&& questionAnswer.getShortTextValue().trim()
//					.equalsIgnoreCase(submitQuestionAnswer.getShortTextValue().trim());
//		} else if ("EQ".equalsIgnoreCase(questionTypeName)) {
//			return submitQuestionAnswer.getLongTextValue() != null
//					&& questionAnswer.getLongTextValue().trim()
//					.equalsIgnoreCase(submitQuestionAnswer.getLongTextValue().trim());
//		} else {
//			return false;
//		}
//	}
//}
