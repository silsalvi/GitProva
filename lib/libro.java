package lib;

public class libro {
	int code,Prezzo;
	String Descrizione,Titolo;
	public void PutID(int a) 
		
		{
			code=a;
		}
	public int GetID() 
	
		{
			return code;
		}
	public void PutDescrizione(String s)
		{
			Descrizione=s;
		}
	public String GetDescrizione()
		{
			return Descrizione;
		}
	public void PutTitolo(String s)
		{
			Titolo = s;
		}
	public String GetTitolo()
		{
				return Titolo;
		}
	
	public libro(int code, int prezzo, String descrizione, String titolo) {
		super();
		this.code = code;
		Prezzo = prezzo;
		Descrizione = descrizione;
		Titolo = titolo;
	}
	public void PutPrezzo(int a) 
		
		{
			Prezzo=a;
		}
	public int GetPrezzo() 

		{
			return Prezzo;
		}
}
