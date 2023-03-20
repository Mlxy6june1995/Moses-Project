import java.util.*;

class Word
{
	String text;
	String obfuscated;
	String plaintext;

	public static String changeNumberToCharacter(int index)
	{
		String result = "";
		switch (index)
		{
			case 0:
				result = "A";
				break;
			case 1:
				result = "B";
				break;
			case 2:
				result = "C";
				break;
			case 3:
				result = "D";
				break;
			case 4:
				result = "E";
				break;
			case 5:
				result = "F";
				break;
			case 6:
				result = "G";
				break;			
			case 7:
				result = "H";
				break;
			case 8:
				result = "I";
				break;
			case 9:
				result = "J";
				break;
			case 10:
				result = "K";
				break;
			case 11:
				result = "L";
				break;
			case 12:
				result = "M";
				break;
			case 13:
				result = "N";
				break;
			case 14:
				result = "O";
				break;
			case 15:
				result = "P";
				break;			
			case 16:
				result = "Q";
				break;
			case 17:
				result = "R";
				break;	
			case 18:
				result = "S";
				break;
			case 19:
				result = "T";
				break;
			case 20:
				result = "U";
				break;
			case 21:
				result = "V";
				break;
			case 22:
				result = "W";
				break;
			case 23:
				result = "X";
				break;
			case 24:
				result = "Y";
				break;			
			case 25:
				result = "Z";
				break;
			case 26:
				result = "0";
				break;
			case 27:
				result = "1";
				break;
			case 28:
				result = "2";
				break;
			case 29:
				result = "3";
				break;
			case 30:
				result = "4";
				break;
			case 31:
				result = "5";
				break;
			case 32:
				result = "6";
				break;
			case 33:
				result = "7";
				break;			
			case 34:
				result = "8";
				break;
			case 35:
				result = "9";
				break;		
			case 36:
				result = "(";
				break;
			case 37:
				result = ")";
				break;
			case 38:
				result = "*";
				break;
			case 39:
				result = "+";
				break;			
			case 40:
				result = ",";
				break;
			case 41:
				result = "-";
				break;	
			case 42:
				result = ".";
				break;
			case 43:
				result = "/";
				break;		
		}
		return result;
	}

	public static int changeCharacterToNumber(Character character)
	{
		int result = 0;
		switch (character)
		{
			case 'A':
				result = 0;
				break;
			case 'B':
				result = 1;
				break;
			case 'C':
				result = 2;
				break;
			case 'D':
				result = 3;
				break;
			case 'E':
				result = 4;
				break;
			case 'F':
				result = 5;
				break;
			case 'G':
				result = 6;
				break;			
			case 'H':
				result = 7;
				break;
			case 'I':
				result = 8;
				break;
			case 'J':
				result = 9;
				break;
			case 'K':
				result = 10;
				break;
			case 'L':
				result = 11;
				break;
			case 'M':
				result = 12;
				break;
			case 'N':
				result = 13;
				break;
			case 'O':
				result = 14;
				break;
			case 'P':
				result = 15;
				break;			
			case 'Q':
				result = 16;
				break;
			case 'R':
				result = 17;
				break;	
			case 'S':
				result = 18;
				break;
			case 'T':
				result = 19;
				break;
			case 'U':
				result = 20;
				break;
			case 'V':
				result = 21;
				break;
			case 'W':
				result = 22;
				break;
			case 'X':
				result = 23;
				break;
			case 'Y':
				result = 24;
				break;			
			case 'Z':
				result = 25;
				break;
			case '0':
				result = 26;
				break;
			case '1':
				result = 27;
				break;
			case '2':
				result = 28;
				break;
			case '3':
				result = 29;
				break;
			case '4':
				result = 30;
				break;
			case '5':
				result = 31;
				break;
			case '6':
				result = 32;
				break;
			case '7':
				result = 33;
				break;			
			case '8':
				result = 34;
				break;
			case '9':
				result = 35;
				break;		
			case '(':
				result = 36;
				break;
			case ')':
				result = 37;
				break;
			case '*':
				result = 38;
				break;
			case '+':
				result = 39;
				break;			
			case ',':
				result = 40;
				break;
			case '-':
				result = 41;
				break;	
			case '.':
				result = 42;
				break;
			case '/':
				result = 43;
				break;		
		}
		return result;
	}

	public String encode(String plaintext)
	{
		Random rand = new Random();
		int offset = rand.nextInt(42);
		String offsetCharacter = changeNumberToCharacter(offset);
		System.out.println("Offset Character:"+offsetCharacter);

		String encodedText = offsetCharacter;
		for(int i = 0; i < plaintext.length(); i++)
		{
			if(plaintext.charAt(i) == ' ')
			{
				encodedText += " ";
			}
			else
			{
				int encoded = (changeCharacterToNumber(plaintext.charAt(i)) - offset);
				if(encoded < 0)
				{
					encoded = 44 + encoded;
				}
				else if((encoded >= 0) && (encoded <= 43))
				{
					encoded = encoded;
				}
				else
				{
					encoded = encoded - 44;
				}
				encodedText += changeNumberToCharacter(encoded);
			}	
		}
		return encodedText;
	}

	public String decode(String encodedText)
	{
		String plainText = "";
		char offsetCharacter = encodedText.charAt(0);
		int offset = changeCharacterToNumber(offsetCharacter);
		plainText += offsetCharacter;

		for(int i = 1; i < encodedText.length(); i++)
		{
			if(encodedText.charAt(i) == ' ')
			{
				plainText += " ";
			}
			else
			{
				int decoded = changeCharacterToNumber(encodedText.charAt(i)) + offset;
				if(decoded < 0)
				{
					decoded = 43 + decoded;
				}
				else if((decoded >= 0) && (decoded <= 43))
				{
					decoded = decoded;
				}
				else
				{
					decoded = decoded - 44;
				}
				plainText += changeNumberToCharacter(decoded);
			}	
		}
		return plainText;
	}
}

public class EncoderDecoder
{
	public static void main(String[] args)
	{
		Word word = new Word();
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter word(s): ");
		String input = myObj.nextLine();
		word.text = input;

		word.obfuscated = word.encode(word.text);
		System.out.println("Encoded Text (Obfuscated String): "+word.obfuscated);

		word.plaintext = word.decode(word.obfuscated);
		System.out.println("Decoded Text (Original Plaintext): "+word.plaintext);
	}
}