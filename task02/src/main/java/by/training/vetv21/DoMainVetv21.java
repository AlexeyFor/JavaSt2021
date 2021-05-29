package by.training.vetv21;

/**
 * Программа — льстец. На экране высвечивается вопрос «Кто ты: мальчик или
 * девочка? Введи Д или М». В зависимости от ответа на экране должен появиться
 * текст «Мне нравятся девочки!» или «Мне нравятся мальчики!».
 * 
 * @author AlexeySupruniuk
 * @see Vetv21Logic
 * 
 */
public class DoMainVetv21 {
	public static void main(String[] args) {

		Vetv21Logic temp = new Vetv21Logic();
		System.out.println("Кто ты: мальчик или девочка? Введи Д или М");
		String answer = temp.vetv21Action();
		System.out.println(answer);
	}
}
