package fag;

public class Reserva {
    String hospede;
    String dataCheckIn;
    String dataCheckOut;
    Quarto quarto;
	public Object nomeHospede;

    public Reserva(String nomeHospede2, String dataCheckIn, String dataCheckOut, Quarto quarto) {
        this.hospede = nomeHospede2;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quarto = quarto;
    }
}

