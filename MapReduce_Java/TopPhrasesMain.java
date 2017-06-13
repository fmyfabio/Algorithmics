package com.wallethub;

import java.io.IOException;
import java.util.List;

public class TopPhrasesMain {
	
	/**
	 * In this test I create an approach to collect an N given number
	 * of most used words in the file. 
	 */
	public static void main(String args[]) throws IOException {
		
		// Declaring the class to process the file
		TopPhrases topPhrases = new TopPhrases();
		
		// Executing the process of the file
		List<String> listTopPhrases = topPhrases.getTopPhrases(10, "/Users/fmy/Desktop/bigdata");
		
		// Printing the result
		System.out.println(listTopPhrases);
		
		//Result:
		//[O-82, que-49, sabe-40, ser-40, verdade-39, nao-39, a-35, e-35, pode-35, sei-33]
		
	}

	/** -------------------------------- FILE USER ON TEST --------------------------------
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Quem sera o cara mais feliz | A importancia da nao importancia | O que a gente sabe
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Quem sera o cara mais feliz | A importancia da nao importancia | O que a gente sabe
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Quem sera o cara mais feliz | A importancia da nao importancia | O que a gente sabe
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Quem sera o cara mais feliz | A importancia da nao importancia | O que a gente sabe
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Quem sera o cara mais feliz | A importancia da nao importancia | O que a gente sabe
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* O veredito precisa ser dito | Precisa ser melhor | vamos melhorar
	* Quem sabe | Dizer a verdade e importante | O dia de amanha pode nao ter
	* Quem sera o cara mais feliz | A importancia da nao importancia | O que a gente sabe
	* Sim eu sei navegar e preciso | Vou ver se preciso comprar | Quem confere
	* O que posso dizer | verdade precisa ver | quem sabe nao acontece
	* Isso tudo pode ser preciso | O dia de amanha | ninguem sabe
	* Ola pessoal tudo | Eu nao sei | Amanha pode ser
	* A verdade seja dita | O pau que o diabo amacou | vale a pena ir
	* O que podemos fazer | Melhorar e sempre bom | Sim eu sei
	* O que podemos fazer | Melhorar e sempre bom | Preo
	 */
	
}
