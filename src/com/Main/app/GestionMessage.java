package com.Main.app;

public enum GestionMessage {
AJOUTER("Ajouter avec succes :)"),
MODIFIER("modifier avec succes :)"),
SUPPRIMER("supprimer avec succes :)"),
ERROR("Sorry :(");
	private String Message;
GestionMessage(String Message) {
	this.Message= Message;
}
public String getMessage() {
	return Message;
}

}
