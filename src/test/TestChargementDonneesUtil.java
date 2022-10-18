package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import csvReader.ChargementDonneesUtil;
import csvReader.FormatDonneeBrut;
import csvReader.Genre;
import main.Personne;

public class TestChargementDonneesUtil {
    @Test
    public void testCharger () throws IOException {
        List<FormatDonneeBrut> l = ChargementDonneesUtil.charger("data/personnes.csv");
        assertTrue(l.get(0).toString().contentEquals("Chevallier,Vincent,1978-05-18,HOMME,1.76,79,OUI"));
        Personne p = new Personne(l.get(0));
        assertEquals("Chevallier Vincent", p.getPrenomNom());
        assertEquals(LocalDate.of(1978, 05, 18), p.getDateNaissance());
        assertEquals(Genre.HOMME, p.getGenre());
        assertEquals(176, p.getTaille());
        assertEquals(79, p.getScoreNormalise());
        assertTrue(p.isSouscription());
    }
    
    public void testNormalisation() {
    	assertEquals(0, ChargementDonneesUtil.normaliser_0_1(5, 5, 25));
    	assertEquals(0.25, ChargementDonneesUtil.normaliser_0_1(10, 5, 25));
    }
}